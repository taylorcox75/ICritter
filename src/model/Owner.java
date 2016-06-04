package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * This class was unchanged from Assignment 3
 */

import java.util.*;

/**
 * Describes an model.Owner. An owner owns an model.ICritter and has money to buy Treats for his/her/it's model.ICritter
 * 
 *
 */
public class Owner
{
	private ICritter iCritter;// the critter
	private List<Treat> treats;// a list of all the treats owned by this owner
	private Integer credits;// the number of credits this owner has

	/**
	 * <b>model.Owner</b>
	 * <p>
	 * Constructs a new model.Owner. During construction, the owner will create an model.ICritter to own as well.
	 * 
	 *
	 */
	public Owner()
	{
		// create our new model.ICritter with it's name and this model.Owner as the model.Owner.
		iCritter = new ICritterDog("John's model.ICritter", this);

		credits = 10;// owner starts with 10 credits

		// initialize treats to an empty linkedList.
		treats = new LinkedList<Treat>();
	}

	/**
	 * <b>giveTreat</b>
	 * <p>
	 * Gives a treat to this owner's model.ICritter and returns the model.ICritter's reaction. If the owner does not own the treat, this
	 * method will return null. Once finished, this owner will no longer own the treat passed in.
	 * 
	 * @param theTreat
	 *            The treat to give to the model.ICritter. {@link Treat}
	 * 
	 * @return model.ICritterReaction {@link ICritterReaction}
	 * 
	 *
	 */
	public ICritterReaction giveTreat(Treat theTreat)
	{
		if (treats.contains(theTreat))
		{// does the owner own the treat?
			treats.remove(theTreat);// remove the treat from our treats list
			return iCritter.receiveTreat(theTreat);// return the model.ICritter's reaction
		} else
			return null;// owner does not own the treat
	}

	/**
	 * <b>buyCheapTreat</b>
	 * <p>
	 * Buys a cheap treat with the given description and adds it to the owner's treats list. If the model.Owner does not have
	 * enough credits, the treat will not be bought and the treat will not be added, this method will also return null. If
	 * the model.Owner does have enough credits, the treat will be bought and the treat returned.
	 * 
	 * @param desc
	 *            The description of the treat requested to be bought.
	 * 
	 * @return {@link CheapTreat}
	 * 
	 *
	 */
	public CheapTreat buyCheapTreat(String desc)
	{
		// create the cheapTreat
		CheapTreat theTreat = new CheapTreat(desc);

		if (credits >= theTreat.getCost())
		{// if we have enough money
			credits -= theTreat.getCost();// subtract the credits
			addTreat(theTreat);// add our treat to our treat stockpile
			return theTreat;// return the treat
		} else
		{// otherwise return null
			return null;
		}
	}

	/**
	 * <b>listTreats</b>
	 * <p>
	 * This will return a list of treats owned by the owner. This list may be empty.
	 * 
	 * @return List<model.Treat> {@link Treat}
	 * 
	 *
	 */
	public List<Treat> listTreats()
	{
		return treats;// returns our list of treats
	}

	/**
	 * <b>getCritter</b>
	 * <p>
	 * Returns a reference to the critter owned by this model.Owner.
	 * 
	 * @return {@link ICritter}
	 * 
	 *
	 */
	public ICritter getCritter()
	{
		return iCritter;
	}

	/**
	 * <b>getCredits</b>
	 * <p>
	 * Returns the number of credits this owner has.
	 * 
	 * @return Integer
	 * 
	 *
	 */
	public Integer getCredits()
	{
		return credits;
	}

	/**
	 * <b>adjustCredits</b>
	 * <p>
	 * Adds the given amount to the owners number of credits.
	 * 
	 * @param amount
	 *            Amount to adjust the credits by
	 * 
	 *
	 */
	private void adjustCredits(Integer amount)
	{
		credits += amount;
	}

	/**
	 * <b>addTreat</b>
	 * <p>
	 * adds a treat to the owner's stockpile of treats.
	 * 
	 * @param theTreat
	 *            The treat to be added
	 * 
	 *
	 */
	public void addTreat(Treat theTreat)
	{
		treats.add(theTreat);
	}
}
