/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * This Class Is Unchanged From Assignment 5
 */

package model;

/**
 * This class represents a Treat that an ICritter can eat other types of treats will extend this treat
 * 
 * @author: Taylor Cox
 */
public abstract class Treat
{

	private String description;// The description of the treat (initialized by the constructor)

	/**
	 * @param: desc a String representation of the description of this treat
	 *
	 */
	public Treat(String desc)
	{
		description = desc;
	}

	/**
	 * Returns the cost of this treat
	 */
	public abstract Integer getCost();

	/**
	 * Returns the string representation of the treat's description
	 * 
	 *
	 */
	public String getDescription()
	{
		return description;
	}
}
