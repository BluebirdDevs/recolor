package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import net.minecraft.client.gui.screens.packs.TransferableSelectionList;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({
        TransferableSelectionList.PackEntry.class,
        ServerSelectionList.OnlineServerEntry.class,
        WorldSelectionList.WorldListEntry.class
})
public class IconHoverEntryMixin {
    @ModifyArg(method = "extractContent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V"), index = 4)
    private int modifyColor(int color) {
        if (color == -1601138544) {
            return Colors.previewIconHover;
        }
        return color;
    }
}
