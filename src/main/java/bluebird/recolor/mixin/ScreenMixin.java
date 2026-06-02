package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Screen.class)
public class ScreenMixin {
    //? if >= 26.1 {
    @ModifyArg(method = "extractTransparentBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fillGradient(IIIIII)V"), index = 4)
    //?} else if <= 1.21.11 {
    /*@ModifyArg(method = "renderTransparentBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fillGradient(IIIIII)V"), index = 4)
    *///?}
    private int extractTransparentBackgroundTop(int color) {
        return Colors.containerBackground;
    }

    //? if >= 26.1 {
    @ModifyArg(method = "extractTransparentBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fillGradient(IIIIII)V"), index = 5)
    //?} else if <= 1.21.11 {
    /*@ModifyArg(method = "renderTransparentBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fillGradient(IIIIII)V"), index = 5)
    *///?}
    private int extractTransparentBackgroundBottom(int color) {
        if (Colors.containerBackground == -1072689136) {
            return -804253680;
        }
        return Colors.containerBackground;
    }
}
