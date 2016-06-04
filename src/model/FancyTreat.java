/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * This Class Is Unchanged From Assignment 5
 */


package model;

/**
 * Class describes a FancyTreat. FancyTreat extends Treat.
 * 
 * {@link Treat}
 * 
 *
 */
public class FancyTreat extends Treat
{

	/**
	 * Creates a new FancyTreat object.
	 * 
	 * @param desc
	 *            the description of the treat
	 * 
	 *
	 */
	public FancyTreat(String desc)
	{
		super(desc);
	}

	/**
	 * Returns the cost of a FancyTreat (currently 5)
	 * 
	 *
	 */
	public Integer getCost()
	{
		return 5;
	}

	public String toString()
	{
		return "Fancy Treat";
	}

}
