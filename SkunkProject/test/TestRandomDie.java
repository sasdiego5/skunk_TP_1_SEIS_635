import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRandomDie
{
	private Die randDie;

	@Before
	public void setUp() throws Exception
	{
		this.randDie = new Die();

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
			this.randDie.roll();
			assertTrue("Die is outside range 1 - 6", 1<=randDie.getLastRoll() & randDie.getLastRoll() <= 6);

		}
	}

	@Test
	public void test_initial_value_before_roll() 
	{
		assertTrue("Initial die roll is outside range 1 - 6", 1<=randDie.getLastRoll() & randDie.getLastRoll() <= 6);
	}
	
	@Test
	public void test_value_in_range()
	{
		assertFalse("Initial value is not outside range 1 - 6", 1>=randDie.getLastRoll() & randDie.getLastRoll() >= 6);
	}
}
