package bluebird.recolor;

import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.jspecify.annotations.NonNull;

public class ColorReloadListener implements ResourceManagerReloadListener {
    @Override
    public void onResourceManagerReload(@NonNull ResourceManager resourceManager) {
        ColorLoader.reload(resourceManager);
    }
}
