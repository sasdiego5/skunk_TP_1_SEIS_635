import edu.princeton.cs.introcs.StdOut;

public class Player
{
	private String name;
//	private Dice diceRoll;
	private int score;
	private int chips;
	private final int initChips = 50;

	public Player(String name)
	{
		this.name = name;
		this.score = 0;
		this.chips = this.initChips;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getScore()
	{
		return this.score;
	}

	public void setScore(int score)
	{				
		this.score += score;
	}
	
	public void eraseScore() 
	{
		this.score = 0;
	}
	
	public int getChips() 
	{
		return this.chips;
	}
	
	public void addChips(int chips) 
	{
		this.chips += chips;
	}
	
	public void subtractChips(int chips) 
	{
		this.chips -= chips;
	}
	
	public String toString()
	{
		return "Player: " + this.name + "\nScore: " + this.score + "\nChips:" + this.chips + "\n";
	}

	public String getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
