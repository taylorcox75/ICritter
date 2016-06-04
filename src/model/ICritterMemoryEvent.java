package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * This class hanndles memory events
 */

public class ICritterMemoryEvent
{
	// Instance variable decalaraton
	private Treat rememberedTreat;
	private ICritterReaction RememberedReaction;

	public ICritterMemoryEvent(Treat treatIn, ICritterReaction reactionIn)
	{
		rememberedTreat = treatIn; // creates a memory event object that gets stored into an iCritter's list of memories
		RememberedReaction = reactionIn; // takes a treat and a reaction object to remember
	}

	public Treat getRememberedTreat()
	{
		return rememberedTreat; // returns the treat object from the specific memory object
	}

	public ICritterReaction getRememberedReaction()
	{
		return RememberedReaction; // returns the reaction object from the specific memory object
	}

}
