public class Player 
{
	private String name;
	private Roll diceRoll;
	private int score;
	private Turn turn;
	private int chips;
	
	public Player(String name) 
	{
		this.name = name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return this.name;
	}


}
