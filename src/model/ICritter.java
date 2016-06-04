package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * model.ICritter Class, Added New Methods to it to Interact
 */

import java.util.*;

/**
 * Class describes an model.ICritter. An model.ICritter has memories and will have friends and can interact with other ICritters.
 * 
 *
 */
public abstract class ICritter
{

	private String name;// the name of the model.ICritter
	private List<ICritterMemoryEvent> memories;// a list of memories the model.ICritter has
	private Owner owner;// the model.ICritter's owner
	private List<ICritter> friends;// a list of memories the model.ICritter has
	private KeywordCollection interests;

	/**
	 * Creates a new model.ICritter
	 * 
	 * @param theName
	 *            Defines the name of the model.ICritter
	 * 
	 * @param theOwner
	 *            A reference to the owner of this model.ICritter
	 * 
	 *
	 */
	public ICritter(String theName, Owner theOwner)
	{
		name = theName;
		owner = theOwner;
		memories = new LinkedList<ICritterMemoryEvent>();// initialize our memory list as a linked list
		friends = new LinkedList<ICritter>(); // initialize the friends linked list
		interests = new KeywordCollection();
	}

	/**
	 * model.ICritter will receive the treat and consume it. Once the treat is consumed, the model.ICritter will create a new reaction to
	 * the treat, add that reaction to it's memory, then return that reaction to the caller.
	 * 
	 * @param theTreat
	 *            The treat that the model.ICritter is to consume
	 * 
	 * @return model.ICritterReaction
	 * 
	 *         {@link ICritterReaction}
	 * 
	 *
	 */
	public ICritterReaction receiveTreat(Treat theTreat)
	{
		// first the model.ICritter eats the treat (yum, yum), this will produce a reaction to the treat
		ICritterReaction react = consumeTreat(theTreat);

		// next we add this reaction to our memory
		addMemoryEvent(theTreat, react);
		// now return our reaction
		return react;
	}

	/**
	 * <b>getMemories</b>
	 * <p>
	 * Returns a list of the memories this model.ICritter has.
	 * 
	 * @return List<model.ICritterMemoryEvent> {@link ICritterMemoryEvent}
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
	 * Returns the model.Owner of this model.ICritter. The owner was given to the model.ICritter upon creation.
	 * 
	 * @return model.Owner {@link Owner}
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
	 * Returns the name of this model.ICritter. The model.ICritter's name was given upon creation.
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
	 * Given a model.Treat and a Reaction, this method creates a memory event and adds it to the model.ICritter's memory.
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
		ICritterMemoryEvent theEvent = new ICritterMemoryEvent(theTreat,
				theReact);

		memories.add(theEvent);// add it to our memories
	}

	/**
	 * <b>consumeTreat</b>
	 * <p>
	 * Will determine a reaction to the treat and return this reaction to the caller.
	 * 
	 * @param theTreat
	 *            The treat to calculate a reaction to.
	 * 
	 * @return model.ICritterReaction {@link ICritterReaction}
	 * 
	 *
	 */
	public ICritterReaction consumeTreat(Treat theTreat)
	{
		// TODO: change reaction based on the type of treat
		ICritterReaction react = new ICritterReaction(1);// make it always positive for now
		return react;
	}

	public List<ICritter> getFriends()
	{
		return friends; // Returns the list of friends
	}

	public boolean addFriend(ICritter toAdd)
	{
		for (int i = 0; i < friends.size(); i++)
		{
			if (toAdd.equals(friends.get(i))) // Checks to see if I already have that friend
			{
				return false; // Returns false
			}
		}

		friends.add(toAdd); // Adds the friend and returns true

		return true;
	}

	public boolean removeFriend(ICritter toRemove)
	{

		return friends.remove(toRemove); // Removes a friend and returns a boolean
	}

	public Set<String> listInterests()
	{

		return interests.listKeywords(); // Creates a Set to return that contains interests.
	}

	public boolean addInterest(String toAdd)
	{
		return interests.addKeyword(toAdd); // This adds an Interest and returns a boolean
	}

	public boolean removeInterest(String toRemove)
	{
		return interests.removeKeyword(toRemove); // Removes a keyword and returns a boolean
	}

	public double interestCorrelation(ICritter toCheck)
	{
		return interests.correlation(toCheck.interests); // Checks the correlation between two critters
	}

	public boolean containsInterest(String toCheck)
	{
		return interests.listKeywords().contains(toCheck); // Checks to see if the list has a keyword in it.
	}

	public abstract void interact(ICritter toInteract); // Calls the interact method of the specific Critter Type

}
