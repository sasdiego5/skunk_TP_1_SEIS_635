import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRound
{
	private Round round;

	@Before
	public void setUp() throws Exception
	{
		this.round = new Round();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_getTurnNumber()
	{
		round.startNewTurn();
		round.startNewTurn();
		int turnNumber = this.round.getTurnNumber();
		assertEquals("The turn number is not 3",turnNumber, 3);
	}

	@Test
	public void testScoreTurn()
	{
		round.startNewTurn();
		fail("Not yet implemented");
	}

	@Test
	public void testGetTurnScore()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRollAgain()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastRoll()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiceVals()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testEnds()
	{
		fail("Not yet implemented");
	}

}
