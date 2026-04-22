package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import bluebird.recolor.ReloadListener;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OverlayTexture.class)
public class OverlayTextureMixin implements ReloadListener {

    @Shadow @Final
    private NativeImageBackedTexture texture;

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    public void recolor$addReloader(CallbackInfo ci) {
        ReloadListener.addListener(this);
    }

    @Unique
    public void recolor$changeOverlayTexture() {
        NativeImage nativeImage = this.texture.getImage();

        if (nativeImage == null) return;

        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 16; ++x) {
                nativeImage.setColorArgb(x, y, Colors.damageColor);
            }
        }

        RenderSystem.activeTexture(33985);
        this.texture.bindTexture();
        nativeImage.upload(0, 0, 0, 0, 0, nativeImage.getWidth(), nativeImage.getHeight(), false, true, false, false);
        RenderSystem.activeTexture(33984);

    }

    @Override
    public void recolor$reload() {
        recolor$changeOverlayTexture();
    }
}
