package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.gui.screen.pack.PackListWidget;
import net.minecraft.client.gui.screen.world.WorldListWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({
        PackListWidget.ResourcePackEntry.class,
        WorldListWidget.WorldEntry.class,
        MultiplayerServerListWidget.ServerEntry.class
})
public class TransferableSelectionList_PackEntryMixin {
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V"), index = 4)
    private int modifyColor(int color) {
        if (color == -1601138544) {
            return Colors.previewIconHover;
        }
        return color;
    }
}
