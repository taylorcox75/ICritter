package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * Handles iCritter objects and stores memory events
 */

import java.util.*;

public class ICritter
{
	// Instance Variables
	private String name;
	private List<ICritterMemoryEvent> memories = new ArrayList<ICritterMemoryEvent>();
	private Owner owner;

	public ICritter(String nameIn, Owner ownerIn)
	{
		name = nameIn; // establishes the name and owner of an model.ICritter object
		owner = ownerIn;
	}

	public ICritterReaction receiveTreat(Treat treatIn)
	{
		return this.consumeTreat(treatIn); // returns the model.ICritterReaction that is created when consumeTreat() is called
											// and passes in the treat to consumeTreat() that is passed into itself.
	}

	public List<ICritterMemoryEvent> getMemories()
	{
		return memories; // returns memories
	}

	public Owner getOwner()
	{
		return owner; // returns owner
	}

	public String getName()
	{
		return name; // returns name
	}

	public void addMemoryEvent(Treat treatIn, ICritterReaction reaction)
	{
		ICritterMemoryEvent event = new ICritterMemoryEvent(treatIn, reaction);// creates memory even
		memories.add(event); // stores it into the model.ICritter's list of memories(memories only created when a treat is consumed
								// for now)
	}

	public ICritterReaction consumeTreat(Treat treatIn)
	{
		ICritterReaction reaction = new ICritterReaction(1); // 1 for now because the assignment says always happy, positive
		this.addMemoryEvent(treatIn, reaction);// adds a memory event object to the list of an model.ICritter's memories

		return reaction;
	}
}
