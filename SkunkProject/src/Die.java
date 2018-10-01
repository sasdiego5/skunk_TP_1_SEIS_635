
public class Die
{
	private int lastRoll;
	private boolean predictable = false;
	private int[] rolls; 
	private int nextRoll_Index;

	public Die()
	{
		this.roll();
	}

	// Method for JUnit Testing
	public Die(int[] predictable_Rolls)
	{
		if (predictable_Rolls == null)
		{
			throw new RuntimeException("Null initializing int[] array");
		}

		this.predictable = true;
		this.rolls = predictable_Rolls;
		this.nextRoll_Index = 0;
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		if (!predictable)
			this.lastRoll = (int) (Math.random() * 6 + 1);
		else
		{
			this.lastRoll = this.rolls[nextRoll_Index];
			nextRoll_Index++;

			if (nextRoll_Index >= this.rolls.length)
			{
				nextRoll_Index = 0;
			}
		}
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
