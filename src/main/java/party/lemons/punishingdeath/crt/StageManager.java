package party.lemons.punishingdeath.crt;

import net.darkhax.gamestages.capabilities.PlayerDataHandler;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Sam on 25/02/2018.
 */
public class StageManager
{
	public static Map<String, Integer> DEATH_PERCENTS = new HashMap<>();

	//will return -999 if no stage found, fix?
	public static int getStagePercent(EntityPlayer player)
	{
		int percent = -999;
		PlayerDataHandler.IStageData stages = PlayerDataHandler.getStageData(player);

		for(String key : DEATH_PERCENTS.keySet())
		{
			if(stages.hasUnlockedStage(key))
			{
				percent = DEATH_PERCENTS.get(key);
			}
		}

		return percent;
	}
}
