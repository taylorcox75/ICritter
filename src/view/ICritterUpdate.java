/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 5
 * This Class Handles ICritterUpdates
 */

package view;

public class ICritterUpdate
{
	// Made the following instance variables static and final because they never can change
	public static final Integer UPDATE_ICRITTER = 0x1;
	public static final Integer UPDATE_OWNER = 0x2;
	public static final Integer UPDATE_NONE = 0x0;
	private Integer updateType;

	// This method sets the update type to the right value
	public ICritterUpdate(Integer inNum)
	{
		// The updateType is the passed in value
		updateType = inNum;

		// If the Update type is NOT UpdateCritter or UpdateOwner then make is to UpdateNone
		if (updateType != 0x1 && updateType != 0x2)
			updateType = UPDATE_NONE;
	}

	// Returns the UpdateType
	public Integer getUpdateType()
	{
		return updateType;
	}
}
