package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OverlayTexture.class)
public class OverlayTextureMixin {

    @Shadow @Final
    private DynamicTexture texture;

    @Unique
    private int lastColor;

    @Inject(method = "getTextureView", at = @At(value = "HEAD"))
    public void recolor$getTextureView(CallbackInfoReturnable<GpuTextureView> cir) {
        if (lastColor == Colors.damageColor) {
            return; // Don't update every tick
        }
        NativeImage pixels = this.texture.getPixels();
        if (pixels == null) return;
        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 16; ++x) {
                pixels.setPixel(x, y, Colors.damageColor);
            }
        }
        this.texture.upload();
        lastColor = Colors.damageColor;
    }
}
