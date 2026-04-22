package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.screens.advancements.AdvancementsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AdvancementsScreen.class)
public class AdvancementsScreenMixin {
    @ModifyArg(method = "extractWindow", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;text(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)V"), index = 4)
    public int changeTitleText(int x) {
        return Colors.containerTitle;
    }
}
