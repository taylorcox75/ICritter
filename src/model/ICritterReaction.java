package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * This class handles reactions of the icritter
 */

public class ICritterReaction
{

	private Integer moodModifier; // the value of how the treat affects the critters mood positive int if happy,
								// negative integer if disgusted

	public ICritterReaction(Integer reactInt)
	{
		moodModifier = reactInt; // creates a reaction passing in the wanted moodModifier value
	}

	public Integer getMoodModifier()
	{
		return moodModifier; // returns the moodModifier from a specific reaction
	}

}
