package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Creates a model.KeywordCollection Set based off of the model.ICritter's interests
 */

import java.util.*;

public class ICritterWorld
{

	private List<ICritter> iCritters; // Creates a list of iCritters in the World

	public ICritterWorld()
	{
		iCritters = new LinkedList<ICritter>(); // Initializes it as a Linked List
	}

	public List<ICritter> listICritters()
	{
		return iCritters; // Gets a list of all of the ICritterrs
	}

	public boolean addICritter(ICritter toAdd)
	{
		for (int i = 0; i < iCritters.size(); i++) // Iterates through the whole model.ICritter list
		{
			if (toAdd.equals(iCritters.get(i))) // If Critter 1 = Critter 2, != add
			{
				return false; // Returns false
			}
		}
		iCritters.add(toAdd); // Adds the Critter to the list if he isn't already there
		return true;
	}

	public boolean removeICritter(ICritter toRemove)
	{
		return iCritters.remove(toRemove); // API method for LinkedList searches and returns a boolean if it can remove
	}

	public void runJamboree()
	{
		for (int i = 0; i < iCritters.size(); i++) // The outer loop that goes through all of the Critters
		{
			for (int j = 0; j < iCritters.size(); j++) // The inner loop to check each Critter against another
			{
				if (iCritters.get(i).equals(iCritters.get(j)) == false) // Skips over themselves
				{
					iCritters.get(i).interact(iCritters.get(j)); // Calls interact on the other model.ICritter
				}
			}
		}
	}

}
