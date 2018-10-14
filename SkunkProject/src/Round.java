import java.util.ArrayList;

public class Round 
{
	private int roundNumber;
	private Turn playerTurn;
	private ArrayList<Turn> roundScore;
	
	public Round() 
	{
		this.roundNumber = 0;
		this.playerTurn = new Turn();
		this.roundScore  = new ArrayList<>();
		
	}
	
	public void newRound() 
	{
		this.roundNumber++;
	}
	
	public int getRoundNumber() 
	{
		return roundNumber;
	}
	
	 
}
