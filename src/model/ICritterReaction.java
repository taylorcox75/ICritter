package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Unchanged from Assignment 3
 */

import java.util.*;

/**
 * Describes a reaction an model.ICritter had.
 * 
 *
 */
public class ICritterReaction
{

	private Integer moodModifier;// how did this reaction affect it's mood?

	/**
	 * Creates a new model.ICritterReaction
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
	 * Returns the moodModifier to signify how this reaction affected the model.ICritter
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
