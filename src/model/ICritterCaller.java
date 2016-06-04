package model;/*
 * Name: Taylor Cox and Cameron Morrell
 * Section Leader: [Taylor (Jimmy Fagan) and [Cameron (Greg DePaul] 
 * Assignment: Assignment 4
 * A test case that the Spec instructeed us how to layout
 */

import java.util.*;

public class ICritterCaller
{

	public static void main(String[] args)
	{
		// Creates a Dog named Spot
		ICritter Spot = new ICritterDog("Spot", null);
		Spot.addInterest("Anime");
		Spot.addInterest("Nintendo");
		Spot.addInterest("Music");
		Spot.addInterest("RPG");
		Spot.addInterest("Games");

		// Creates a Dog named Rover
		ICritter Rover = new ICritterDog("Rover", null);
		Rover.addInterest("Books");
		Rover.addInterest("Buttons");
		Rover.addInterest("Comedy");
		Rover.addInterest("Comics");
		Rover.addInterest("Manga");

		// Creates a Cat names Felix
		ICritter Felix = new ICritterCat("Felix", null);
		Felix.addInterest("Garlic");
		Felix.addInterest("Nintendo");
		Felix.addInterest("Buttons");
		Felix.addInterest("Statistics");
		Felix.addInterest("Science");

		// Creates a Cat named Socks
		ICritter Socks = new ICritterCat("Socks", null);
		Socks.addInterest("Canaries");
		Socks.addInterest("Dogs");
		Socks.addInterest("Music");
		Socks.addInterest("Games");
		Socks.addInterest("Books");
		Socks.addInterest("Vampires");

		// Creeates a penguin named Zbignew
		ICritter Zbignew = new ICritterPenguin("Zbignew", null);
		Zbignew.addInterest("Games");
		Zbignew.addInterest("Music");
		Zbignew.addInterest("Anime");
		Zbignew.addInterest("Canaries");

		// Creates a Penguin named Jerrmaine
		ICritter Jermaine = new ICritterPenguin("Jermaine", null);
		Jermaine.addInterest("Science");
		Jermaine.addInterest("Buttons");
		Jermaine.addInterest("Garlic");
		Jermaine.addInterest("Games");
		Jermaine.addInterest("Manga");

		// Creates a new world and adds all of the critters to it.
		ICritterWorld myWorld = new ICritterWorld();
		myWorld.addICritter(Spot);
		myWorld.addICritter(Rover);
		myWorld.addICritter(Felix);
		myWorld.addICritter(Socks);
		myWorld.addICritter(Zbignew);
		myWorld.addICritter(Jermaine);

		// Calls run Jamboree on all of the Critters in the world.
		myWorld.runJamboree();

		List<ICritter> crittersInWorld = myWorld.listICritters(); // Grabs a list of the Critters
		System.out.println("All The ICritters In The World: \n");
		for (int i = 0; i < crittersInWorld.size(); i++) // Iterates through all of the Critters
		{

			System.out.print("Name: " + crittersInWorld.get(i).getName()); // Gets the name at the index
			if (crittersInWorld.get(i) instanceof ICritterCat) // Checks to see if it is a cat
			{
				System.out.println("\tThe Cat");
			}
			if (crittersInWorld.get(i) instanceof ICritterDog) // Checks to see if it is a dog
			{
				System.out.println(" The Dog");
			}
			if (crittersInWorld.get(i) instanceof ICritterPenguin) // Checks to see if it is a penguin
			{
				System.out.println("\tThe Penguin");
			}

			System.out.println("\n\tInterests:\t"
					+ crittersInWorld.get(i).listInterests().toString()); // Gets the Interests

			System.out.print("\tFriends:\t");

			for (int k = 0; k < crittersInWorld.get(i).getFriends().size(); k++)
			{
				System.out.print(crittersInWorld.get(i).getFriends().get(k)
						.getName());

				// Checks the instances of both to compare to it
				if (crittersInWorld.get(k) instanceof ICritterCat)
				{
					System.out.print(" (Cat),\t");
				}
				if (crittersInWorld.get(k) instanceof ICritterDog)
				{
					System.out.print(" (Dog),\t");
				}
				if (crittersInWorld.get(k) instanceof ICritterPenguin)
				{
					System.out.print(" (Penguib),\t");
				}
				// Gets the Friend's name

			}
			System.out.print("\n\n");
		}
	}

}
