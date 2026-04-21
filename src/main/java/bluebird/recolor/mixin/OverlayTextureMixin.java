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
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(OverlayTexture.class)
public class OverlayTextureMixin {

    @Shadow @Final
    private DynamicTexture texture;

    @Unique
    private int lastColor;

    @ModifyArg(method = "setupOverlayColor", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setupOverlayColor(Lcom/mojang/blaze3d/textures/GpuTextureView;)V"))
    public GpuTextureView recolor$getTextureView(GpuTextureView gpuTextureView) {
        if (lastColor == Colors.damageColor) {
            return gpuTextureView;
        }
        NativeImage pixels = this.texture.getPixels();
        if (pixels == null) return gpuTextureView;
        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 16; ++x) {
                pixels.setPixel(x, y, Colors.damageColor);
            }
        }
        this.texture.upload();
        lastColor = Colors.damageColor;
        return gpuTextureView;
    }
}
