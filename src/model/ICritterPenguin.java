package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Penguin type of model.ICritter
 */

public class ICritterPenguin extends MarineICritter
{ // Extends the model.MarineICritter

	public ICritterPenguin(String theName, Owner theOwner)
	{
		super(theName, theOwner); // Calls super on this class
	}

	public void interact(ICritter inCritter)
	{
		super.interact(inCritter); // To interact it calls super
	}
}
