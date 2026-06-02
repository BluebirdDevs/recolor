package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.ExperienceOrbRenderer;
//? >= 1.21.2 {
import net.minecraft.client.renderer.entity.state.ExperienceOrbRenderState;
//?} else {
/*import net.minecraft.world.entity.ExperienceOrb;
*///?}
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ExperienceOrbRenderer.class)
public class ExperienceOrbRenderMixin {
    //? if >= 26.1 || (>= 1.21.9 && !fabric) {
    @ModifyArgs(method = "lambda$submit$0", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ExperienceOrbRenderer;vertex(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack$Pose;FFIIIFFI)V"))
    //?} else if >= 1.21.9 {
    /*@ModifyArgs(method = "method_72982", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ExperienceOrbRenderer;vertex(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack$Pose;FFIIIFFI)V"))
    *///?} else if >= 1.21.2 {
    /*@ModifyArgs(method = "render(Lnet/minecraft/client/renderer/entity/state/ExperienceOrbRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ExperienceOrbRenderer;vertex(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack$Pose;FFIIIFFI)V"))
    *///?} else {
    /*@ModifyArgs(method = "render(Lnet/minecraft/world/entity/ExperienceOrb;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ExperienceOrbRenderer;vertex(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack$Pose;FFIIIFFI)V"))
    *///?}
    //? >= 1.21.2 {
    private static void recolors$changeXpOrbColors(Args args, @Local(argsOnly = true, ordinal = 0) ExperienceOrbRenderState state) {
    //?} else {
    /*private static void recolors$changeXpOrbColors(Args args, @Local(argsOnly = true, ordinal = 0) ExperienceOrb state) {
    *///?}
        int xp1 = Colors.xpOrb1;
        int xp2 = Colors.xpOrb2;

        //? >= 1.21.2 {
        float t = (Mth.sin(state.ageInTicks / 2.0F) + 1.0F) * 0.5F;
        //?} else {
        /*float t = (Mth.sin(state.tickCount / 2.0F) + 1.0F) * 0.5F;
        *///?}

        int rc = (int) Mth.lerp(t, (float)((xp1 >> 16) & 0xFF), (float)((xp2 >> 16) & 0xFF));
        int gc = (int) Mth.lerp(t, (float)((xp1 >> 8) & 0xFF), (float)((xp2 >> 8) & 0xFF));
        int bc = (int) Mth.lerp(t, (float)(xp1 & 0xFF), (float)(xp2 & 0xFF));

        args.set(4, rc);
        args.set(5, gc);
        args.set(6, bc);
    }
}
