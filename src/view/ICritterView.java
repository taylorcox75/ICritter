/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 5
 * This Class Handles The GUI for the ICritter and Owner GUI Structures
 */
package view;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import model.*;

public class ICritterView extends JPanel implements Observer
{
	private static final long serialVersionUID = 2L;
	private JPanel mainJP;
	private OwnerPanel ownerInfo;
	private ICritterPanel critterInfo;
	private Owner theOwner;

	/*
	 * ICritterView() The constructor for the ICritterView Class and takes in an Owner as an argument
	 * 
	 * It then sets them up as observers
	 * 
	 * Calls GUI Layout
	 */
	public ICritterView(Owner passedIn)
	{
		theOwner = passedIn; // Sets out instance variable to theOwner
		//
		// Adds them as observers
		theOwner.addObserver(this);
		theOwner.getCritter().addObserver(this);
		//
		// Time to create the GUI()!
		layoutGUI();
		//
		// Calling Update as Per Spec.
		ownerInfo.updateOwnerComponents(theOwner);
		critterInfo.updateICritterComponents(theOwner.getCritter());
	}

	/*
	 * * Creates a GUI elements and sets layouts
	 * 
	 * Calls the owner/critter setUp methods
	 * 
	 * Adds them to frame
	 */
	public void layoutGUI()
	{
		// Time to Create Main JP
		mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout());
		//
		// Adding the top TextField
		mainJP.add(new JLabel("ICritter: " + theOwner.getCritter().getName() + "          Owner: " + theOwner.getName()), BorderLayout.NORTH);
		//
		// Need to Create new OwnerPanel Object, and ICritterPanel Object
		ownerInfo = new OwnerPanel(theOwner); // Creates ownerInfo panel
		critterInfo = new ICritterPanel(theOwner); // Creates critterInfo panel
		ImageIcon theImageIcon = new ImageIcon("images/ourPicture.jpg"); // Grabs the Image
		JLabel imageLabel = new JLabel(theImageIcon); // Adds it to a label
		//
		// Time to add it to the panel
		mainJP.add(ownerInfo, BorderLayout.SOUTH); // This adds the OwnerInfo
		mainJP.add(critterInfo, BorderLayout.EAST); // Adds the critterStuff
		mainJP.add(imageLabel, BorderLayout.CENTER); // Adds the picture toAddLabel
		//
		// Add to the main JFrame

		add(mainJP);

	}

	/*
	 * update()
	 * 
	 * Called by NotifyObservor() from extends Observed classes
	 * 
	 * Finds the update type and calls the appropriate method with the right arguments
	 */
	@Override
	public void update(Observable o, Object arg)
	{

		Integer toCompare = ((ICritterUpdate) arg).getUpdateType();

		if (toCompare == 0x1)
			if (o instanceof ICritter == true)
				critterInfo.updateICritterComponents(((ICritter) o));
		if (toCompare == 0x2)

			if (o instanceof Owner == true)
				ownerInfo.updateOwnerComponents(((Owner) o));
	}

}