package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EnchantmentScreen.class)
public class EnchantmentScreenMixin {
    @ModifyArg(method = "extractBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)V"), index = 4)
    public int changeXpColor(int color) {
        if (color == -12550384) {
            // Darken color when unavailable
            return ((Colors.xpText & 0xFEFEFE) >> 1) | 0xFF000000;
        } else if (color == -8323296) {
            return Colors.xpText;
        }
        return color;
    }
}
