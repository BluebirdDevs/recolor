package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.ExperienceOrbEntityRenderer;
import net.minecraft.client.render.entity.state.ExperienceOrbEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ExperienceOrbEntityRenderer.class)
public class ExperienceOrbRenderMixin {

    @Shadow
    @Final
    private static void vertex(VertexConsumer vertexConsumer, MatrixStack.Entry pose, float f, float g, int i, int j, int k, float h, float l, int m) {}

    @ModifyArg(method = "render(Lnet/minecraft/client/render/entity/state/ExperienceOrbEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;submitCustom(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/RenderLayer;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue$Custom;)V"), index = 2)
    private static OrderedRenderCommandQueue.Custom recolors$changeXpOrbColors(OrderedRenderCommandQueue.Custom customGeometryRenderer, @Local(argsOnly = true, ordinal = 0) ExperienceOrbEntityRenderState state, @Local(ordinal = 0) float f, @Local(ordinal = 2) float h, @Local(ordinal = 1) float g, @Local(ordinal = 3) float j) {
        int xp1 = Colors.xpOrb1;
        int xp2 = Colors.xpOrb2;

        return (pose, vertexConsumer) -> {
            float t = (MathHelper.sin(state.age / 2.0F) + 1.0F) * 0.5F;

            int rc = (int) MathHelper.lerp(t, (float)((xp1 >> 16) & 0xFF), (float)((xp2 >> 16) & 0xFF));
            int gc = (int) MathHelper.lerp(t, (float)((xp1 >> 8) & 0xFF), (float)((xp2 >> 8) & 0xFF));
            int bc = (int) MathHelper.lerp(t, (float)(xp1 & 0xFF), (float)(xp2 & 0xFF));
            vertex(vertexConsumer, pose, -0.5F, -0.25F, rc, gc, bc, f, j, state.light);
            vertex(vertexConsumer, pose, 0.5F, -0.25F, rc, gc, bc, g, j, state.light);
            vertex(vertexConsumer, pose, 0.5F, 0.75F, rc, gc, bc, g, h, state.light);
            vertex(vertexConsumer, pose, -0.5F, 0.75F, rc, gc, bc, f, h, state.light);
        };
    }
}
