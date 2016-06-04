package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * This class handles FancyTreats child of treat class
 */

public class FancyTreat extends Treat
{

	FancyTreat(String theTreat)
	{
		super(theTreat); // Calls the parent class

	}

	@Override
	public Integer getCost() // Overrides the getCost() of treat
	{
		return 5; // Returns the cost of credits to buy
	}

}
