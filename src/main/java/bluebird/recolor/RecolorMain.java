package bluebird.recolor;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecolorMain implements ClientModInitializer {
	public static final String MOD_ID = "recolor";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		ResourceLoader.get(ResourceType.CLIENT_RESOURCES).registerReloader(
				Identifier.of(MOD_ID, "recolor"),
                new ColorReloadListener()
        );
	}

	public static int lerpColor(int a, int b, float t) {
		int ar = (a >> 16) & 0xFF;
		int ag = (a >> 8) & 0xFF;
		int ab = a & 0xFF;

		int br = (b >> 16) & 0xFF;
		int bg = (b >> 8) & 0xFF;
		int bb = b & 0xFF;

		int r = (int)(ar + (br - ar) * t);
		int g = (int)(ag + (bg - ag) * t);
		int b2 = (int)(ab + (bb - ab) * t);

		return (r << 16) | (g << 8) | b2;
	}
}