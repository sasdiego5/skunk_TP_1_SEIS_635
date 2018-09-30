import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Test;

public class TestDice {
	private Dice dice;
	private Die die1, die2;
	private int[] initValuesDie1, initValuesDie2;

	@Before
	public void setUp() throws Exception
	{
		this.initValuesDie1 = new int[]
		{ 1, 2, 3 };
		this.die1 = new Die(initValuesDie1);
 
		this.dice = new Dice(die1, die2);
		
		this.initValuesDie2 = new int[]
				{ 4, 5, 6 };
		this.die2 = new Die(initValuesDie2);
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void test_Init_PredictableDie()
	{

		dice.roll();
		int value = dice.getLastRoll();

		assertEquals("First Value Not 3", 5, value);

	}

	@Test
	public void test_Predictable_Roll_2()
	{

		die1.roll();
		die1.roll();
		die2.roll();
		die2.roll();
		assertEquals("First value Not 3", 7, die1.getLastRoll() + die2.getLastRoll());


	}
}
