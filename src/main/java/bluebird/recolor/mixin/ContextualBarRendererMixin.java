package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.contextualbar.ContextualBarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ContextualBarRenderer.class)
public interface ContextualBarRendererMixin {
    @ModifyArg(
            method = "renderExperienceLevel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)V"),
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
