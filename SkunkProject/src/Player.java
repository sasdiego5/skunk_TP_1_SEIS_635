public class Player 
{
	private String name;
	private Round round;
	private Roll diceRoll;
	private int score;
	private Turn turn;
	private int chips;
	private final int initChips = 50;
	
	public Player(String name) 
	{
		this.name = name;
		this.score = 0;
		this.chips = this.initChips;
//		this.turn = new Turn();
	}
		
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return this.name;
	}
		
	public void playerRoll() 
	{
		this.diceRoll = new Roll();
	}
	
	public void rollAgain()
	{
//		this.turn = new Turn();
		this.turn.rollAgain();
	}
	
	public Roll getLastRoll()
	{
		return this.turn.getLastRoll();
	}
	
	public int getScore() 
	{
		return this.score;
	}
	
	public void setScore(int score) 
	{
		this.score += score;
	}
	
	public void scoreTurn()
	{
		this.turn.scoreTurn();
	}
	
	public int getTurnScore()
	{
		return this.turn.getTurnScore();
	}
	
	public void setTurnScore(int scoreTurn) 
	{
		this.score += turn.getTurnScore();
	}
	
	public String toString()
	{
		
		return "Player: " + name + ", Score: "+ score;
	}

}
