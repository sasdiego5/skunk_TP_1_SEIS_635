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
	public void test_setName()
	{
		String TestPlayerName = "Test Player Name";
		
		this.player.setName(TestPlayerName);
		
		assertEquals("Player's name is not Test Player Name",TestPlayerName, "Test Player Name" );
	}
	
	@Test
	public void test_getName()
	{
		
		this.player = new Player("Test Player Name");
		
		String TestPlayerName = this.player.getName();
		
		assertEquals("Player's name is not Test Player Name",TestPlayerName, "Test Player Name" );
	}
	
	
	

}
