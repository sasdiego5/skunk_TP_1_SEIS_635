import java.io.IOException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp implements Reporter
{

	public static void main(String[] args) throws IOException
	{
		Game game = new Game();
		
		StdOut.println("**************************************************************************");
		StdOut.println("Welcome to 635 Skunk project!");
		
		StdOut.println("Do you want to view the rules of the game? yes or no?");

		String viewRules = StdIn.readLine();

		if (viewRules.equalsIgnoreCase("y"))
		{
			game.displayRules();
		}
		
		StdOut.println("**************************************************************************");

		while (true)
		{
					
		StdOut.println("Enter player number: ");
		int numPlayers = StdIn.readInt();
		StdIn.readLine();
		game.setPlayersNum(numPlayers);
//		Player players [] = new Player[numPlayers];
//		
//		for (int i = 0; i < players.length; i++)
//		{
//
//			StdOut.print("*  Enter the name for player " + (i + 1) + " : " + "\n");
//			String playerName = StdIn.readLine();
//			Player newPlayer = new Player(playerName);
//			players[i] = newPlayer ;
//		}
//				
//		String playerName = StdIn.readLine();
//		Player player = new Player(playerName);
		
		game.addPlayer();
		
		String player = game.getPlayerName(numPlayers-1);

		StdOut.println("Play one Turn for: " + player);

	//	Turn turn = new Turn();

		Round round = new Round();

		//while (game.getRoundNumber() <= 5)
	//	{
			StdOut.println("Starting Round number: " + round.getRoundNumber());
			
			StdOut.println("Player in turn: " + game.getPlayerName(round.getRoundNumber()));
			

			while (true)
			{
				StdOut.println(player + ", Do you want to roll the dice? yes or no?");

				String response = StdIn.readLine();

				if (!response.equals("no"))
				{
					round.rollAgain();
					round.scoreTurn();
					StdOut.println(player + " rolled a " + round.getLastRoll().getDice().getLastRoll());
					if (round.ends())
						break;
				}
				else
				{
					StdOut.println(player + " declined to roll.");
					break;
				}

			}

			//int turnScore = turn.getTurnScore();

			int turnScore = round.getTurnScore();
			round.setRoundScores(turnScore);
			StdOut.println(player + " scored " + turnScore + " for this turn.");
			
			round.startNewRound();
			
			StdOut.println(player+ " Overall Score: " + round.getRoundScores());
		}
		}
//		StdOut.println(player.getName() + "Overall Score: " + round.getRoundScores());
	//}

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);
	}

}
