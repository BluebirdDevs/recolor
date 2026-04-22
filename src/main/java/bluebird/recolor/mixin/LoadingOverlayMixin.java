package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.function.IntSupplier;
import net.minecraft.client.gui.screen.SplashOverlay;

@Mixin(SplashOverlay.class)
public class LoadingOverlayMixin {
    @ModifyArgs(
            method = "render",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V")
    )
    public void test(Args args) {
        if (((int) args.get(4) & 0xFFFFFF) == 0) {
            args.set(4, Colors.loadingScreenMonochrome);
        }
        else args.set(4, Colors.loadingScreen);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Ljava/util/function/IntSupplier;getAsInt()I", ordinal = 2))
    public int redirectGetAsInt(IntSupplier intSupplier) {
        if ((intSupplier.getAsInt() & 0xFFFFFF) == 0) {
            return Colors.loadingScreenMonochrome;
        }
        return Colors.loadingScreen;
    }
}
