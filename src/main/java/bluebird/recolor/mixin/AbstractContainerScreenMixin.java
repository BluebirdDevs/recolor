package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Set;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin {
    @Shadow
    private int quickCraftingType;

    @Redirect(method = "renderSlot", at = @At(value = "INVOKE", target = "Ljava/util/Set;size()I", ordinal = 0))
    public int test(Set<Slot> instance){
        return this.quickCraftingType == 2 ? 0 : instance.size();
    }

    @ModifyArg(method = "renderLabels", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)V"), index = 4)
    public int extractLabels(int color) {
        return Colors.containerTitle;
    }

    @ModifyArg(method = "renderSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V"), index = 4)
    public int extractslotbackgruond(int color) {
        return Colors.slotDragBackground;
    }
}
