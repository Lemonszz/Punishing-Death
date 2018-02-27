package party.lemons.punishingdeath.util;

import net.minecraftforge.fml.common.Loader;

/**
 * Created by Sam on 25/02/2018.
 */
public class ModUtils
{
	public static boolean isGameStagesLoaded()
	{
		return isModLoaded("gamestages");
	}

	public static boolean isCraftTweakerLoaded()
	{
		return isModLoaded("crafttweaker");
	}

	public static boolean checkStages()
	{
		return isGameStagesLoaded() && isCraftTweakerLoaded();
	}

	public static boolean isModLoaded(String modid)
	{
		return Loader.isModLoaded(modid);
	}
}
