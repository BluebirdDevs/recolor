package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ExperienceOrbRenderer;
import net.minecraft.client.renderer.entity.state.ExperienceOrbRenderState;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ExperienceOrbRenderer.class)
public class ExperienceOrbRenderMixin {

    @Shadow
    @Final
    private static void vertex(VertexConsumer vertexConsumer, PoseStack.Pose pose, float f, float g, int i, int j, int k, float h, float l, int m) {}

    @ModifyArg(method = "submit(Lnet/minecraft/client/renderer/entity/state/ExperienceOrbRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/CameraRenderState;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/SubmitNodeCollector;submitCustomGeometry(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;Lnet/minecraft/client/renderer/SubmitNodeCollector$CustomGeometryRenderer;)V"), index = 2)
    private static SubmitNodeCollector.CustomGeometryRenderer recolors$changeXpOrbColors(SubmitNodeCollector.CustomGeometryRenderer customGeometryRenderer, @Local(argsOnly = true, ordinal = 0) ExperienceOrbRenderState state, @Local(ordinal = 0) float f, @Local(ordinal = 2) float h, @Local(ordinal = 1) float g, @Local(ordinal = 3) float j) {
        int xp1 = Colors.xpOrb1;
        int xp2 = Colors.xpOrb2;

        return (pose, vertexConsumer) -> {
            float t = (Mth.sin(state.ageInTicks / 2.0F) + 1.0F) * 0.5F;

            int rc = (int) Mth.lerp(t, (float)((xp1 >> 16) & 0xFF), (float)((xp2 >> 16) & 0xFF));
            int gc = (int) Mth.lerp(t, (float)((xp1 >> 8) & 0xFF), (float)((xp2 >> 8) & 0xFF));
            int bc = (int) Mth.lerp(t, (float)(xp1 & 0xFF), (float)(xp2 & 0xFF));
            vertex(vertexConsumer, pose, -0.5F, -0.25F, rc, gc, bc, f, j, state.lightCoords);
            vertex(vertexConsumer, pose, 0.5F, -0.25F, rc, gc, bc, g, j, state.lightCoords);
            vertex(vertexConsumer, pose, 0.5F, 0.75F, rc, gc, bc, g, h, state.lightCoords);
            vertex(vertexConsumer, pose, -0.5F, 0.75F, rc, gc, bc, f, h, state.lightCoords);
        };
    }
}
