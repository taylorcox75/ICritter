/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 5 Extra Credit
 * This Class Handles The GUI for the ICritter
 */
package view;

import java.awt.*;
import javax.swing.*;

import model.*;

public class ICritterPanel extends JPanel
{
	private static final long serialVersionUID = 4L;
	private JPanel critterInfo;
	private JList<String> recentReactions;
	private Owner theOwner;
	private DefaultListModel<String> theReaction;
	private JSlider happinessSlider;

	/*
	 * Constructor
	 * 
	 * Calls SetUp GUI()
	 */
	public ICritterPanel(Owner passedIn)
	{
		theOwner = passedIn;
		setUpGUI();
	}

	/*
	 * setUpGUI()
	 * 
	 * This method creates all of the Critter GUI elements
	 * 
	 * Then it adds it to the iCritter panel
	 */
	public void setUpGUI()

	{

		// Setting Up Main Critter Panel
		critterInfo = new JPanel();
		critterInfo.setLayout(new BorderLayout());
		//
		// Entry 1: Slider Title
		critterInfo.add(new JLabel(" Happiness and Memories "), BorderLayout.NORTH);
		//
		// Entry 2: Slider
		int happy = (int) theOwner.getCritter().getHappiness(); // Converts happiness to an int
		happinessSlider = new JSlider(-4, 4, happy); // Creates the slider to our default values
		happinessSlider.setEnabled(false); // Makes it to where you cann't move it.
		// Time to make it pretty
		happinessSlider.setPaintLabels(true);
		happinessSlider.setMajorTickSpacing(1);
		happinessSlider.setPaintTicks(true);
		critterInfo.add(happinessSlider, BorderLayout.CENTER); // Adds it to our Panel
		happinessSlider.setPaintLabels(true);
		//
		// Entry 3: Last 8 Memory Events
		theReaction = new DefaultListModel<String>(); // Sets up a default list made of Strings.

		int stoppingPoint = 0; // Where to stop at
		String temp; // Temp value to add to later
		if (theOwner.getCritter().getMemories().size() > 8) // This condition checks to see if we have 8+ memories
			stoppingPoint = theOwner.getCritter().getMemories().size() - 9; // If we do, stopping point is memories-9.
		else
			stoppingPoint = -1; // Otherwise, stopping point is -1

		for (int i = theOwner.getCritter().getMemories().size() - 1; i > stoppingPoint; i--) // Goes through to get last 8

		{
			// Checks to see the type of instance of the treat and updates accordingly
			if (theOwner.getCritter().getMemories().get(i).getRememberedTreat() instanceof CheapTreat)
				temp = "Cheap Treat";
			else
				temp = "Fancy Treat";
			// Adds it to the list
			theReaction.addElement(temp + " (reaction was " + theOwner.getCritter().getMemories().get(i).getRememberedReaction().getMoodModifier() + ")");

		}

		recentReactions = new JList<String>(theReaction); // Creates our new JList

		JScrollPane reactionsList = new JScrollPane(recentReactions); // Creates a new JScrollPane
		reactionsList.setPreferredSize(new Dimension(100, 300)); // Hard sets the size of it
		critterInfo.add(reactionsList, BorderLayout.SOUTH); // Adds it to our critterStuff
		add(critterInfo);

	}

	public void updateICritterComponents(ICritter argument)
	{
		// Update Reaction List
		theReaction.clear(); // Clear the current list
		int stoppingPoint = 0; // Where to stop at
		String temp; // Temp value to add to later
		if (theOwner.getCritter().getMemories().size() > 8) // This condition checks to see if we have 8+ memories
			stoppingPoint = theOwner.getCritter().getMemories().size() - 9; // If we do, stopping point is memories-9.
		else
			stoppingPoint = -1; // Otherwise, stopping point is -1

		for (int i = theOwner.getCritter().getMemories().size() - 1; i > stoppingPoint; i--) // Goes through to get last 8

		{
			// Checks to see the type of instance of the treat and updates accordingly
			if (theOwner.getCritter().getMemories().get(i).getRememberedTreat() instanceof CheapTreat)
				temp = "Cheap Treat";
			else
				temp = "Fancy Treat";
			// Adds it to the reaction
			theReaction.addElement(temp + " (reaction was " + theOwner.getCritter().getMemories().get(i).getRememberedReaction().getMoodModifier() + ")");

		}
		//
		// Update Slider
		int happy = (int) theOwner.getCritter().getHappiness();
		happinessSlider.setValue(happy);

		critterInfo.repaint(); // Calls reprint to reprint the values

	}

}