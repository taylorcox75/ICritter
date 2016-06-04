/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 6
 * Unchanged Class From Assignment 5
 */

package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.*;
import view.*;

public class ICritterController extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel mainProgPanel;
	private JMenuBar menuBarCore;
	private JMenu fileContainer;
	private JMenuItem about;
	private JMenuItem quitOption;
	private Owner theOwner;

	/*
	 * Constructor
	 * 
	 * This method creates a new Owner and lays out the GUI
	 * 
	 * Then it adds it to the ownerStuff panel
	 */
	public ICritterController(String iCritterName)
	{
		theOwner = new Owner("Taylor and Cameron", iCritterName); // Creates a new ICritter
		layoutGUI();

	}

	/*
	 * layoutGUI()
	 * 
	 * This method creates GUI elements
	 * 
	 * Includes a Menu, Behavior, and panel form ICritterView
	 */
	public void layoutGUI()
	{
		// Set up the Main Frame
		this.setTitle("CSc 335 Assignment 5");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLayout(new BorderLayout());

		// Creates the Menu Bar / Listeners
		this.createMenuBar();
		this.setJMenuBar(menuBarCore);

		// Creates a Panel For Main Panel
		mainProgPanel = new JPanel();
		mainProgPanel.setLayout(new BorderLayout());
		// Adds the View class to the Panel
		mainProgPanel.add(new ICritterView(theOwner), BorderLayout.SOUTH);
		mainProgPanel.setVisible(true);

		// Sets More Settings of Controller
		this.setResizable(false);
		this.add(mainProgPanel);
		this.pack();

	}

	/*
	 * createMenuBar()
	 * 
	 * This method creates Menu Bars
	 */
	public void createMenuBar()
	{
		// Create Menu Bar
		menuBarCore = new JMenuBar();
		fileContainer = new JMenu("File");
		menuBarCore.add(fileContainer);

		// About Panel
		about = new JMenuItem("About");
		about.addActionListener(new aboutListener());
		fileContainer.add(about);

		// Quit Option
		quitOption = new JMenuItem("Quit");
		quitOption.addActionListener(new exitListener());
		fileContainer.add(quitOption);

	}

	/*
	 * Main Method
	 * 
	 * This sets GUI visible to TRUE and calls a new ICritterController
	 * 
	 * Then it adds it to the ownerStuff panel
	 */
	public static void main(String[] args)
	{
		new ICritterController("Baby Chewbacca").setVisible(true);

	}

	/*
	 * Listeners
	 * 
	 * This next two listeners check for menu item actions
	 */
	public class exitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			System.exit(0); // This method exits when clicked
		}
	}

	public class aboutListener implements ActionListener
	{

		public void actionPerformed(ActionEvent ae)
		{
			// Shows a dialogue with the about information
			JOptionPane.showMessageDialog(about, "ICritter Assignment 6\nTaylor Cox\nCameron Morrell");

		}
	}
}
