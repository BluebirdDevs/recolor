package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.IntSupplier;
import net.minecraft.client.gui.screen.SplashOverlay;

@Mixin(SplashOverlay.class)
public class LoadingOverlayMixin {
    @ModifyArg(
            method = "render",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(Lnet/minecraft/client/render/RenderLayer;IIIII)V"), index = 5
    )
    public int test(int og) {
        if ((og & 0xFFFFFF) == 0) {
            return Colors.loadingScreenMonochrome;
        }
        else return Colors.loadingScreen;
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Ljava/util/function/IntSupplier;getAsInt()I", ordinal = 2))
    public int redirectGetAsInt(IntSupplier intSupplier) {
        if ((intSupplier.getAsInt() & 0xFFFFFF) == 0) {
            return Colors.loadingScreenMonochrome;
        }
        return Colors.loadingScreen;
    }
}
