package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screen.multiplayer.SocialInteractionsPlayerListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SocialInteractionsPlayerListEntry.class)
public class PlayerEntryMixin {
    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal = 0), index = 4)
    private int extractColor(int color) {
        return Colors.socialInteractionsPlayerBackground;
    }

    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal = 1), index = 4)
    private int extractColorHidden(int color) {
        return Colors.socialInteractionsPlayerBackgroundHidden;
    }
}
