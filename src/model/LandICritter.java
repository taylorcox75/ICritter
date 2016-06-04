/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * This Class Is Unchanged From Assignment 5
 */

package model;

/**
 * Defines a LandICritter
 * 
 * Left abstract so we can not instantiate a regular LandICritter
 */
public abstract class LandICritter extends ICritter
{

	public LandICritter(String theName, Owner theOwner)
	{
		super(theName, theOwner);
	}

	/**
	 * <b>interact</b> The LandICritter always adds other LandICritters, but never MarineICritters.
	 * 
	 * @param other
	 *            The other ICritter to interact with
	 * 
	 *
	 */
	public void interact(ICritter other)
	{

		if (other instanceof LandICritter)
			addFriend(other);

			// LandICritter doesn't add any other types of ICritters as friends, nothing else to do here
	}
}
