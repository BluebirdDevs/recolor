package bluebird.recolor.platform.fabric;

//? fabric {

import bluebird.recolor.ColorReloadListener;
import bluebird.recolor.Main;
//? if >= 1.21.9 {
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
//?} else {
/*import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;
*///?}
public class FabricEventSubscriber {

	public static void registerEvents() {
		//? if >= 26.1 {
		ResourceLoader.get(PackType.CLIENT_RESOURCES).registerReloadListener(
				Identifier.fromNamespaceAndPath(Main.MOD_ID, "recolor"),
				new ColorReloadListener()
		);
		//?} else if >= 1.21.9 {
		/*ResourceLoader.get(PackType.CLIENT_RESOURCES).registerReloader(
				Identifier.fromNamespaceAndPath(Main.MOD_ID, "recolor"),
				new ColorReloadListener()
		);
		*///?} else {
		/*ResourceManagerHelper.get(PackType.CLIENT_RESOURCES)
				.registerReloadListener(new ColorReloadListener());
		*///?}
	}
}
//?}
