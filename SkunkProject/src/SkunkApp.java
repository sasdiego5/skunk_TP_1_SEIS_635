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

		while (!game.win())
		{
			String player = game.getPlayerName();

			StdOut.println("Starting Turn number: " + game.getTurnNumber());

			StdOut.println("Starting turn for player number: " + game.getNextTurnIndex());

			StdOut.println("Player in Turn to Roll the dice: " + player);

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
			}

			int turnScore = game.getRound().getTurnScore();
			game.getCurrentPlayer().setScore(turnScore);
			game.penalties();
			StdOut.println(player + " scored " + turnScore + " for this turn.");
			StdOut.println(player + "'s Overall Score: " + game.getCurrentPlayer().getScore());
			StdOut.println(player + " has " + game.getCurrentPlayer().getChips() + " chips left.");

			game.nextPlayerTurn();
			game.getRound().startNewTurn();

		}
		StdOut.println("After " + game.getTurnNumber() + " turns");
		StdOut.println(game.winner() + " is the Winner!");
		
	}

	@Override
	public void showMessage(String msg)
	{
		StdOut.println(msg);
	}
}

