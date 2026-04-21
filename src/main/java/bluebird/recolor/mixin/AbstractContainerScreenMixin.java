package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin {
    @Shadow
    private int quickCraftingType;

    // Bring back pre 1.9 item drag
    @Inject(method = "extractCarriedItem", at = @At(value = "INVOKE", target = "Ljava/lang/String;valueOf(Ljava/lang/Object;)Ljava/lang/String;"))
    public void test(GuiGraphicsExtractor graphics, int mouseX, int mouseY, CallbackInfo ci, @Local(name = "carried") ItemStack carried) {
        carried.setCount(1);
    }

    @Redirect(method = "extractSlot", at = @At(value = "INVOKE", target = "Ljava/util/Set;size()I", ordinal = 0))
    public int test(Set<Slot> instance){
        return this.quickCraftingType == 2 ? 0 : instance.size();
    }

    @ModifyArg(method = "extractLabels", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)V"), index = 4)
    public int extractLabels(int color) {
        return Colors.containerTitle;
    }

    @ModifyArg(method = "extractSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V"), index = 4)
    public int extractslotbackgruond(int color) {
        return Colors.slotDragBackground;
    }
}
