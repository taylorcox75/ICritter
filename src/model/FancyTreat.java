package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Unchanged from Assignment 3
 */

/**
 * Class describes a model.FancyTreat. model.FancyTreat extends model.Treat.
 * 
 * {@link Treat}
 * 
 *
 */
public class FancyTreat extends Treat
{

	/**
	 * Creates a new model.FancyTreat object.
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
	 * Returns the cost of a model.FancyTreat (currently 5)
	 * 
	 *
	 */
	public Integer getCost()
	{
		return 5;
	}

}
