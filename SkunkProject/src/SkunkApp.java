import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp implements Reporter
{

	public static void main(String[] args)
	{
		Game game = new Game();
		
		StdOut.println("Welcome to 635 Skunk project!");
		
		StdOut.println("Enter player number: ");
		
		int playerNum = StdIn.readInt();
		StdIn.readLine();
		game.setPlayerNum(playerNum);
				
		StdOut.println("Enter player name: ");

		String playerName = StdIn.readLine();

		Player player = new Player(playerName);

		StdOut.println("Play one Turn for: " + player.getName());

	//	Turn turn = new Turn();

		Round round = new Round();

		while (round.getRoundNumber() <= 5)
		{
			StdOut.println("Starting Round number: " + round.getRoundNumber());

			while (true)
			{
				StdOut.println(player.getName() + ", Do you want to roll the dice? yes or no?");

				String response = StdIn.readLine();

				if (!response.equals("no"))
				{
					round.rollAgain();
					round.scoreTurn();
					StdOut.println(player.getName() + " rolled a " + round.getLastRoll().getDice().getLastRoll());
					if (round.ends())
						break;
				}
				else
				{
					StdOut.println(player.getName() + " declined to roll.");
					break;
				}

			}

			//int turnScore = turn.getTurnScore();

			int turnScore = round.getTurnScore();
			round.setRoundScores(turnScore);
			StdOut.println(player.getName() + " scored " + turnScore + " for this turn.");
			
			round.startNewRound();
			
			StdOut.println(player.getName() + " Overall Score: " + round.getRoundScores());
		}
//		StdOut.println(player.getName() + "Overall Score: " + round.getRoundScores());
	}

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);
	}

}
