package bluebird.recolor.mixin;

import bluebird.recolor.Colors;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(WorldRenderer.class)
public class LevelRendererMixin {
    @ModifyArgs(method = "drawBlockOutline", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;drawCuboidShapeOutline(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/util/shape/VoxelShape;DDDFFFF)V"))
    public void changeBlockOutline(Args args) {
        int color = Colors.blockOutline;
        int a = (color >> 24) & 0xFF;
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        args.set(6, r / 255.0F);
        args.set(7, g / 255.0F);
        args.set(8, b / 255.0F);
        args.set(9, a / 255.0F);
    }
}
