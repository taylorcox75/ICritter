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
 * 
 * Also added a getHappiness() Method
 */
package model;

import java.util.*;

/**
 * Class describes an ICritter. An ICritter has memories and will have friends and can interact with other ICritters.
 * 
 *
 */
public abstract class ICritter extends Observable
{

	private String name;// the name of the ICritter
	private List<ICritterMemoryEvent> memories;// a list of memories the ICritter has
	private Owner owner;// the ICritter's owner
	private KeywordCollection interests;// the ICritter's interests
	private List<ICritter> friends;// the ICritter's friends

	/**
	 * Creates a new ICritter
	 * 
	 * @param theName
	 *            Defines the name of the ICritter
	 * 
	 * @param theOwner
	 *            A reference to the owner of this ICritter
	 * 
	 *
	 */
	public ICritter(String theName, Owner theOwner)
	{
		name = theName;
		owner = theOwner;
		memories = new LinkedList<ICritterMemoryEvent>();// initialize our memory list as a linked list
		interests = new KeywordCollection();
		friends = new LinkedList<ICritter>();
	}

	/**
	 * ICritter will receive the treat and consume it. Once the treat is consumed, the ICritter will create a new reaction to
	 * the treat, add that reaction to it's memory, then return that reaction to the caller.
	 * 
	 * @param theTreat
	 *            The treat that the ICritter is to consume
	 * 
	 * @return ICritterReaction
	 * 
	 *         {@link ICritterReaction}
	 * 
	 *
	 */
	public ICritterReaction receiveTreat(Treat theTreat)
	{
		// first the ICritter eats the treat (yum, yum), this will produce a reaction to the treat
		ICritterReaction react = consumeTreat(theTreat);

		// next we add this reaction to our memory
		addMemoryEvent(theTreat, react);
		// now return our reaction
		return react;
	}

	/**
	 * <b>getMemories</b>
	 * <p>
	 * Returns a list of the memories this ICritter has.
	 * 
	 * @return List<ICritterMemoryEvent> {@link ICritterMemoryEvent}
	 * 
	 *
	 */
	public List<ICritterMemoryEvent> getMemories()
	{
		return memories;
	}

	/**
	 * <b>getOwner</b>
	 * <p>
	 * Returns the Owner of this ICritter. The owner was given to the ICritter upon creation.
	 * 
	 * @return Owner {@link Owner}
	 * 
	 *
	 */
	public Owner getOwner()
	{
		return owner;
	}

	/**
	 * <b>getName</>
	 * <p>
	 * Returns the name of this ICritter. The ICritter's name was given upon creation.
	 * 
	 * @return String
	 * 
	 *
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <b>addMemoryEvent</b>
	 * <p>
	 * Given a Treat and a Reaction, this method creates a memory event and adds it to the ICritter's memory.
	 * 
	 * @param theTreat
	 *            The treat that is associated with this memory
	 * 
	 * @param theReact
	 *            The reaction that is associated with this memory
	 * 
	 *
	 */
	public void addMemoryEvent(Treat theTreat, ICritterReaction theReact)
	{
		// create the memory event
		ICritterMemoryEvent theEvent = new ICritterMemoryEvent(theTreat, theReact);
		memories.add(theEvent);// add it to our memories
		this.setChanged();
		this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_ICRITTER));
	}

	/**
	 * <b>consumeTreat</b>
	 * <p>
	 * Will determine a reaction to the treat and return this reaction to the caller.
	 * 
	 * @param theTreat
	 *            The treat to calculate a reaction to.
	 * 
	 * @return ICritterReaction {@link ICritterReaction}
	 * 
	 *
	 */
	public ICritterReaction consumeTreat(Treat theTreat)
	{
		// TODO: change reaction based on the type of treat
		ICritterReaction react = new ICritterReaction(1);// make it always positive for now
		return react;
	}

	/**
	 * <b>getFriends</b>
	 * <p>
	 * This method returns a list of all the ICritters that this ICritter may be friends with. Note: The critters in this
	 * list, may not consider themselves friends of this ICritter.
	 * 
	 * @return List<{@link ICritter}>
	 * 
	 *
	 */
	public List<ICritter> getFriends()
	{
		return friends;
	}

	/**
	 * <b>addFriend</b>
	 * <p>
	 * Adds a friend to this ICritter's friends list. Returns true if <b>toAdd</b> is not already a friend, false if they
	 * are. This method does not allow duplicate friends
	 * 
	 * @param toAdd
	 *            The ICritter to add as a friend
	 * 
	 * @return boolean
	 * 
	 *
	 */
	public boolean addFriend(ICritter toAdd)
	{
		if (friends.contains(toAdd))
		{
			return false;// they are already friends
		} else
		{
			friends.add(toAdd);
			this.setChanged();
			this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_ICRITTER));
			return true;// successfully added
		}

	}

	/**
	 * <b>removeFriend</b>
	 * <p>
	 * Will remove a friend from the friends list. If toRemove was not already a friend, then this method will return false;
	 * otherwise, the friend will be removed and true will be returned.
	 * 
	 * @param toRemove
	 *            The ICritter to be removed from the friends list
	 * 
	 * @return boolean true if successful, false if not
	 * 
	 *
	 */
	public boolean removeFriend(ICritter toRemove)
	{
		boolean toReturn = friends.remove(toRemove);
		this.setChanged();
		this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_ICRITTER));
		return toReturn;// the remove method of a list matches the requirements of this method
	}

	/**
	 * <b>listInterests</b>
	 * <p>
	 * Will return a set of this ICritter's interests.
	 * 
	 * @return Set<String> Represents all the interests of this ICritter
	 * 
	 *
	 */
	public Set<String> listInterests()
	{
		return interests.listKeywords();
	}

	/**
	 * <b><i>interact</b></i>
	 * <p>
	 * This method interacts with another ICritter, it does not modify the other ICritter; however, it will add a new friend
	 * if the ICritter decides to do so.
	 * 
	 * @param theCrit
	 *            The other ICritter
	 * 
	 *
	 */
	public abstract void interact(ICritter theCrit);

	/**
	 * <b>addInterest</b>
	 * <p>
	 * Adds the given interest to this ICritter's interests.
	 * 
	 * @parm keyword The interest to add
	 * 
	 * @return boolean true if the keyword didn't already exist, false if it did
	 * 
	 *
	 */
	public boolean addInterest(String keyword)
	{
		boolean toReturn = interests.addKeyword(keyword);
		this.setChanged();
		this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_ICRITTER));
		return toReturn;
	}

	/**
	 * <b>containsInterest</b>
	 * <p>
	 * Returns true if the given keyword is in the ICritter's interests, false otherwise.
	 * 
	 * @parm keyword The interest to look for
	 * 
	 * @return boolean see description
	 * 
	 *
	 */
	public boolean containsInterest(String keyword)
	{
		return interests.listKeywords().contains(keyword);
	}

	/**
	 * <b>removeInterest</b>
	 * <p>
	 * Removes the given keyword from this ICritter's interests
	 * 
	 * @parm keyword The interest to remove
	 * 
	 * @return boolean true if the interest was successfully removed, false if it didn't exist
	 * 
	 *
	 */
	public boolean removeInterest(String keyword)
	{

		boolean toReturn = interests.removeKeyword(keyword);
		this.setChanged();
		this.notifyObservers(new view.ICritterUpdate(view.ICritterUpdate.UPDATE_ICRITTER));
		return toReturn;
	}

	/**
	 * <b>interestCorrelation</b>
	 * <p>
	 * Returns the correlation between this ICritter's interests and the provided ICritter's interests
	 * 
	 * @parm other The other ICritter to test against
	 * 
	 * @return double Representation of the correlation of the two ICritter's interests
	 * 
	 *
	 */
	public double interestCorrelation(ICritter other)
	{
		return interests.correlation(other.interests);
	}

	/*
	 * ICritterView() The constructor for the ICritterView Class and takes in an Owner as an argument
	 * 
	 * It then sets them up as observers
	 * 
	 * Creates a GUI elements and sets layouts
	 * 
	 * Calls the owner/critter setUp methods
	 * 
	 * Adds the mainJP to the JFrame
	 */
	public double getHappiness()
	{
		double count = -4; // Sets the default value
		List<ICritterMemoryEvent> treatsConsumed = this.getMemories();
		if (treatsConsumed.size() > 8) // If the size is greater than 8
		{
			// Iterates through the whole array
			for (int i = treatsConsumed.size() - 1; i > treatsConsumed.size() - 9; i--)
			{
				// Adds one to the count
				if (treatsConsumed.get(i).getRememberedTreat() instanceof FancyTreat)
					count++;
			}

		} else
		{
			for (int i = 0; i < treatsConsumed.size(); i++)
			{
				// Gets the happiness if it isn't 8 consumed yet
				if (treatsConsumed.get(i).getRememberedTreat() instanceof FancyTreat)
					count++;
			}
		}
		return count;
	}
}
