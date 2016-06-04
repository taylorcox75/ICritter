/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * This Class Is Unchanged From Assignment 5
 */


package model;

/**
 * Defines a MarineICritter Left abstract to prevent the ability to instantiate it
 */
public abstract class MarineICritter extends ICritter
{

	public MarineICritter(String theName, Owner theOwner)
	{
		super(theName, theOwner);
	}

	/**
	 * <b>interact</b>
	 * <p>
	 * If this ICritter and the other ICritter have at least a 50% correlation in interests, this ICritter will befriend the
	 * other (or stalk it)
	 * 
	 * @parm other The other ICritter to interact with
	 * 
	 *
	 */
	public void interact(ICritter other)
	{
		try {
			this.interestCorrelation(other);
		} catch (NoInterestsException e) {
			addFriend(other);
			return;
		} 
		if (this.interestCorrelation(other) >= .5)// if the interest correlation between the two is at least 50%
			addFriend(other);

	}
}

