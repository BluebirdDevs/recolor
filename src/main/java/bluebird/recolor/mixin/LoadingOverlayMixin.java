package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.LoadingOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.function.IntSupplier;

@Mixin(LoadingOverlay.class)
public class LoadingOverlayMixin {
    @ModifyArgs(
            method = "extractRenderState",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V")
    )
    public void test(Args args) {
        if (((int) args.get(4) & 0xFFFFFF) == 0) {
            args.set(4, Colors.loadingScreenMonochrome);
        }
        else args.set(4, Colors.loadingScreen);
    }

    @Redirect(method = "extractRenderState", at = @At(value = "INVOKE", target = "Ljava/util/function/IntSupplier;getAsInt()I", ordinal = 2))
    public int redirectGetAsInt(IntSupplier intSupplier) {
        if ((intSupplier.getAsInt() & 0xFFFFFF) == 0) {
            return Colors.loadingScreenMonochrome;
        }
        return Colors.loadingScreen;
    }
}
