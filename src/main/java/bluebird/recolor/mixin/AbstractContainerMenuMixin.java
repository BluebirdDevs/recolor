package bluebird.recolor.mixin;

import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Set;

@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin {
    @Redirect(method = "doClick", at = @At(value = "INVOKE", target = "Ljava/util/Set;size()I", ordinal = 1))
    private int redirectSize(Set<?> set, int slotIndex) {
        return set.size();
    }
}
