/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * Unchanged Class From Assignment 5
 */

package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.*;

public class OwnerInfoPanel extends JPanel
{

	private static final long serialVersionUID = 3L;
	private JPanel ownerStuff;
	private JLabel creditsString, creditsInt;
	private JList<Treat> currentTreats;
	private JButton fancyButton, cheapButton, giveTreatButton;
	private Owner theOwner;
	private DefaultListModel<Treat> treatList;

	/*
	 * Constructor
	 * 
	 * Calls SetUp GUI()
	 */
	public OwnerInfoPanel(Owner passedIn)
	{
		theOwner = passedIn;
		setUpGUI();

	}

	/*
	 * setUpGUI()
	 * 
	 * This method creates all of the Owner GUI elements
	 * 
	 * Then it adds it to the owner panel
	 */
	public void setUpGUI()

	{
		// Creating a JPanel for the owner/ setting layout
		ownerStuff = new JPanel();
		ownerStuff.setLayout(new GridLayout(3, 2));

		// Entry 1: The Credits
		creditsString = new JLabel("Credits:");
		ownerStuff.add(creditsString);
		//
		// Entry 2: The Number of Credits
		creditsInt = new JLabel("" + theOwner.getCredits());
		ownerStuff.add(creditsInt);
		//
		// Entry 3: Adding the Owner's treats
		treatList = new DefaultListModel<Treat>(); // Initializes this to hold treat objects
		for (int i = 0; i < theOwner.listTreats().size(); i++) // Iterates through the whole list
		{
			// Adds all the treats to the treatList ListModel
			treatList.addElement(theOwner.listTreats().get(i));
		}

		currentTreats = new JList<Treat>(treatList); // Adds the ListModel to a JList
		JScrollPane ownerTreats = new JScrollPane(currentTreats); // Adds the JList to our scroll panel
		ownerStuff.add(ownerTreats); // Adds the JScrollPane to our ownerStuff
		//
		// Entry 4: Give Treat Button
		// Added Button with an action listener
		giveTreatButton = new JButton("Give Treat");
		giveTreatButton.addActionListener(new ownerActionListener());
		ownerStuff.add(giveTreatButton);
		//
		// Entry 5: Buy Fancy Treat Button
		// Added Button with an action listener
		fancyButton = new JButton("Buy Fancy Treat");
		fancyButton.addActionListener(new ownerActionListener());
		ownerStuff.add(fancyButton);
		//
		// Entry 6: Buy Cheap Treat
		// Added Button with an action listener
		cheapButton = new JButton("Buy Cheap Treat");
		cheapButton.addActionListener(new ownerActionListener());
		ownerStuff.add(cheapButton);
		ownerStuff.setPreferredSize(new Dimension(800, 250)); // Sets the dimensions for the frame
		add(ownerStuff);

	}

	/*
	 * updateOwnerComponents()
	 * 
	 * Updates the GUI based on an update on an ICritter related event
	 * 
	 * Calls repaint() to change values
	 */
	public void updateOwnerComponents(Owner theOwner)
	{
		// Updating Credits
		creditsInt.setText("" + theOwner.getCredits());
		//
		// Updating Treats List
		treatList.clear();
		for (int i = 0; i < theOwner.listTreats().size(); i++)
			treatList.addElement(theOwner.listTreats().get(i));
		// Calls repaint
		ownerStuff.repaint();

	}

	/*
	 * ownerActionListener()
	 * 
	 * A Listener for all owner type GUI elements
	 * 
	 * Does appropriate action
	 */
	public class ownerActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg)
		{
			// Check to see exactly what button was pressed
			if (((JButton) arg.getSource()).getText().equals("Buy Fancy Treat"))
				theOwner.buyFancyTreat("A Nice Treat"); // Buys a Fancy treat

			else if (((JButton) arg.getSource()).getText().equals("Buy Cheap Treat"))
				theOwner.buyCheapTreat("An Average Treat"); // Buys an Average Treat

			else if (((JButton) arg.getSource()).getText().equals("Give Treat"))
			{
				if (currentTreats.getSelectedValue() != null) // Checks to see if a treat is selected!
					theOwner.giveTreat((Treat) currentTreats.getSelectedValue()); // Gets Current Selection

				else
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ownerStuff), "Please Select A Treat To Give");

			}
		}
	}

}
