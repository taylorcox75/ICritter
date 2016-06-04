/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 5
 * This Class Is Unchanged From Assignment 4
 */

package model;

/**
 * Describes a reaction an ICritter had.
 * 
 *
 */
public class ICritterReaction
{

	private Integer moodModifier;// how did this reaction affect it's mood?

	/**
	 * Creates a new ICritterReaction
	 * 
	 * @param moodMod
	 *            how was the mood modified? (positive = happier, negative = grumpier)
	 * 
	 *
	 */
	public ICritterReaction(Integer moodMod)
	{
		moodModifier = moodMod;
	}

	/**
	 * Returns the moodModifier to signify how this reaction affected the ICritter
	 * 
	 * @return Integer
	 * 
	 *
	 */
	public Integer getMoodModifier()
	{
		return moodModifier;
	}
}
