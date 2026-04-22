package bluebird.recolor;

import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

public class ColorReloadListener implements SimpleSynchronousResourceReloadListener {
    @Override
    public void reload(ResourceManager resourceManager) {
        ColorLoader.reload(resourceManager);
        ReloadListener.reloadAll();
    }

    @Override
    public Identifier getFabricId() {
        return Identifier.of(RecolorMain.MOD_ID, "recolor");
    }
}
