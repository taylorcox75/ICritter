/* JUnit Test Cases for Assignment 6
 * Name File: JUnitTest 
 * 
 * Notes: 
 * Failing Test1 or Test2?  
 * 9/10 your throw output doesn't match spec required
 * Includes Punctuation
 * 
 * Authors:
 * Taylor Cox: 		NoInterestsException
 * Cameron Morrell:     NotEnoughCreditsException
 * 
 */
/** 
 *Category1: Tests Thrown Exceptions (2 Tests)
 *T1:	Throws Credit
 *T2: 	Throws Interest
 **Compares error message to what it should be

 Category2: Tests Interest Exception Throwing & Slug Friends Implementation (4 Tests)
 *T3:	Land -> Marine Interact
 *T4:	Marine -> Land
 *T5:	Slug -> All
 *T6: 	Super mega where everyone has 2-3 interests and some don't
 **			Remember who a slug can be friends with

 Category3: Tests Credits Exception
 *T7: 	Spends all but 2 credits, shouldn't be able to buy Fancy
 *T8: 	Buys treats stores listTreats(), loop tries to buy 200 more, calls listTreats().
 **			list1 should= list2 object for object, they are the same list

 */

package test;

import static org.junit.Assert.*;
import java.util.*;

import model.*;
import org.junit.*;

public class Checkpoint4jUnit
{

	@Test
	public void test()
	{

		/** SET UP OF THE WORLD AND CRITTERS */
		Owner theOwner = new Owner("Name", "ICritter");
		ICritter dog = new ICritterDog("Dog", theOwner);
		ICritter cat = new ICritterCat("Cat", theOwner);
		ICritter cat2 = new ICritterCat("Cat2", theOwner);
		ICritter penguin = new ICritterPenguin("Penguin", theOwner);
		ICritter penguin2 = new ICritterPenguin("Penguin2", theOwner);
		ICritter slug = new ICritterSlug("Slug", theOwner);
		ICritter slug2 = new ICritterSlug("Slug2", theOwner);
		String message = "";
		String creditsE = "Attempted to remove 2 credits, but only had 0 credits.";
		String interestsE = "There are no interests to use.";
		/* Category 1: Tests Thrown Exceptions */
		System.out.println("Testing Throw/Catch Exceptions\t(Should Pass 1-2)");

		// Test 1
		// Throws credit exception and checks output
		try
		{
			throw new NotEnoughCreditsException(2, 0);
		} catch (NotEnoughCreditsException e)
		{
			message = e.getMessage();

		}
		assertEquals(creditsE, message);
		System.out.print("Passed Test: 1,");
		// Test 2
		// Throws interest exception and checks output
		try
		{
			throw new NoInterestsException();
		} catch (NoInterestsException e)
		{
			message = e.getMessage();

		}
		assertEquals(interestsE, message);
		System.out.println("2.\t\t(Passed All In Category)");
		/* Category 2: NoInterestsException via Interact */
		System.out.println("\nTesting Interests Exception\t(Should Pass 1-6)");
		// Test 3
		// Interacting Dog with land/marine
		// No Interests thus far
		// Dog should be friends with all but penguin
		dog.interact(cat);
		dog.interact(slug);
		dog.interact(penguin);

		assertEquals(dog.getFriends().size(), 2);
		assertTrue(dog.getFriends().contains(cat));
		assertTrue(dog.getFriends().contains(slug));
		assertFalse(dog.getFriends().contains(penguin));

		System.out.print("Passed Tests: 1,2,3,");

		// Test 4
		// Interacting Penguin with land/marine
		// They should all be friends
		penguin.interact(dog);
		penguin.interact(slug);
		penguin.interact(cat);

		assertEquals(penguin.getFriends().size(), 3);
		assertTrue(penguin.getFriends().contains(cat));
		assertTrue(penguin.getFriends().contains(slug));
		assertTrue(penguin.getFriends().contains(dog));

		System.out.print("4,");

		// Test 5
		// Slug should friend all
		slug.interact(dog);
		slug.interact(penguin);
		slug.interact(cat);

		assertEquals(slug.getFriends().size(), 3);
		assertTrue(slug.getFriends().contains(cat));
		assertTrue(slug.getFriends().contains(penguin));
		assertTrue(slug.getFriends().contains(dog));
		System.out.print("5,");

		// House Keeping Before We Continue
		// Recreating Critters

		// Dog: Should friend Cat, Cat2, Slug, Slug2
		dog = new ICritterDog("Dog", theOwner);
		dog.addInterest("A");
		dog.addInterest("B");
		dog.addInterest("C");

		// Cat: Should friend Dog, Cat2, Slug, Slug1
		cat = new ICritterCat("Cat", theOwner);
		cat.addInterest("X");
		cat.addInterest("Y");

		// Cat2: Should friend Dog, Cat, Slug, Slug1
		cat2 = new ICritterCat("Cat2", theOwner);
		cat2.addInterest("A");

		// Penguin: Should friend Dog, Cat2
		penguin = new ICritterPenguin("Penguin", theOwner);
		penguin.addInterest("A");
		penguin.addInterest("B");

		// Penguin2: Should friend Slug, Slug2
		penguin2 = new ICritterPenguin("Penguin2", theOwner);

		// Slug: should friend Slug2, Penguin2
		slug = new ICritterSlug("Slug", theOwner);
		// Slug2: Should friend Slug, Penguin2
		slug2 = new ICritterSlug("Slug2", theOwner);

		//
		// Test 6: Interacting With Interests
		// Interact Time
		// Adding critters to Array to test.
		ArrayList<ICritter> toTest = new ArrayList<ICritter>();
		toTest.add(dog);
		toTest.add(cat);
		toTest.add(cat2);
		toTest.add(penguin);
		toTest.add(penguin2);
		toTest.add(slug);
		toTest.add(slug2);
		for (int i = 0; i < toTest.size(); i++)
		{
			for (int j = 0; j < toTest.size(); j++)
			{
				if (!toTest.get(i).equals(toTest.get(j)))
				{
					toTest.get(i).interact(toTest.get(j));
				}
			}
		}
		// Checking Dog Friends
		assertEquals(toTest.get(0).getFriends().size(), 4);
		assertFalse(toTest.get(0).getFriends().contains(dog));
		assertTrue(toTest.get(0).getFriends().contains(cat));
		assertTrue(toTest.get(0).getFriends().contains(cat2));
		assertFalse(toTest.get(0).getFriends().contains(penguin));
		assertFalse(toTest.get(0).getFriends().contains(penguin2));
		assertTrue(toTest.get(0).getFriends().contains(slug));
		assertTrue(toTest.get(0).getFriends().contains(slug2));
		// Checking Cat Friends
		assertEquals(toTest.get(1).getFriends().size(), 4);
		assertTrue(toTest.get(1).getFriends().contains(dog));
		assertFalse(toTest.get(1).getFriends().contains(cat));
		assertTrue(toTest.get(1).getFriends().contains(cat2));
		assertFalse(toTest.get(1).getFriends().contains(penguin));
		assertFalse(toTest.get(1).getFriends().contains(penguin2));
		assertTrue(toTest.get(1).getFriends().contains(slug));
		assertTrue(toTest.get(1).getFriends().contains(slug2));
		// Checking Cat2 Friends
		assertEquals(toTest.get(2).getFriends().size(), 4);
		assertTrue(toTest.get(2).getFriends().contains(dog));
		assertTrue(toTest.get(2).getFriends().contains(cat));
		assertFalse(toTest.get(2).getFriends().contains(cat2));
		assertFalse(toTest.get(2).getFriends().contains(penguin));
		assertFalse(toTest.get(2).getFriends().contains(penguin2));
		assertTrue(toTest.get(2).getFriends().contains(slug));
		assertTrue(toTest.get(2).getFriends().contains(slug2));
		// Checking Penguin Friends
		assertEquals(toTest.get(3).getFriends().size(), 2);
		assertTrue(toTest.get(3).getFriends().contains(dog));
		assertFalse(toTest.get(3).getFriends().contains(cat));
		assertTrue(toTest.get(3).getFriends().contains(cat2));
		assertFalse(toTest.get(3).getFriends().contains(penguin));
		assertFalse(toTest.get(3).getFriends().contains(penguin2));
		assertFalse(toTest.get(3).getFriends().contains(slug));
		assertFalse(toTest.get(3).getFriends().contains(slug2));
		// Checking Penguin2 Friends
		assertEquals(toTest.get(4).getFriends().size(), 2);
		assertFalse(toTest.get(4).getFriends().contains(dog));
		assertFalse(toTest.get(4).getFriends().contains(cat));
		assertFalse(toTest.get(4).getFriends().contains(cat2));
		assertFalse(toTest.get(4).getFriends().contains(penguin));
		assertFalse(toTest.get(4).getFriends().contains(penguin2));
		assertTrue(toTest.get(4).getFriends().contains(slug));
		assertTrue(toTest.get(4).getFriends().contains(slug2));
		// Checking Slug Friends
		assertEquals(toTest.get(5).getFriends().size(), 2);
		assertFalse(toTest.get(5).getFriends().contains(dog));
		assertFalse(toTest.get(5).getFriends().contains(cat));
		assertFalse(toTest.get(5).getFriends().contains(cat2));
		assertFalse(toTest.get(5).getFriends().contains(penguin));
		assertTrue(toTest.get(5).getFriends().contains(penguin2));
		assertFalse(toTest.get(5).getFriends().contains(slug));
		assertTrue(toTest.get(5).getFriends().contains(slug2));
		// Checking Slug2 Friends
		assertEquals(toTest.get(6).getFriends().size(), 2);
		assertFalse(toTest.get(6).getFriends().contains(dog));
		assertFalse(toTest.get(6).getFriends().contains(cat));
		assertFalse(toTest.get(6).getFriends().contains(cat2));
		assertFalse(toTest.get(6).getFriends().contains(penguin));
		assertTrue(toTest.get(6).getFriends().contains(penguin2));
		assertTrue(toTest.get(6).getFriends().contains(slug));
		assertFalse(toTest.get(6).getFriends().contains(slug2));
		System.out.println("6.\t(Passed All In Category)");

		/* Category 3: Not Enough Credits Exception via Buy Treat */
		System.out.println("\nTesting AdjustCredits Exception\t(Should Pass: 1-8)");
		// Test 7
		// Buying Treats
		assertEquals(theOwner.getCredits(), (Integer) 30);
		for (int i = 0; i < 23; i++)
		{
			Integer theCredits = theOwner.getCredits() - 1;
			theOwner.buyCheapTreat("treat#" + i);
			assertEquals(theOwner.getCredits(), theCredits);
		}
		Integer theCredits = theOwner.getCredits();
		theOwner.buyFancyTreat("treat");

		theCredits += -5;
		assertEquals(theOwner.getCredits(), theCredits);
		theOwner.buyFancyTreat("Shouldn't Buy");
		assertEquals(theOwner.getCredits(), theCredits);

		theOwner.buyCheapTreat("treat");
		theOwner.buyCheapTreat("treat");
		theCredits = 0;
		assertEquals(theOwner.getCredits(), theCredits);
		System.out.print("Passed Test: 1,2,3,4,5,6,7,");

		// Test 8
		// Shouldn't be able to buy any.
		List<Treat> preTreat = new ArrayList<Treat>();
		preTreat = theOwner.listTreats();

		for (int i = 0; i < 20; i++)
			theOwner.buyCheapTreat("Treat" + i);
		for (int i = 0; i < 30; i++)
			theOwner.buyCheapTreat("Treat" + i);

		List<Treat> postTreat = new ArrayList<Treat>();
		postTreat = theOwner.listTreats();

		for (int i = 0; i < preTreat.size(); i++)
			assertTrue(postTreat.get(i).equals(preTreat.get(i)));
		System.out.print("8.\t(Passed All In Category)\n\n");
		for (int i = 0; i < 30; i++)
			System.out.println("Congrats! You Passed Them All! ");

	}
}