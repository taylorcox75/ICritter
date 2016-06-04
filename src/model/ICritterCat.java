package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Creates a cat as a type of model.LandICritter
 */

public class ICritterCat extends LandICritter
{

	public ICritterCat(String theName, Owner theOwner)
	{
		super(theName, theOwner); // Calls the super constructor on model.LandICritter
	}

	public void interact(ICritter inCritter)
	{
		super.interact(inCritter); // Calls the interact method of the model.LandICritter
	}
}
