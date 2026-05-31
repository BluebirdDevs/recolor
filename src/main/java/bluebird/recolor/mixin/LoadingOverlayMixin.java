package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.LoadingOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
//? if >= 1.21.6 {
/*import org.spongepowered.asm.mixin.injection.ModifyArgs;
*///?} else {
import org.spongepowered.asm.mixin.injection.ModifyArg;
//?}
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.function.IntSupplier;

@Mixin(LoadingOverlay.class)
public class LoadingOverlayMixin {
    //? if >= 26.1 {
    /*@ModifyArgs(
            method = "extractRenderState",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V")
    )
    public void test(Args args) {
        if (((int) args.get(4) & 0xFFFFFF) == 0) {
            args.set(4, Colors.loadingScreenMonochrome);
        }
        else args.set(4, Colors.loadingScreen);
    }
    *///?} else if >= 1.21.6 {
    /*@ModifyArgs(
            method = "render",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V")
    )
    public void test(Args args) {
        if (((int) args.get(4) & 0xFFFFFF) == 0) {
            args.set(4, Colors.loadingScreenMonochrome);
        }
        else args.set(4, Colors.loadingScreen);
    }
    *///?} else {
    @ModifyArg(
            method = "render",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(Lnet/minecraft/client/renderer/RenderType;IIIII)V"), index = 5
    )
    public int test(int og) {
        if ((og & 0xFFFFFF) == 0) {
            return Colors.loadingScreenMonochrome;
        }
        return Colors.loadingScreen;
    }
    //?}

    //? if >= 26.1 {
    /*@Redirect(method = "extractRenderState", at = @At(value = "INVOKE", target = "Ljava/util/function/IntSupplier;getAsInt()I", ordinal = 2))
    *///?} else if <= 1.21.11 {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Ljava/util/function/IntSupplier;getAsInt()I", ordinal = 2))
    //?}
    public int redirectGetAsInt(IntSupplier intSupplier) {
        if ((intSupplier.getAsInt() & 0xFFFFFF) == 0) {
            return Colors.loadingScreenMonochrome;
        }
        return Colors.loadingScreen;
    }
}
