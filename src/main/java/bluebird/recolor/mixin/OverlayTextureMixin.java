package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import com.mojang.blaze3d.platform.NativeImage;
//? if >= 1.21.5 {
import com.mojang.blaze3d.textures.GpuTextureView;
//?} else {
/*import bluebird.recolor.ReloadListener;
import com.mojang.blaze3d.systems.RenderSystem;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
*///?}
//? if <= 1.21.1 {
/*import net.minecraft.util.FastColor;
*///?}
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OverlayTexture.class)
//? if >= 1.21.5 {
public class OverlayTextureMixin {
//?} else {
/*public class OverlayTextureMixin implements ReloadListener {
*///?}
    @Shadow @Final
    private DynamicTexture texture;

    //? if >= 1.21.5 {
    @Unique
    private int lastColor;
    //?}

    //? if >= 1.21.11 {
    @Inject(method = "getTextureView", at = @At(value = "HEAD"))
    public void recolor$getTextureView(CallbackInfoReturnable<GpuTextureView> cir) {
        if (lastColor == Colors.damageColor) {
            return; // Don't update every tick
        }
        NativeImage pixels = this.texture.getPixels();
        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 16; ++x) {
                pixels.setPixel(x, y, Colors.damageColor);
            }
        }
        this.texture.upload();
        lastColor = Colors.damageColor;
    }
    //?} else if >= 1.21.5 {
    /*@ModifyArg(method = "setupOverlayColor", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setupOverlayColor(Lcom/mojang/blaze3d/textures/GpuTextureView;)V"))
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
    *///?} else {
    /*@Inject(method = "<init>", at = @At(value = "TAIL"))
    public void recolor$addReloader(CallbackInfo ci) {
        ReloadListener.addListener(this);
    }

    @Unique
    public void recolor$changeOverlayTexture() {
        NativeImage nativeImage = this.texture.getPixels();
        if (nativeImage == null) return;

        //? <= 1.21.1 {
        /^int color = Colors.damageColor;
        int a = (color >> 24) & 0xFF;
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        int newColor = FastColor.ARGB32.color(a, b, g, r);
        ^///?}

        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 16; ++x) {
                //? >= 1.21.2 {
                nativeImage.setPixel(x, y, Colors.damageColor);
                //?} else {
                /^nativeImage.setPixelRGBA(x, y, newColor);
                ^///?}
            }
        }

        RenderSystem.activeTexture(33985);
        this.texture.bind();
        //? if >= 1.21.4 {
        this.texture.setFilter(false, false);
        this.texture.setClamp(true);
        nativeImage.upload(0, 0, 0, 0, 0, nativeImage.getWidth(), nativeImage.getHeight(), false);
        //?} else {
        /^nativeImage.upload(0, 0, 0, 0, 0, nativeImage.getWidth(), nativeImage.getHeight(), false, true, false, false);
        ^///?}
        RenderSystem.activeTexture(33984);

    }

    @Override
    public void recolor$reload() {
        recolor$changeOverlayTexture();
    }
    *///?}
}
