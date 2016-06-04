package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Creates a dog as a type of land critter
 */

public class ICritterDog extends LandICritter
{ // Extends the model.LandICritter class

	public ICritterDog(String theName, Owner theOwner)
	{
		super(theName, theOwner); // Calls the model.LandICritter constructor
	}

	public void interact(ICritter inCritter)
	{
		super.interact(inCritter); // Calls the interact method of the critter type
	}
}
