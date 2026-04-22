package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Screen.class)
public class ScreenMixin {
    @ModifyArg(method = "renderInGameBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fillGradient(IIIIII)V"), index = 4)
    private int extractTransparentBackgroundTop(int color) {
        return Colors.containerBackground;
    }

    @ModifyArg(method = "renderInGameBackground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fillGradient(IIIIII)V"), index = 5)
    private int extractTransparentBackgroundBottom(int color) {
        if (Colors.containerBackground == -1072689136) {
            return -804253680;
        }
        return Colors.containerBackground;
    }
}
