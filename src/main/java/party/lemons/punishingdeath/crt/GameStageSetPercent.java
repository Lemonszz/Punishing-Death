package party.lemons.punishingdeath.crt;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by Sam on 25/02/2018.
 */
@ZenRegister
@ZenClass("mods.PunishingDeath")
public class GameStageSetPercent
{
	@ZenMethod
	public static void addStagePercent(String stage, int percent)
	{
		CraftTweakerAPI.apply(new ActionAddStagePercent(stage, percent));
	}
}
