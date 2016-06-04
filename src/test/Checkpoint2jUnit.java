package test;

import static org.junit.Assert.*;

import java.util.*;

import model.*;
import org.junit.Assert;
import org.junit.Test;

public class Checkpoint2jUnit
{

	@Test
	public void test()
	{

		/** Test Category A */
		/** model.ICritter World */

		ICritter t1 = new ICritterDog("Test1", null);
		ICritter t2 = new ICritterCat("Test2", null);
		ICritter t3 = new ICritterPenguin("Test3", null);
		ICritter t4 = new ICritterPenguin("Test4", null);
		ICritterWorld world = new ICritterWorld();
		// Test 1
		// Add / Remove Critters

		world.addICritter(t1);
		world.addICritter(t2);
		world.addICritter(t3);
		Assert.assertEquals(world.listICritters().size(), 3);

		Assert.assertEquals(true, world.removeICritter(t1));
		Assert.assertEquals(world.listICritters().size(), 2);
		// t3 shouldn't be removed
		Assert.assertEquals(false, world.removeICritter(t4));
		Assert.assertEquals(world.listICritters().size(), 2);

		// Test 2
		// List Critters
		world = new ICritterWorld();
		world.addICritter(t1);
		world.addICritter(t2);
		world.addICritter(t3);
		world.addICritter(t4);
		Assert.assertEquals(world.listICritters().size(), 4);
		List<ICritter> worldList = world.listICritters();
		int k = 1;
		for (int i = 0; i < 4; i++)
		{
			worldList.get(i).getName().equals("Test" + k);
			k++;
		}

		/** Test Category B */
		/** model.ICritter */
		t1 = new ICritterDog("Test1", null);
		t2 = new ICritterCat("Test2", null);
		t3 = new ICritterCat("Test3", null);
		world = new ICritterWorld();
		world.addICritter(t1);
		world.addICritter(t2);

		// Test 3
		// Checks AddFriends/RemoveFriends
		// Tries to add 2 of the same friends
		// [Test] Tries to add himself
		// Removes friend
		// Tries to remove a non-friend
		// Tries to remove himself
		// Note: Overriding restrictions on adding friends

		worldList = world.listICritters();
		assertEquals(worldList.size(), 2);
		Assert.assertEquals(true, worldList.get(0).addFriend(worldList.get(1)));
		Assert.assertEquals(true, worldList.get(1).addFriend(worldList.get(0)));
		// Friends with Himself assertEquals(false, testList.get(0).addFriend(testList.get(0)));
		// Friends with himself assertEquals(false, testList.get(1).addFriend(testList.get(1)));
		Assert.assertEquals(false, worldList.get(0).addFriend(worldList.get(1)));
		Assert.assertEquals(false, worldList.get(1).addFriend(worldList.get(0)));

		Assert.assertEquals(true, worldList.get(0).removeFriend(t2));
		Assert.assertEquals(false, worldList.get(0).removeFriend(t2));
		Assert.assertEquals(false, worldList.get(0).removeFriend(t3));
		Assert.assertEquals(false, worldList.get(0).removeFriend(worldList.get(0)));

		Assert.assertEquals(true, worldList.get(1).removeFriend(t1));
		Assert.assertEquals(false, worldList.get(1).removeFriend(t1));
		Assert.assertEquals(false, worldList.get(1).removeFriend(t3));
		Assert.assertEquals(false, worldList.get(1).removeFriend(worldList.get(1)));

		// Test 4
		// Checks getFriends
		t1 = new ICritterDog("Test1", null);
		t2 = new ICritterCat("Test2", null);
		t3 = new ICritterPenguin("Test3", null);
		t4 = new ICritterPenguin("Test4", null);
		world = new ICritterWorld();
		world.addICritter(t1);
		world.addICritter(t2);
		world.addICritter(t3);
		world.addICritter(t4);
		worldList = world.listICritters();
		List<ICritter> t1Friends = worldList.get(0).getFriends();
		List<ICritter> t2Friends = worldList.get(1).getFriends();
		List<ICritter> t3Friends = worldList.get(2).getFriends();
		List<ICritter> t4Friends = worldList.get(3).getFriends();
		// T1 Friends
		Assert.assertEquals(worldList.get(0).getFriends().size(), 0);
		t1Friends = worldList.get(0).getFriends();

		// T2 Friends
		Assert.assertEquals(true, worldList.get(1).addFriend(worldList.get(3)));
		Assert.assertEquals(worldList.get(1).getFriends().size(), 1);
		t2Friends = worldList.get(1).getFriends();

		// T3 Friends
		Assert.assertEquals(true, worldList.get(2).addFriend(worldList.get(0)));
		Assert.assertEquals(true, worldList.get(2).addFriend(worldList.get(1)));
		Assert.assertEquals(worldList.get(2).getFriends().size(), 2);
		t3Friends = worldList.get(2).getFriends();

		// T4 Friends
		Assert.assertEquals(true, worldList.get(3).addFriend(worldList.get(0)));
		Assert.assertEquals(true, worldList.get(3).addFriend(worldList.get(1)));
		Assert.assertEquals(true, worldList.get(3).addFriend(worldList.get(2)));
		Assert.assertEquals(worldList.get(3).getFriends().size(), 3);
		t4Friends = worldList.get(3).getFriends();

		assertEquals(t1Friends.size(), 0);
		assertEquals(t2Friends.size(), 1);
		assertEquals(t3Friends.size(), 2);
		assertEquals(t4Friends.size(), 3);

		Assert.assertEquals(t2Friends.get(0).getFriends().size(), 3);
		Assert.assertEquals(t2Friends.get(0).getFriends().get(0).getName(), "Test1");
		Assert.assertEquals(t2Friends.get(0).getFriends().get(1).getName(), "Test2");
		Assert.assertEquals(t2Friends.get(0).getFriends().get(2).getName(), "Test3");

		// Test 5
		// Add / Remove Interests
		// Tries to add 2 of the same interests
		// Tries to remove interest already gone

		t1 = new ICritterDog("Test1", null);
		Assert.assertEquals(true, t1.addInterest("Interest1"));
		Assert.assertEquals(true, t1.addInterest("Interest2"));
		Assert.assertEquals(true, t1.addInterest("Interest3"));
		Assert.assertEquals(true, t1.addInterest("Interest4"));
		Assert.assertEquals(false, t1.addInterest("Interest4"));
		Assert.assertEquals(t1.listInterests().size(), 4);
		Assert.assertEquals(true, t1.removeInterest("Interest4"));
		Assert.assertEquals(false, t1.removeInterest("Interest4"));
		Assert.assertEquals(t1.listInterests().size(), 3);

		// Test 6
		// Lists Interests
		Assert.assertEquals(true, t1.addInterest("Interest4"));
		Assert.assertEquals(t1.listInterests().size(), 4);
		// Test 7
		// Checks Contains Interest
		Assert.assertEquals(true, t1.listInterests().contains("Interest3"));
		Assert.assertEquals(true ,t1.listInterests().contains("Interest1"));
		Assert.assertEquals(true ,t1.listInterests().contains("Interest2"));
		Assert.assertEquals(true ,t1.listInterests().contains("Interest3"));
		Assert.assertEquals(true ,t1.listInterests().contains("Interest4"));


		/** Test Category C */
		/** Checks Correlation Numbers */

		// Test 8
		// Values should return .25
		// Checks Some Math
		t1 = new ICritterDog("Test1", null);
		t2 = new ICritterDog("Test2", null);
		world = new ICritterWorld();
		world.addICritter(t1);
		world.addICritter(t2);
		worldList = world.listICritters();
		worldList.get(0).addInterest("A");
		worldList.get(0).addInterest("B");
		worldList.get(0).addInterest("C");
		Assert.assertEquals(worldList.get(0).listInterests().size(), 3);
		worldList.get(1).addInterest("A");
		worldList.get(1).addInterest("E");
		Assert.assertEquals(worldList.get(1).listInterests().size(), 2);
		Double number1 = 0.25;
		Double number2 = worldList.get(0).interestCorrelation(worldList.get(1));
		assertEquals(number1, number2);

		/** Test Category D */
		/** All Together */

		// Test 9
		// Jamboree Test
		// Indirectly tests interaction(model.ICritter)/Correlation (Keyword)
		// Land != Friend Penguin
		// Marine != Anyone
		t1 = new ICritterDog("Test1", null);
		t2 = new ICritterCat("Test2", null);
		t3 = new ICritterPenguin("Test3", null);
		t4 = new ICritterPenguin("Test4", null);
		world = new ICritterWorld();
		worldList = world.listICritters();
		world.addICritter(t1);
		world.addICritter(t2);
		world.addICritter(t3);
		world.addICritter(t4);
		world.runJamboree();
		t1Friends = worldList.get(0).getFriends();
		t2Friends = worldList.get(1).getFriends();
		t3Friends = worldList.get(2).getFriends();
		t4Friends = worldList.get(3).getFriends();
		// All land animals should be friends
		// Penguins should friend everyone since they have no interests.
		assertEquals(t1Friends.size(), 1);
		assertEquals(t2Friends.size(), 1);
		assertEquals(t3Friends.size(), 3);
		assertEquals(t4Friends.size(), 3);

		// Test 10
		// Tests classes interactions
		// More specific Jamboree with interests in common
		t1 = new ICritterDog("Test1", null);
		t1.addInterest("A");
		t1.addInterest("B");
		t1.addInterest("C");
		t2 = new ICritterCat("Test2", null);
		t2.addInterest("Q");
		t2.addInterest("W");
		t2.addInterest("E");
		t2.addInterest("R");
		t3 = new ICritterPenguin("Test3", null);
		t3.addInterest("A");
		t3.addInterest("B");
		t3.addInterest("F");
		t4 = new ICritterPenguin("Test4", null);
		t4.addInterest("Q");
		t4.addInterest("E");
		t4.addInterest("W");
		t4.addInterest("Z");
		world = new ICritterWorld();
		worldList = world.listICritters();
		world.addICritter(t1);
		world.addICritter(t2);
		world.addICritter(t3);
		world.addICritter(t4);
		world.runJamboree();
		t1Friends = worldList.get(0).getFriends();
		t2Friends = worldList.get(1).getFriends();
		t3Friends = worldList.get(2).getFriends();
		t4Friends = worldList.get(3).getFriends();
		// Land Critter will never add a marine Critter
		assertEquals(t1Friends.size(), 1);
		// Should only have one friend as well
		assertEquals(t2Friends.size(), 1);
		// Should be friends with just T2
		assertEquals(t3Friends.size(), 1);
		// Should be friends with just T1
		assertEquals(t4Friends.size(), 1);

	}
}
