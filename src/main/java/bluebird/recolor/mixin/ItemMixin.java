package bluebird.recolor.mixin;

import bluebird.recolor.RecolorMain;
import net.minecraft.item.Item;
import bluebird.recolor.Colors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Item.class)
public class ItemMixin {
    @Redirect(method = "getItemBarColor", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;hsvToRgb(FFF)I"))
    public int recolor$ChangeDurabilityBarColor(float hue, float saturation, float value) {
        float healthPercentage = hue * 3.0F;

        int c1 = Colors.durabilityBarFull;
        int c2 = Colors.durabilityBarHalf;
        int c3 = Colors.durabilityBarBroken;

        int color;
        if (healthPercentage > 0.5f) {
            float t = (healthPercentage - 0.5f) / 0.5f;
            color = RecolorMain.lerpColor(c2, c1, t);
        } else {
            float t = healthPercentage / 0.5f;
            color = RecolorMain.lerpColor(c3, c2, t);
        }

        return color;
    }
}
