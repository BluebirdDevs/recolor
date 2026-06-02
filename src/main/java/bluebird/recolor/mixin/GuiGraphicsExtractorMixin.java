package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
//? if >= 26.1 {
import net.minecraft.client.gui.GuiGraphicsExtractor;
//?} else if <= 1.21.11 {
/*import net.minecraft.client.gui.GuiGraphics;
*///?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
//? if >= 26.1 {
@Mixin(GuiGraphicsExtractor.class)
//?} else if <= 1.21.11 {
/*@Mixin(GuiGraphics.class)
*///?}
public class GuiGraphicsExtractorMixin {
    //? if >= 26.1 {
    @ModifyArg(method = "itemCooldown", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(Lcom/mojang/blaze3d/pipeline/RenderPipeline;IIIII)V"), index = 5)
    //?} else if >= 1.21.6 {
    /*@ModifyArg(method = "renderItemCooldown", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(Lcom/mojang/blaze3d/pipeline/RenderPipeline;IIIII)V"), index = 5)
    *///?} else if >= 1.21.2 {
    /*@ModifyArg(method = "renderItemCooldown", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(Lnet/minecraft/client/renderer/RenderType;IIIIII)V"), index = 6)
    *///?} else {
    /*@ModifyArg(method = "renderItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(Lnet/minecraft/client/renderer/RenderType;IIIII)V", ordinal = 2), index = 5)
    *///?}
    private int colorCooldown(int color) {
        return Colors.cooldown;
    }
}
