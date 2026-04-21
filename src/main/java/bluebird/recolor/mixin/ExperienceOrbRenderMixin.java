package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.ExperienceOrbRenderer;
import net.minecraft.client.renderer.entity.state.ExperienceOrbRenderState;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ExperienceOrbRenderer.class)
public class ExperienceOrbRenderMixin {
    @ModifyArgs(method = "lambda$submit$0",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ExperienceOrbRenderer;vertex(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack$Pose;FFIIIFFI)V"))
    private static void recolors$changeXpOrbColors(Args args, @Local(argsOnly = true, name = "state") ExperienceOrbRenderState state) {
        int xp1 = Colors.xpOrb1;
        int xp2 = Colors.xpOrb2;

        float t = (Mth.sin(state.ageInTicks / 2.0F) + 1.0F) * 0.5F;

        int rc = (int) Mth.lerp(t, (float)((xp1 >> 16) & 0xFF), (float)((xp2 >> 16) & 0xFF));
        int gc = (int) Mth.lerp(t, (float)((xp1 >> 8) & 0xFF), (float)((xp2 >> 8) & 0xFF));
        int bc = (int) Mth.lerp(t, (float)(xp1 & 0xFF), (float)(xp2 & 0xFF));

        args.set(4, rc);
        args.set(5, gc);
        args.set(6, bc);
    }
}
