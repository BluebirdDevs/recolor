package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.hud.bar.Bar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Bar.class)
public interface ContextualBarRendererMixin {
    @ModifyArg(
            method = "drawExperienceLevel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/DrawContext;drawText(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;IIIZ)V"),
            index = 4)
    private static int recolor$ChangeXPTextColor(int x) {
        if (x == -16777216) {
            return Colors.xpTextBackground;
        } else if (x == -8323296) {
            return Colors.xpText;
        }
        return x;
    }

}
