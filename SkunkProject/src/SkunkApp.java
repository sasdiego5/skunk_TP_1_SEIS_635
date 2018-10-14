import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp implements Reporter
{

	public static void main(String[] args)
	{
		StdOut.println("Welcome to 635 Skunk project!");
		
		StdOut.println("Enter player name: ");
		
		String playerName = StdIn.readLine();
		
		Player player = new Player(playerName);
		
		StdOut.println("Play one Turn for: " + playerName);
		
		
		Turn turn = new Turn(); 
		
		Round round = new Round();
	
		//while(overallPlayerScore < 100) 
		//{
		while(true) 
		{
			StdOut.println( player.getName() + ", Do you want to roll the dice? yes or no?");
			
			String response = StdIn.readLine();
			
			if (!response.equals("no"))
			{
				turn.rollAgain();
				turn.scoreTurn();
				StdOut.println( player.getName() + " rolled a " + turn.getLastRoll().getDice().getLastRoll());
				if(turn.ends())
					break;
			}
			else 
			{
				StdOut.println(  player.getName() + " declined to roll.");
				break;
			}
		
		}
		
		int turnScore = turn.getTurnScore();
		StdOut.println(player.getName() + " scored " + turnScore + " for this turn.");
			
	}
	//}
	@Override
	public void showMessage(String msg) 
	{
		StdOut.println(msg);
	}

}

