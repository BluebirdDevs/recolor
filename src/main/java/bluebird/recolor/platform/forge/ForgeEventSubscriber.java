package bluebird.recolor.platform.forge;

//? forge {

/*import bluebird.recolor.ColorReloadListener;
import bluebird.recolor.Main;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
//? if <= 1.21.5 {
import net.minecraftforge.eventbus.api.SubscribeEvent;
//?} else {
/^import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
^///?}
import net.minecraftforge.fml.common.Mod;

//? if >= 1.21.9 {
/^@Mod.EventBusSubscriber(modid = Main.MOD_ID)
^///?} else
@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void onReloadListener(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new ColorReloadListener());
    }
}
*///?}
