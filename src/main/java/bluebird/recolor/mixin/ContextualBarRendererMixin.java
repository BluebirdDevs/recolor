package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
//? if >= 26.2 {
/*import net.minecraft.client.gui.contextualbar.ContextualBar;
*///?} else if >= 1.21.6 {
import net.minecraft.client.gui.contextualbar.ContextualBarRenderer;
//?} else {
/*import net.minecraft.client.gui.Gui;
*///?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

//? if >= 26.2 {
/*@Mixin(ContextualBar.class)
public interface ContextualBarRendererMixin {
*///?} else if >= 1.21.6 {
@Mixin(ContextualBarRenderer.class)
public interface ContextualBarRendererMixin {
//?} else {
/*@Mixin(Gui.class)
public class ContextualBarRendererMixin {
*///?}
//? if >= 26.1 {
    @ModifyArg(
            method = "extractExperienceLevel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)V"),
            index = 4)
    private static int recolor$ChangeXPTextColor(int x) {
        if (x == -16777216) {
            return Colors.xpTextBackground;
        } else if (x == -8323296) {
            return Colors.xpText;
        }
        return x;
    }
    //?} else if >= 1.21.6 {
    /*@ModifyArg(
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
    *///?} else {
    /*@ModifyArg(
            method = "renderExperienceLevel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;IIIZ)I"),
            index = 4)
    private static int recolor$ChangeXPTextColor(int x) {
        if (x == 0) {
            return Colors.xpTextBackground;
        } else if (x == 8453920) {
            return Colors.xpText;
        }
        return x;
    }
    *///?}

}
