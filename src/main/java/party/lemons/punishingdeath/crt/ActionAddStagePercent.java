package party.lemons.punishingdeath.crt;

import crafttweaker.IAction;

/**
 * Created by Sam on 25/02/2018.
 */
public class ActionAddStagePercent implements IAction
{
	private final String stage;
	private final int percent;

	public ActionAddStagePercent(String stage, int percent)
	{
		this.stage = stage;
		this.percent = percent;
	}

	@Override
	public String describe()
	{
		return "Player's will lose " + percent + "% of items with stage " + stage + ".";
	}

	@Override
	public void apply()
	{
		StageManager.DEATH_PERCENTS.put(stage, percent);
	}
}
