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

		StdOut.println("Do you want to view the rules of the game? Enter: yes or no");

		String viewRules = StdIn.readLine();

		if (viewRules.equalsIgnoreCase("y"))
		{
			game.displayRules();
		}

		StdOut.println("**************************************************************************");

		StdOut.println("Enter number of players: ");
		int numPlayers = StdIn.readInt();
		StdIn.readLine();
		game.setPlayersNum(numPlayers);

		game.addPlayer();
		
		while (!game.winner())
		{
			String player = game.getPlayerName();

			StdOut.println("Starting Turn number: " + game.getTurnNumber());

			StdOut.println("Player in Turn to Roll the dice: " + player);

			StdOut.println("Starting turn for player number: " + game.getNextTurnIndex());

			// StdOut.println("Player in turn: " +
			// game.getPlayerName(game.getNextTurnIndex()));
			StdOut.println("Player in turn: " + game.getPlayerName());

			while (true)
			{
				StdOut.println(player + ", Do you want to roll the dice? yes or no?");

				String response = StdIn.readLine();

				if (!response.equalsIgnoreCase("no"))
				{
					game.getRound().rollAgain();
					game.getRound().scoreTurn();
					StdOut.println(player + " rolled a " + game.getRound().getLastRoll().getDice().getLastRoll());
					StdOut.println(game.getRound().getDiceVals());

					if (game.ends())
						break;
				}
				else
				{
					StdOut.println(player + " declined to roll.");
					break;
				}

//				game.nextPlayerTurn();
//				game.getRound().startNewTurn();
			}

			// int turnScore = turn.getTurnScore();

			int turnScore = game.getRound().getTurnScore();
			game.getRound().setTurnScore(turnScore);
			StdOut.println(player + " scored " + turnScore + " for this turn.");
			StdOut.println(player + " Overall Score: " + game.getRound().getTurnScore());

			 game.nextPlayerTurn();
			 game.getRound().startNewTurn();

		}
		
		StdOut.println("Winner!");
	}
	



	// StdOut.println(player.getName() + "Overall Score: " +
	// round.getRoundScores());
	// }

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);
	}

}

// Player players [] = new Player[numPlayers];
//
// for (int i = 0; i < players.length; i++)
// {
//
// StdOut.print("* Enter the name for player " + (i + 1) + " : " + "\n");
// String playerName = StdIn.readLine();
// Player newPlayer = new Player(playerName);
// players[i] = newPlayer ;
// }
//
// String playerName = StdIn.readLine();
// Player player = new Player(playerName);
