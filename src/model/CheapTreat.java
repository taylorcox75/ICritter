/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * This Class Is Unchanged From Assignment 5
 */


package model;

/**
 * Class describes a CheapTreat. CheapTreat is an extension of the class Treat {@link Treat}
 * 
 *
 */
public class CheapTreat extends Treat
{

	/**
	 * Constructs a new CheapTreat
	 * 
	 * @param desc
	 *            description of the treat
	 * 
	 *
	 */
	public CheapTreat(String desc)
	{
		super(desc);
	}

	/**
	 * returns the cost of a CheapTreat (currently 1)
	 * 
	 *
	 */
	public Integer getCost()
	{
		return 1;
	}

	public String toString()
	{
		return "Cheap Treat";
	}

}
