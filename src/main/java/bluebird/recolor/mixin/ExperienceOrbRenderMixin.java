package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.entity.ExperienceOrbEntityRenderer;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ExperienceOrbEntityRenderer.class)
public class ExperienceOrbRenderMixin {
    @ModifyArgs(method = "render(Lnet/minecraft/entity/ExperienceOrbEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/ExperienceOrbEntityRenderer;vertex(Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/client/util/math/MatrixStack$Entry;FFIIIFFI)V"))
    private static void recolors$changeXpOrbColors(Args args, @Local(argsOnly = true, ordinal = 0) ExperienceOrbEntity state) {
        int xp1 = Colors.xpOrb1;
        int xp2 = Colors.xpOrb2;

        float t = (MathHelper.sin(state.age / 2.0F) + 1.0F) * 0.5F;

        int rc = (int) MathHelper.lerp(t, (float)((xp1 >> 16) & 0xFF), (float)((xp2 >> 16) & 0xFF));
        int gc = (int) MathHelper.lerp(t, (float)((xp1 >> 8) & 0xFF), (float)((xp2 >> 8) & 0xFF));
        int bc = (int) MathHelper.lerp(t, (float)(xp1 & 0xFF), (float)(xp2 & 0xFF));

        args.set(4, rc);
        args.set(5, gc);
        args.set(6, bc);
    }
}
