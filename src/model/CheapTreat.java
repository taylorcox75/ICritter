package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * This class handles CheapTreats child of treat class
 */

public class CheapTreat extends Treat
{

	public CheapTreat(String theTreat)
	{
		super(theTreat); // Calls the parent class

	}

	@Override
	// Overrides the getCost() of treat
	public Integer getCost()
	{
		return 1; // The cost of the treat in credits
	}

}
