package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EnchantmentScreen.class)
public class EnchantmentScreenMixin {
    //? if >= 26.1 {
    @ModifyArg(method = "extractBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)V"), index = 4)
    //?} else if >= 1.21.6 {
    /*@ModifyArg(method = "renderBg", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)V"), index = 4)
    *///?}
    //? if >= 1.21.6 {
    public int changeXpColor(int color) {
        if (color == -12550384) {
            // Darken color when unavailable
            return ((Colors.xpText & 0xFEFEFE) >> 1) | 0xFF000000;
        } else if (color == -8323296) {
            return Colors.xpText;
        }
        return color;
    }
    //?} else {
    /*@ModifyArg(method = "renderBg", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)I"), index = 4)
    public int changeXpColor(int color) {
        if (color == 4226832) {
            // Darken color when unavailable
            return ((Colors.xpText & 0xFEFEFE) >> 1) | 0xFF000000;
        } else if (color == 8453920) {
            return Colors.xpText;
        }
        return color;
    }
    *///?}
}
