package bluebird.recolor;

import bluebird.recolor.platform.Platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import bluebird.recolor.platform.fabric.FabricPlatform;
//?} neoforge {
/*import bluebird.recolor.platform.neoforge.NeoforgePlatform;
 *///?} forge {
/*import bluebird.recolor.platform.forge.ForgePlatform;
*///?}

public class Main {

	public static final String MOD_ID = "recolor";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
	}

	public static void onInitializeClient() {
	}

	static Platform platform() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		*///?}
	}
}
