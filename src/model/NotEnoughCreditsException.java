/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6 
 * This Class Handles NotEnoughCreditsException
 */
package model;

public class NotEnoughCreditsException extends RuntimeException
{
	// Eclipse made us put this line in here.
	private static final long serialVersionUID = 7064066665429690165L;

	/*
	 * NotEnoughCreditsException Constructor
	 * 
	 * Throws the exception
	 * 
	 * Parameters: As required by specification
	 */
	public NotEnoughCreditsException(int triedToRemove, int creditsHave)
	{
		// Calls super to throw the exception
		super("Attempted to remove " + triedToRemove + " credits, but only had " + creditsHave + " credits.");
	}
}
