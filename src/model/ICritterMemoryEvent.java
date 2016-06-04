package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Unchanged from Assisgnment 3
 */

/**
 * Class describes an model.ICritterMemoryEvent. A memory event is used to store how an model.ICritter reacted to something.
 * ICritterMemoryEvents are stored in an model.ICritter.
 * 
 *
 */
public class ICritterMemoryEvent
{
	private Treat rememberedTreat;// the treat to remember for this event
	private ICritterReaction rememberedReaction;// the reaction to remember for this event

	/**
	 * Will create a new model.ICritterMemoryEvent.
	 * 
	 * @param theTreat
	 *            The treat to remember for this reaction
	 * 
	 * @param theReaction
	 *            How the critter reacted to theTreat.
	 * 
	 *
	 */
	public ICritterMemoryEvent(Treat theTreat, ICritterReaction theReaction)
	{
		rememberedTreat = theTreat;
		rememberedReaction = theReaction;
	}

	/**
	 * Returns the rememberedTreat
	 * 
	 * @return model.Treat {@link Treat}
	 *
	 */
	public Treat getRememberedTreat()
	{
		return rememberedTreat;
	}

	/**
	 * Returns the rememberedReaction
	 * 
	 * @return model.ICritterReaction {@link ICritterReaction}
	 */
	public ICritterReaction getRememberedReaction()
	{
		return rememberedReaction;
	}

}
