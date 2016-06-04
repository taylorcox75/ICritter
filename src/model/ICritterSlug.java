/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * Creates a new ICritter Instance and implements an interact method
 * Catches exceptions as well
 */

package model;

public class ICritterSlug extends LandICritter
{
	/*
	 * ICritterSlug Constructor
	 * 
	 * Takes in a String and Owner object Calls Super to create the ICritter
	 * 
	 * Exends Land so all objects are of land type.
	 */
	public ICritterSlug(String theName, Owner theOwner)
	{
		// Calls super to construct it
		super(theName, theOwner);
	}

	/*
	 * Interact Override
	 * 
	 * Overrides the LandICritter interact
	 * 
	 * Adds people only who throw an exception, which they catch
	 */
	@Override
	public void interact(ICritter other)
	{
		try
		// Tries to execute the code
		{
			this.interestCorrelation(other); // Checking their IC
		} catch (NoInterestsException e)
		{
			addFriend(other); // Adds them as a friend if an exception is thrown
		}
	}
}
