
public class Game 
{
	private Player[] player;
	private int overallScore;
	private int playerNum;
	private Round round;
	
	public Game() 
	{
		
	}

	public void setPlayerNum(int playerNum)
	{
		this.playerNum = playerNum;
	}
	
	public int getPlayerNum() 
	{
		return this.playerNum;
	}
	
}
