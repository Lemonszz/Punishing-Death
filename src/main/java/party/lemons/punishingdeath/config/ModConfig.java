package party.lemons.punishingdeath.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Sam on 25/02/2018.
 */
@Config(modid=ModConstants.MODID)
@Mod.EventBusSubscriber
public class ModConfig
{
	@Config.RangeInt(min = 0, max = 100)
	public static int DROP_PERCENT = 0;

	@SubscribeEvent
	public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equals(ModConstants.MODID))
			ConfigManager.sync(ModConstants.MODID, Config.Type.INSTANCE);
	}
}
