package bluebird.recolor.platform.neoforge;

//? neoforge {

import bluebird.recolor.ColorReloadListener;
import bluebird.recolor.Main;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
//? if >= 1.21.4 {
import net.neoforged.neoforge.client.event.AddClientReloadListenersEvent;
//?} else {
/*import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
*///?}

//? if <= 1.20.3 {
/*import net.neoforged.fml.common.Mod;
*///?} else {
import net.neoforged.fml.common.EventBusSubscriber;
//?}

//? if <= 1.20.3 {
/*@Mod.EventBusSubscriber
*///?} else if >= 1.21.4 {
@EventBusSubscriber
//?} else {
/*@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
*///?}
public class NeoforgeEventSubscriber {

    //? if >= 1.21.4 {
	@SubscribeEvent
    public static void onRegisterReloadListeners(AddClientReloadListenersEvent event) {
        event.addListener(ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, "recolor"), new ColorReloadListener());
    }
    //?} else {
    /*@SubscribeEvent
    public static void onReloadListener(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new ColorReloadListener());
    }
    *///?}
}
//?}
