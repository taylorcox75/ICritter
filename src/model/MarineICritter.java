package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * This abstract class uses model.ICritter to make a type of Critter
 */

public abstract class MarineICritter extends ICritter // Extends a class
{

	public MarineICritter(String theName, Owner theOwner)
	{
		super(theName, theOwner); // Calls super to create a new model.ICritter
	}

	public void interact(ICritter otherCritter)
	{
		if (this.interestCorrelation(otherCritter) >= 0.5) // Checks to see if their interersts are >= .5
		{
			this.addFriend(otherCritter); // Adds the friend from new critter to this instance
		}
	}

}
