package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(WorldRenderer.class)
public class LevelRendererMixin {
    @ModifyArg(method = "drawBlockOutline", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/VertexRendering;drawOutline(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/util/shape/VoxelShape;DDDI)V"), index = 6)
    public int changeBlockOutline(int color) {
        return Colors.blockOutline;
    }
}
