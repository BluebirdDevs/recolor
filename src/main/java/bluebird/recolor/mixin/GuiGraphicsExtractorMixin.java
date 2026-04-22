package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(DrawContext.class)
public class GuiGraphicsExtractorMixin {
    @ModifyArg(method = "drawCooldownProgress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(Lcom/mojang/blaze3d/pipeline/RenderPipeline;IIIII)V"), index = 5)
    private int colorCooldown(int color) {
        return Colors.cooldown;
    }
}
