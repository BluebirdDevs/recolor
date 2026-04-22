package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(InGameHud.class)
public class ContextualBarRendererMixin {
    @ModifyArg(
            method = "renderExperienceLevel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/DrawContext;drawText(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;IIIZ)I"),
            index = 4)
    private static int recolor$ChangeXPTextColor(int x) {
        if (x == 0) {
            return Colors.xpTextBackground;
        } else if (x == 8453920) {
            return Colors.xpText;
        }
        return x;
    }

}
