package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 3
 * This class handles the owner including credits, and has lists to store treats
 */

import java.util.*;

public class Owner
{
	// Creates the instance variables for the critter, treats, and the credits
	private ICritter iCritter;
	private ArrayList<Treat> treats = new ArrayList<Treat>();
	private Integer credits;

	public Owner() // Constructor takes no arguments
	{
		String name = "ladyBug"; // The name of the new Critter
		iCritter = new ICritter(name, this); // Creates a new critter with the name we gave and 'this' as the owner
		credits = 10; // Default credits are 10
	}

	public ICritterReaction giveTreat(Treat toGive)
	{

		for (int i = 0; i < treats.size(); i++) // Want to see if we have the treat we want to give
		{
			if (treats.get(i).equals(toGive))
			{
				treats.remove(i); // If we have the treat, remove it so we can give it to the critter
				return iCritter.receiveTreat(toGive); // Gives the critter the treat
			}
		}

		return null; // Returns null if the treat is not present

	}

	public CheapTreat buyCheapTreat(String toAdd)
	{
		CheapTreat newTreat = new CheapTreat(toAdd); // Creates a model.Treat object of the new treat.

		if (credits >= newTreat.getCost()) // Checks to see if we have the proper amount of credits.
		{

			addTreat(newTreat); // Adds the treat if we have the money
			adjustCredits(-newTreat.getCost()); // - The cost of the credits from what we have.

			return newTreat; // Returns the new model.Treat we just added
		}

		return null; // If can't add, return null.
	}

	public ArrayList<Treat> listTreats() // The array list of our treats
	{

		ArrayList<Treat> toReturn = new ArrayList<Treat>(); // Creates an array to copy the contents

		for (int i = 0; i < treats.size(); i++)
		{
			toReturn.add(treats.get(i)); // Copies location i of treats to our to return array
		}
		return toReturn; // Returns the array
	}

	public ICritter getCritter()
	{

		return iCritter; // Returns the critter
	}

	public Integer getCredits()
	{

		return credits; // Returns the credits
	}

	private void adjustCredits(Integer toAdjust)
	{
		credits = credits + toAdjust; // Adjusts the credits by adding what to adjust
	}

	private void addTreat(Treat treatToAdd)
	{
		treats.add(treatToAdd); // Adds the treat to our array
	}

}
