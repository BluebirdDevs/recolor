package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AnvilScreen.class)
public class AnvilScreenMixin {
    @ModifyArg(
            method = "drawForeground",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"),
            index = 4)
    public int recolors$ChangeAnvilTextColor(int og){
        if (og == 8453920) {
            return Colors.xpText;
        } else if (og == 16736352) {
            return Colors.xpAnvilTextFail;
        }
        return og;
    }
}
