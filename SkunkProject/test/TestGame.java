import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class TestGame {

	private Game game;
	
	@Before
	public void setUp() throws Exception
	{
	this.game = new Game();
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void test_getRound() {
		
		//this.round = new Round();
		//String TestRound = this.round.getRound();
		//assertEquals("This round is the correct round ",TestRound);
	}
	
	@Test
	public void test_3_players() {
		this.game = new Game();
		game.setPlayersNum(3);
		int value = game.getPlayersNum();
		assertEquals("There are ", 3, value);
	}


//	@Test
//	public void testStartNewTurn() {
//		fail("Not yet implemented");
//	}

	@Test
	public void test_getPlayersNum() {
		this.game = new Game();
		game.setPlayersNum(4);
		int value = game.getPlayersNum();
		assertEquals("There are ", 4, value);
	}

	@Test
	public void testSetPlayersNum() {
		this.game = new Game();
		game.setPlayersNum(1);
		int value = game.getPlayersNum();
		assertEquals("There are ", 1, value);
	}



	@Test
	public void test_getPlayerName() {
		this.game = new Game();
		game.setPlayersNum(1);
		game.addPlayer();
		
		String name = game.getPlayerName();
		assertEquals("The player's name is ", "Tom", name);
	}

//	@Test
//	public void testGetCurrentPlayer() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testNextPlayerTurn() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetNextTurnIndex() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetTurnNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testWinner() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEnds() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDisplayRules() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetClass() {
//		fail("Not yet implemented");
//	}

	

	

}
