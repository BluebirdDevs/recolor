package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GuiGraphics.class)
public class GuiGraphicsExtractorMixin {
    @ModifyArg(method = "renderItemCooldown", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;fill(Lcom/mojang/blaze3d/pipeline/RenderPipeline;IIIII)V"), index = 5)
    private int colorCooldown(int color) {
        return Colors.cooldown;
    }
}
