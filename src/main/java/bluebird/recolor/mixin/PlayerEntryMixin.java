package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.social.PlayerEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerEntry.class)
public class PlayerEntryMixin {
    //? if >= 26.1 {
    /*@ModifyArg(method = "extractContent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V", ordinal = 0), index = 4)
    *///?} else >= 1.21.9 {
    /*@ModifyArg(method = "renderContent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V", ordinal = 0), index = 4)
    *///?} else {
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V", ordinal = 0), index = 4)
    //?}
    private int extractColor(int color) {
        return Colors.socialInteractionsPlayerBackground;
    }

    //? if >= 26.1 {
    /*@ModifyArg(method = "extractContent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V", ordinal = 1), index = 4)
    *///?} else if >= 1.21.9 {
    /*@ModifyArg(method = "renderContent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V", ordinal = 1), index = 4)
    *///?} else {
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V", ordinal = 1), index = 4)
    //?}
    private int extractColorHidden(int color) {
        return Colors.socialInteractionsPlayerBackgroundHidden;
    }
}
