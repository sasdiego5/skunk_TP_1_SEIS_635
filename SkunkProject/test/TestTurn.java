import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTurn
{
	private Turn turn;
	
	@Before
	public void setUp() throws Exception
	{
		this.turn = new Turn();
	}

	@Test
	public void turn_score_0_in_new_Turn()
	{
	int turnScore = this.turn.getTurnScore();
	assertEquals("init_turn_score_not_0", turnScore, 0 );

	}
	 
	@Test public void last_roll_in_new_Turn() 
	{
	Roll lastRoll = this.turn.getLastRoll();
	assertEquals("Expected a lastRoll object", lastRoll, null );
	}

	@Test
	public void test_rollAgain()
	{
	fail("Not yet implemented");
	}

}

