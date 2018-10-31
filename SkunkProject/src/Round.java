public class Round
{
	private Turn playerTurn;
	private int turnNumber;

	public Round()
	{
		this.turnNumber = 1;
		this.playerTurn = new Turn();
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

	public void scoreTurn()
	{
		this.playerTurn.scoreTurn();
	}

	public int getTurnScore()
	{
		return this.playerTurn.getTurnScore();
	}

	public void rollAgain()
	{
		this.playerTurn.rollAgain();
	}

	public Roll getLastRoll()
	{
		return this.playerTurn.getLastRoll();
	}

	public String getDiceVals()
	{
		return playerTurn.getDiceVals();
	}

	public boolean ends()
	{
		return this.playerTurn.ends();
	}
}
