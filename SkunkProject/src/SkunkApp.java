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
		StdOut.println("**************************************************************************");

		int numPlayers = 0;
		while (numPlayers < 2)
		{
			StdOut.println("Enter number of players: ");
			numPlayers = StdIn.readInt();
			StdIn.readLine();
			game.setPlayersNum(numPlayers);
		}

		game.addPlayer();

		StdOut.println("**************************************************************************");

		StdOut.println("Do you want to view the rules of the game? Enter: yes or no");
		String viewRules = StdIn.readLine();
		if (viewRules.equalsIgnoreCase("y"))
		{
			game.displayRules();
		}

		StdOut.println("**************************************************************************");
		StdOut.println("Let The Game Begin!");
		StdOut.println("**************************************************************************");

		while (!game.win()) // play as many turns until a player scores 100 or
							// more
		{
			String player = game.getPlayerName();

			StdOut.println("Turn " + game.getTurnNumber());

			StdOut.println("Player in Turn to Roll the dice: " + player);

			while (true)
			{
				StdOut.println(player + ", Do you want to roll the dice? yes or no?");

				String response = StdIn.readLine();

				if (!response.equalsIgnoreCase("no"))
				{
					game.getRound().rollAgain();
					game.getRound().scoreTurn();
					StdOut.println(game.getRound().getDiceVals());
					StdOut.println(player + " rolled a " + game.getRound().getLastRoll().getDice().getLastRoll());

					if (game.ends())
						break;
				}
				else
				{
					StdOut.println(player + " declined to roll.");
					break;
				}
			}

			int turnScore = game.getRound().getTurnScore();
			game.getCurrentPlayer().setScore(turnScore);
			game.penalties();
			StdOut.println(player + " scored " + turnScore + " points in this turn.");
			StdOut.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			StdOut.println(game.getCurrentPlayer());

			game.nextPlayerTurn();
			game.getRound().startNewTurn();

		}

		StdOut.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		StdOut.println(game.getWinner().getName() + " has reached a winning score");
		StdOut.println("Each of the other players get one more turn!");

		// extra turn for players to increase the score, exclude the player who
		// scored 100 or more
		int tempTurns = 1;
		while (tempTurns <= game.getPlayersNum() - 1)
		{
			while (true)
			{
				StdOut.println(game.getCurrentPlayer().getName() + ", Do you want to roll the dice? yes or no?");

				String response = StdIn.readLine();

				if (!response.equalsIgnoreCase("no"))
				{
					game.getRound().rollAgain();
					game.getRound().scoreTurn();
					StdOut.println(game.getRound().getDiceVals());
					StdOut.println(game.getCurrentPlayer().getName() + " rolled a "
							+ game.getRound().getLastRoll().getDice().getLastRoll());

					if (game.ends())
						break;
				}
				else
				{
					StdOut.println(game.getCurrentPlayer().getName() + " declined to roll.");
					break;
				}

			}
			
			int turnScore = game.getRound().getTurnScore();
			game.getCurrentPlayer().setScore(turnScore);
			game.penalties();
			StdOut.println(game.getCurrentPlayer().getName() + " scored " + turnScore + " points in this turn.");
			StdOut.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
			StdOut.println(game.getCurrentPlayer());

			game.nextPlayerTurn();
			game.getRound().startNewTurn();
			
			if (game.getCurrentPlayer().getScore() >= 100)
			{
				game.nextPlayerTurn();
				game.getRound().startNewTurn();
			}

			tempTurns++;

		}

		game.win();
		StdOut.println();
		StdOut.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		StdOut.println(game.getWinner().getName() + " is the Winner of this round!");
		game.winKitty();
		game.gameStats();
	}

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);
	}
}
