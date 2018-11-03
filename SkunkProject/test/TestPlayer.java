import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer
{

	private Player player;
	
	@Before
	public void setUp() throws Exception
	{
		this.player = new Player(null);
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void test_createPlayer()
	{

		this.player = new Player("Test Player Name");

		String TestPlayerName = this.player.getName();

		assertEquals("Player's name is not Test Player Name", TestPlayerName, "Test Player Name");
	}
	
	@Test
	public void test_playerName()
	{
		String TestPlayerName = "Test Player Name";

		this.player.setName(TestPlayerName);
		
		String playerName = this.player.getName();

		assertEquals("Player's name is not Test Player Name", playerName, "Test Player Name");
	}
	
	@Test
	public void test_setScore()
	{
		int score = 10;
		this.player.setScore(score);

		assertEquals("Player score is not 10", score, 10);

	}
	
	@Test
	public void test_getScore()
	{
		int score = 10;
		this.player.setScore(score);
		int playerScore = this.player.getScore();

		assertEquals("Player score is not 10", playerScore, 10);

	}
	
	@Test
	public void test_eraseScore() 
	{
		int score = 10;
		this.player.setScore(score);
		this.player.eraseScore();
		int playerScore = this.player.getScore();
		
		assertEquals("Score is not zero", playerScore, 0);
	}
	
	@Test
	public void test_Chips() 
	{
		int chips = this.player.getChips();
		
		assertEquals("The chips number is not 50", chips, 50);
	}
	
	@Test
	public void test_addChips() 
	{
		this.player.addChips(5);
		int chips = this.player.getChips();
		assertEquals("The chips number is not 55", chips, 55);
	}
	
	@Test
	public void test_subtractChips() 
	{
		this.player.subtractChips(5);
		int chips = this.player.getChips();
		assertEquals("The chips number is not 55", chips, 45);
	}
	
	@Test
	public void test_toString()
	{
		this.player = new Player("SEIS 635");
		this.player.setScore(31);
		this.player.subtractChips(6);
		
		String player = this.player.toString();
		
		String expectedString = "Player: SEIS 635\nScore: 31\nChips:44\n" ;
		
		assertEquals("The Strings do not match", player, expectedString);
				
	}
}
