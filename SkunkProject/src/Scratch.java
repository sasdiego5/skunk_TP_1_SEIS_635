import edu.princeton.cs.introcs.*;

public class Scratch
{

	public static void main(String[] args)
	{
		StdOut.println("Welcome to 635 Skunk project!");

		StdOut.println("Enter player name: ");

		String playerName = StdIn.readLine();

		Player player = new Player(playerName);

		StdOut.println("Play one Turn for: " + player.getName());

	//	Turn turn = new Turn();

		Round round = new Round();

		while (round.getTurnNumber() <= 5)
		{
			StdOut.println("Starting Round number: " + round.getTurnNumber());

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
			
			round.startNewTurn();
			
			StdOut.println(player.getName() + " Overall Score: " + round.getRoundScores());
		}
//		StdOut.println(player.getName() + "Overall Score: " + round.getRoundScores());
	}


}
