package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * This class extends model.ICritter and is used to make objects
 */

public abstract class LandICritter extends ICritter
{ // Extends the model.ICritter

	public LandICritter(String theName, Owner theOwner)
	{
		super(theName, theOwner); // Calls the constructor of model.ICritter
	}

	public void interact(ICritter otherCritter)
	{
		if (otherCritter instanceof LandICritter) // If they are both land critters, they can interact
		{
			this.addFriend(otherCritter); // Adds the new Critter as a friend
		}
	}
}
