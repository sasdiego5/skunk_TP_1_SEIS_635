import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */
 
public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private boolean predictableDie1 = false;
	private boolean predictableDie2 = false;
//	private int[] die1Rolls;
//	private int[] die2Rolls;
//	private int die1NextRoll_Index;
//	private int die2NextRoll_Index;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}
	
	public Dice(int[] predictable_Rolls)
	{
		if(predictable_Rolls == null) {
			throw new RuntimeException("Null initializing int[] array");
		}
		
		this.predictableDie1 = true;
		this.predictableDie2 = true;
//		this.die1Rolls = predictable_Rolls;
//		this.die2Rolls = predictable_Rolls;
//		this.die1NextRoll_Index = 0;
//		this.die2NextRoll_Index = 0;
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

			if (!predictableDie1 && !predictableDie2) {
				die1.roll();
				die2.roll();
				this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
				}
	
//			else
//			{
//				die1.roll();
//				die2.roll();
//				
//				this.lastRoll = this.die1Rolls[die1NextRoll_Index] + this.die2Rolls[die2NextRoll_Index];
//				die1NextRoll_Index++;
//				die2NextRoll_Index++;
//
//				if ((die1NextRoll_Index >= this.die1Rolls.length) && (die2NextRoll_Index >= this.die2Rolls.length))
//				{
//					die1NextRoll_Index = 0;
//					die2NextRoll_Index = 0;
//				}
//			}
		}

	

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();

	}

	// static methods can go anywhere - but at end is standard

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args)
	{
		Dice dice1 = new Dice();
		int doubleSkunkCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			dice1.roll();
			StdOut.println(dice1);
			
			if (dice1.getLastRoll() == 2)
				doubleSkunkCount++;
		}

		StdOut.println("Actual count: " + doubleSkunkCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}
}
