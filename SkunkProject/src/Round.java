import java.util.ArrayList;

public class Round 
{
	private int roundNumber;
	private Turn playerTurn;
	private ArrayList<Turn> roundScore;
	
	public Round() 
	{
		this.roundNumber = 1;
		this.playerTurn = new Turn();
		this.roundScore  = new ArrayList<>();
		
	}
	
	public void startNewRound() 
	{
		new Round();
		this.roundNumber++;
	}
	
	public int getRoundNumber() 
	{
		return roundNumber;
	}
	
	public int overallScore() 
	{
		return this.playerTurn.getTurnScore() + this.playerTurn.getTurnScore();
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
