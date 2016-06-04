/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 5
 * This Class extends Observable, sets changed, and notifies observable
 * 
 * this.setChanged() 
 * Let's notify observers know that something is changed
 * 
 * this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_OWNER))
 * Calls the respective update methods in ICritterView()
 */

package model;

import java.util.*;

/**
 * Describes an Owner. An owner owns an ICritter and has money to buy Treats for his/her/it's ICritter
 * 
 *
 */
public class Owner extends Observable
{
	private ICritter iCritter;// the critter
	private List<Treat> treats;// a list of all the treats owned by this owner
	private Integer credits;// the number of credits this owner has
	private String name;

	/**
	 * <b>Owner</b>
	 * <p>
	 * Constructs a new Owner. During construction, the owner will create an ICritter to own as well.
	 * 
	 *
	 */
	public Owner(String ownerName, String critterName)
	{
		// create our new ICritter with it's name and this Owner as the Owner.
		name = ownerName;
		iCritter = new ICritterPenguin(critterName, this);

		credits = 30;// owner starts with 10 credits

		// initialize treats to an empty linkedList.
		treats = new LinkedList<Treat>();

	}

	/**
	 * <b>giveTreat</b>
	 * <p>
	 * Gives a treat to this owner's ICritter and returns the ICritter's reaction. If the owner does not own the treat, this
	 * method will return null. Once finished, this owner will no longer own the treat passed in.
	 * 
	 * @param theTreat
	 *            The treat to give to the ICritter. {@link Treat}
	 * 
	 * @return ICritterReaction {@link ICritterReaction}
	 * 
	 *
	 */

	public ICritterReaction giveTreat(Treat theTreat)
	{
		if (treats.contains(theTreat))
		{// does the owner own the treat?
			treats.remove(theTreat);// remove the treat from our treats list
			this.setChanged();
			this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_OWNER));
			return iCritter.receiveTreat(theTreat);// return the ICritter's reaction
		} else
			return null;// owner does not own the treat
	}

	/**
	 * <b>buyCheapTreat</b>
	 * <p>
	 * Buys a cheap treat with the given description and adds it to the owner's treats list. If the Owner does not have
	 * enough credits, the treat will not be bought and the treat will not be added, this method will also return null. If
	 * the Owner does have enough credits, the treat will be bought and the treat returned.
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
			adjustCredits(-theTreat.getCost());// subtract the credits
			addTreat(theTreat);// add our treat to our treat stockpile
			return theTreat;// return the treat
		} else
		{// otherwise return null
			return null;
		}
	}

	public FancyTreat buyFancyTreat(String desc)
	{
		// create the fancyTreat
		FancyTreat theTreat = new FancyTreat(desc);

		if (credits >= theTreat.getCost())
		{// if we have enough money
			adjustCredits(-theTreat.getCost());// subtract the credits
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
	 * @return List<Treat> {@link Treat}
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
	 * Returns a reference to the critter owned by this Owner.
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
		this.setChanged();
		this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_OWNER));
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
		this.setChanged();
		this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_OWNER));
	}

	public String getName()
	{
		return name;
	}

}
