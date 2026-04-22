package bluebird.recolor;

import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;

public class ColorReloadListener implements SynchronousResourceReloader {
    @Override
    public void reload(ResourceManager resourceManager) {
        ColorLoader.reload(resourceManager);
    }
}
