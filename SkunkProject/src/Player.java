public class Player 
{
	private String name;
	private Roll diceRoll;
	private int score;
	private Turn turn;
	private int chips;
	private final int initChips = 50;
	
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
	
	public int getScore() 
	{
		return this.score;
	}
	
	public void setScore() 
	{
		this.score += score;
	}
	
	public void playerRoll() 
	{
		this.diceRoll = new Roll();
	}


}
