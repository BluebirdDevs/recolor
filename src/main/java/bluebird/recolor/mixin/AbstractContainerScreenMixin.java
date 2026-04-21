package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin {
    @ModifyArg(method = "renderLabels", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)V"), index = 4)
    public int extractLabels(int color) {
        return Colors.containerTitle;
    }

    @ModifyArg(method = "renderSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V"), index = 4)
    public int extractslotbackgruond(int color) {
        return Colors.slotDragBackground;
    }
}
