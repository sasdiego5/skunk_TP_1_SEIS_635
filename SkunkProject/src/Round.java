import java.util.ArrayList;

public class Round 
{
	private int roundNumber;
	private Turn playerTurn;
	private int roundScore;
	
	public Round() 
	{
		this.roundNumber = 1;
		this.playerTurn = new Turn();
		this.roundScore  = 0;
		
	}
	
	public void startNewRound() 
	{
		this.playerTurn = new Turn();
		this.roundNumber++;
	}
	
	public int getRoundNumber() 
	{
		return roundNumber;
	}
	
	public void setRoundScores(int scoreTurn) 
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
	
	 
}
