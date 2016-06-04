/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * This Class Handles NoInterestsExceptions
 */

package model;

public class NoInterestsException extends RuntimeException
{
	// The default serialVersionUID
	private static final long serialVersionUID = 4385247342307569783L;

	/*
	 * NoInterestsException constructor
	 * 
	 * Takes no parameters
	 * 
	 * Calls super with the required phrase
	 */
	public NoInterestsException()
	{
		// Calls super to throw this exception
		super("There are no interests to use.");

	}
}
