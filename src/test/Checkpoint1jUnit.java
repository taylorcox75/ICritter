package test;/*
 * CHANGE THE NAME OF LINE 90 TO THE NAME OF YOUR CRITTER SET UP IN OWNER CONSTRUCTOR
 * THEN UN-COMMENT OUT THE LINE
 * 
 * SUGESTIONS FOR TESTCASES?:
 * POST ON THE PIAZZA POST OR EMAIL
 * 
 * TAYLORCOX75@GMAIL.COM
 */

// ONLY USE THIS TESTCASE IF YOUR PROJECT USES INTEGERS
// https://www.dropbox.com/s/f89hs2zjws5yg5b/jUnitTestUsesInt.java?dl=0 IS IF YOU USE INTS

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Owner;
import model.Treat;
import org.junit.Assert;
import org.junit.Test;

public class Checkpoint1jUnit
{

	@Test
	public void test()
	{

		// Test 1
		// Creates 2 Treats
		// Checks to see if they exist
		// Checks to be sure the credits are right

		Owner owner1 = new Owner();
		owner1.buyCheapTreat("treat1");
		assertEquals((Integer) 9, owner1.getCredits());
		owner1.buyCheapTreat("treat2");
		assertEquals((Integer) 8, owner1.getCredits());
		assertEquals("treat1", owner1.listTreats().get(0).getDescription());
		assertEquals("treat2", owner1.listTreats().get(1).getDescription());

		// Test 2
		// Creates 3 Treats
		// Calls giveTreat() on one of the treats
		// Checks to see the right amount of credits have been spent
		// Checks to See if given treat is still in array
		// 3 items added - the one removed, array.size() should be 2 after removal

		Owner owner2 = new Owner();
		Treat treat1 = owner2.buyCheapTreat("treat1");
		Treat treat2 = owner2.buyCheapTreat("treat2");
		Treat treat3 = owner2.buyCheapTreat("treat3");
		assertEquals((Integer) 7, owner2.getCredits());
		owner2.giveTreat(treat1);
		assertEquals((Integer) 7, owner2.getCredits());

		assertEquals(treat2, owner2.listTreats().get(0));
		assertEquals(treat3, owner2.listTreats().get(1));
		assertTrue(owner2.listTreats().size() == 2);

		// Test 3
		// Creates 5 Treats
		// Gives to Critter
		// Checks to See Memory

		Owner owner3 = new Owner();
		Treat treat11 = owner3.buyCheapTreat("treat11");
		Treat treat22 = owner3.buyCheapTreat("treat22");
		Treat treat33 = owner3.buyCheapTreat("treat33");
		Treat treat44 = owner3.buyCheapTreat("treat44");
		Treat treat55 = owner3.buyCheapTreat("treat55");
		owner3.giveTreat(treat11);
		owner3.giveTreat(treat22);
		owner3.giveTreat(treat44);
		owner3.giveTreat(treat55);
		assertEquals("treat33", owner3.listTreats().get(0).getDescription());
		assertTrue(owner3.listTreats().size() == 1);
		assertEquals(owner3.getCritter().getMemories().get(0)
				.getRememberedTreat().getDescription(), "treat11");
		assertEquals(owner3.getCritter().getMemories().get(1)
				.getRememberedTreat(), treat22);
		assertEquals(owner3.getCritter().getMemories().get(2)
				.getRememberedTreat(), treat44);
		assertEquals(owner3.getCritter().getMemories().get(3)
				.getRememberedTreat(), treat55);
		assertEquals(owner3.getCritter().getMemories().size(), 4);
		assertEquals(owner3.getCritter().getMemories().get(0)
				.getRememberedReaction().getMoodModifier(), (Integer)1);
		assertEquals(owner3.getCritter().getMemories().get(1)
				.getRememberedReaction().getMoodModifier(), (Integer)1);
		assertEquals(owner3.getCritter().getMemories().get(2)
				.getRememberedReaction().getMoodModifier(), (Integer)1);
		assertEquals(owner3.getCritter().getMemories().get(3)
				.getRememberedReaction().getMoodModifier(), (Integer)1);

		// Test 4
		// Checks getOwner and getName

		Owner owner4 = new Owner();
		assertFalse(owner4.getCritter().getOwner().equals(owner3));
		// assertEquals(owner4.getCritter().getName(), "ENTER NAME HERE");

		// Test 5
		// Adds a treat
		// Checks the cost of the treat from memory
		// Eats the treat
		// Checks cost again from memory

		Owner owner5 = new Owner();
		Treat treat88 = owner5.buyCheapTreat("treat88");
		Treat treat99 = owner5.buyCheapTreat("treat99");
		assertEquals(owner5.listTreats().get(0).getCost(), (Integer) 1);
		assertEquals(owner5.listTreats().get(1).getCost(), (Integer) 1);
		owner5.giveTreat(treat88);
		assertEquals(owner5.listTreats().size(), 1);
		assertEquals(owner5.getCritter().getMemories().get(0)
				.getRememberedTreat().getCost(), (Integer) 1);

		owner5.giveTreat(treat99);
		assertEquals(owner5.listTreats().size(), 0);
		assertEquals(owner5.getCritter().getMemories().get(1)
				.getRememberedTreat().getCost(), (Integer) 1);

		// Test 6
		// Creates 2 Owners and 2 Critters
		// Buy both Critters the same exact treats
		// Feed Critter 1 a treat
		// Critter 1 should have a memory event
		// Critter 2 shouldn't have one

		Owner owner6 = new Owner();
		owner6.buyCheapTreat("treat45");
		owner6.buyCheapTreat("treat46");
		Owner owner7 = new Owner();
		owner7.buyCheapTreat("treat47");
		owner7.buyCheapTreat("treat48");
		assertEquals(owner6.listTreats().get(0).getDescription(), owner6
				.listTreats().get(0).getDescription());
		assertEquals(owner6.listTreats().get(1).getDescription(), owner6
				.listTreats().get(1).getDescription());
		owner6.giveTreat(owner6.listTreats().get(0));
		assertEquals(owner6.getCritter().getMemories().size(), 1);
		assertEquals(owner7.getCritter().getMemories().size(), 0);

		// Test 7
		// Tries to buy a 15 Treats, should only be able to buy 10 treats
		// Every time we buy a treat, we check to see if we have 1 less credit.
		// Also checks to see if credits was initialized right

		Owner owner8 = new Owner();
		int k = 10;
		for (int i = 0; i < 15; i++)
		{
			owner8.buyCheapTreat("treat #" + i);
			if (k != 0)
			{
				k--;
				assertEquals(owner8.getCredits(), (Integer) k);

			}
		}
		assertEquals(owner8.listTreats().size(), 10);

		// Test 8
		// Will create a model.Treat for owner 9 and try to give it to owner 10
		// giveTreat should return null because owner 10 i is trying to give a treat he doesn't own
		// Memory should also return null since no treats were given

		Owner owner9 = new Owner();
		Owner owner10 = new Owner();
		assertEquals(null, owner10.giveTreat(owner9.buyCheapTreat("treat123")));
		assertEquals(owner10.getCritter().getMemories().size(), 0);

		// Test 9
		// Will See if adddTreat returns null when buying an 11th treat
		// Also since we ate 10 treats, 10 should be memories.size()

		Owner cool = new Owner();

		for (int i = 0; i < 10; i++)
		{
			cool.giveTreat(cool.buyCheapTreat("Buy me Chipotle"));
		}
		assertEquals(cool.listTreats().size(), 0);
		assertEquals(cool.getCritter().getMemories().size(), 10);

		Treat shouldntEat = cool.buyCheapTreat("Buy me Chipotle");
		assertEquals(null, cool.giveTreat(shouldntEat));

		// Test 10 
		// Falsely adding memory events
		// Should have the correct memory events added (2)

		Owner owner11 = new Owner();
		int stuff = 10;
		for (int i = 0; i < 15; i++)
		{
			owner11.buyCheapTreat("treat #" + i);
			if (stuff != 0)
			{
				stuff--;
				assertEquals(owner11.getCredits(), (Integer) stuff);

			}
		}
		Treat wontAdd = owner11.buyCheapTreat("Buy me Chipotle");
		owner11.giveTreat(wontAdd);
		assertEquals(owner11.getCritter().getMemories().size(), 0);

		// Test 11,
		// Creates 2 treats, and gives one to 2 owners
		// Same string, but different objects
		// Feeds the critter
		// Critter shouldn't eat the treat because objects !=, even though description ==
		
		Owner owner12 = new Owner();
		Owner owner13 = new Owner();
		owner12.buyCheapTreat("Test");
		Treat notIn = owner12.buyCheapTreat("Test");
		
		owner13.giveTreat(notIn);
		assertEquals(owner13.getCritter().getMemories().size(), 0);
	}
}
