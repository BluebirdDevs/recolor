package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.packs.TransferableSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TransferableSelectionList.PackEntry.class)
public class TransferableSelectionList_PackEntryMixin {
    @ModifyArg(method = "renderContent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(IIIII)V"), index = 4)
    private int modifyColor(int color) {
        if (color == -1601138544) {
            return Colors.previewIconHover;
        }
        return color;
    }
}
