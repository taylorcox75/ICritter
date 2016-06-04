package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * This class handles model.Treat objects, parent of model.CheapTreat and model.FancyTreat
 */

import java.util.*;

public abstract class Treat
{
	private String description; // The instance variable for the description of the treat

	public Treat(String theTreat)
	{
		description = theTreat; // Setting the description of the treat to the passed in value

	}

	public Integer getCost() // This method was overridden in CheapTreats and FancyTreats so it does nothing
	{

		Integer toReturn = 0;

		return toReturn;
	}

	public String getDescription()
	{
		String toReturn = description; // Returns the description

		return toReturn;
	}
}
