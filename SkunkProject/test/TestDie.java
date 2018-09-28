import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//this is JUnit test case for the Die class

public class TestDie
{
	private Die die;

	@Before
	public void setUp() throws Exception
	{
		int[] initValues = new int[]
		{ 3, 2, 1 };

		this.die = new Die(initValues);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_Init_PredictableDie()
	{

		die.roll();
		int value = die.getLastRoll();

		assertEquals("First Value Not 3", 3, value);

	}

	@Test
	public void test_Predictable_Roll_2()
	{

		die.roll();
		assertEquals("First value Not 3", 3, die.getLastRoll());

		die.roll();
		assertEquals("First value Not 3", 2, die.getLastRoll());

	}

	@Test
	public void test_Predictable_Roll_3()
	{

		die.roll();
		die.roll();
		die.roll();
		assertEquals("First value Not 1", 1, die.getLastRoll());

	}

	@Test
	public void test_Predictable_Roll_4_with_3_values()
	{

		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("First value Not going back to first value 3", 3, die.getLastRoll());

	}
	
	@Test
	public void test_Predictable_Roll_5_with_3_values()
	{

		die.roll();
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals("First value Not going back to second value 2", 2, die.getLastRoll());

	}
	
	@Test(expected = RuntimeException.class)
	public void test_Null_initial_int_array() 
	{
		Die die = new Die(null);
		die.roll();
	}

}
