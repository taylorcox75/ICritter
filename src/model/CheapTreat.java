package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * Unchanged from Assignment 3
 */

/**
 * Class describes a model.CheapTreat. model.CheapTreat is an extension of the class model.Treat {@link Treat}
 * 
 *
 */
public class CheapTreat extends Treat
{

	/**
	 * Constructs a new model.CheapTreat
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
	 * returns the cost of a model.CheapTreat (currently 1)
	 * 
	 *
	 */
	public Integer getCost()
	{
		return 1;
	}

}
