
public class Round 
{
	private Turn playerTurn;
	private int roundScore;
	private int turnNumber;
	
	public Round() 
	{
		this.turnNumber = 1;
		this.playerTurn = new Turn();
		this.roundScore  = 0;
		
	}
	
	public void startNewTurn() 
	{
		this.playerTurn = new Turn();
		turnNumber++;
	}
	
	public int getTurnNumber() 
	{
		return turnNumber;
	}
	
	public void setTurnScore(int scoreTurn) 
	{
		this.roundScore += playerTurn.getTurnScore();
	}
	
	public int getRoundScores() 
	{
		return roundScore;
	}

	public void rollAgain()
	{
		this.playerTurn.rollAgain();
	}

	public void scoreTurn()
	{
		this.playerTurn.scoreTurn();
	}

	public Roll getLastRoll()
	{
		return this.playerTurn.getLastRoll();
	}

	public boolean ends()
	{
		return this.playerTurn.ends();
	}

	public int getTurnScore()
	{
		return this.playerTurn.getTurnScore();
	}
	
	public Turn getCurrentTurn() 
	{
		return this.playerTurn;
	}
	
	public String getDiceVals() 
	{
		return playerTurn.getDiceVals();
	}
}
