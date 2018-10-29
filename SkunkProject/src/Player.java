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
		this.turn = new Turn();
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
	
	public void setScore(int score) 
	{
		this.score += score;
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

	public void scoreTurn()
	{
		this.turn.scoreTurn();
	}
	
	public Roll getLastRoll()
	{
		return this.turn.getLastRoll();
	}
	
	public int getTurnScore()
	{
		return this.turn.getTurnScore();
	}
	
	public void setTurnScore(int scoreTurn) 
	{
		this.score += turn.getTurnScore();
	}
	
	public int getPlayerScore() 
	{
		return score;
	}

}
