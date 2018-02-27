package party.lemons.punishingdeath;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import party.lemons.punishingdeath.config.ModConfig;
import party.lemons.punishingdeath.config.ModConstants;
import party.lemons.punishingdeath.crt.StageManager;
import party.lemons.punishingdeath.util.ModUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sam on 25/02/2018.
 */
@Mod.EventBusSubscriber
public class DeathManager
{
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onDeath(PlayerDropsEvent event)
	{
		World world = event.getEntityPlayer().world;
		EntityPlayer player = event.getEntityPlayer();
		List<EntityItem> dropEntities = event.getDrops();

		if(world.isRemote) return;
		if(player instanceof FakePlayer) return;
		if(world.getGameRules().getBoolean("keepInventory")) return;
		if(dropEntities.isEmpty()) return;

		float percentDropped = getPercentage(player);
		if(percentDropped == 1.0F) return;

		Collections.shuffle(dropEntities);
		float killAmount = (float)(dropEntities.size() - Math.floor((float)dropEntities.size() * percentDropped));

		List<EntityItem> toKill = new ArrayList<>();
		for(int i = 0; i < killAmount; i++)
		{
			toKill.add(dropEntities.get(i));
		}

		for(EntityItem item : toKill)
		{
			item.setDead();
			dropEntities.remove(item);
		}
	}

	public static float getPercentage(EntityPlayer player)
	{
		int percent = ModConfig.DROP_PERCENT;
		if(ModUtils.checkStages())
		{
			int stagePercent = StageManager.getStagePercent(player);
			if(stagePercent != -999)
			{
				percent = stagePercent;
			}
		}
		return (float)percent / 100F;
	}
}
