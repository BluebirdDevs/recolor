package bluebird.recolor;
//? if >= 1.21.9 || !fabric {
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

public class ColorReloadListener implements ResourceManagerReloadListener {
    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        ColorLoader.reload(resourceManager);
        //? if <= 1.21.4 {
        /*ReloadListener.reloadAll();
        *///?}
    }
}
//?} else {
/*import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;

public class ColorReloadListener implements SimpleSynchronousResourceReloadListener {
    @Override
    public Identifier getFabricId() {
        return Identifier.fromNamespaceAndPath(Main.MOD_ID, "recolor");
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        ColorLoader.reload(resourceManager);
        //? if <= 1.21.4 {
        ReloadListener.reloadAll();
        //?}
    }
}
*///?}