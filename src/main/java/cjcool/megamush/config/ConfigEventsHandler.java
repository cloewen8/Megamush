package cjcool.megamush.config;

import cjcool.megamush.core.Megamush;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigEventsHandler {
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(ConfigValues.ID) && Megamush.CONFIGURATIONS.hasChanged()) {
			ConfigValues.load();
		}
	}
}
