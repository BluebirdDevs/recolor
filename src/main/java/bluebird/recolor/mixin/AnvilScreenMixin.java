package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AnvilScreen.class)
public class AnvilScreenMixin {
    @ModifyArg(
            method = "extractLabels",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)V"),
            index = 4)
    public int recolors$ChangeAnvilTextColor(int og){
        if (og == -8323296) {
            return Colors.xpText;
        } else if (og == -40864) {
            return Colors.xpAnvilTextFail;
        }
        return og;
    }
}
