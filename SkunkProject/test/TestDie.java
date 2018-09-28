import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//this is JUnit test case for the Die class

public class TestDie
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_Init_PredictableDie()
	{
		int[] initValues = new int[]
		{ 3, 2, 1 };

		Die die = new Die(initValues);
		die.roll();
		int value = die.getLastRoll();

		assertEquals("First Value Not 3", 3, value);

	}

	@Test
	public void test_Predictable_Roll_2()
	{
		Die die = new Die(new int[]
		{ 3, 2, 1 });
		die.roll();
		assertEquals("First value Not 3", 3, die.getLastRoll());

		die.roll();
		assertEquals("First value Not 3", 2, die.getLastRoll());

	}
	
	@Test
	public void test_Predictable_Roll_3()
	{
		Die die = new Die(new int[]
		{ 3, 2, 1 });
		die.roll();
		die.roll();
		die.roll();
		assertEquals("First value Not 1", 1, die.getLastRoll());

	}
	
	@Test
	public void test_Predictable_Roll_4_with_3_values()
	{
		Die die = new Die(new int[]
		{ 3, 2, 1 });
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("First value Not going back to first value 3", 3, die.getLastRoll());

	}

}
