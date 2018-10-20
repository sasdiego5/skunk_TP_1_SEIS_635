import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class randomDiceTest
{
	private Dice dice;
	private Die die1, die2;

	@Before
	public void setUp() throws Exception
	{
		this.die1 = new Die();
		this.die2 = new Die();
		this.dice = new Dice(die1, die2);
	} 

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_100RollsRange()
	{

		for (int i = 0; i < 100; i++)
		{
			this.dice.roll();
			assertTrue("Die is outside range 2 - 12", 2 <= dice.getLastRoll() & dice.getLastRoll() <= 12);

		}
	}

	@Test
	public void test_initial_value_before_roll()
	{
		assertTrue("Initial die roll is outside range 2 - 12", 0 <= dice.getLastRoll() & dice.getLastRoll() <= 0);
	}

	@Test
	public void test_value_in_range()
	{
		assertFalse("Initial value is not outside range 2 - 12", 2 >= dice.getLastRoll() & dice.getLastRoll() >= 12);
	}

}
