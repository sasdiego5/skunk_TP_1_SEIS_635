import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game
{
	private Player[] players;
	private int numPlayers;
	private Round round;
	private Player turnPlayer;
	private int nextTurnIndex;
	private Player winner;
	private int kitty;

	public Game()
	{
		this.round = new Round();
		this.nextTurnIndex = 0;
		this.kitty = 0;
	}

	public Round getRound()
	{
		return this.round;
	}

	public void startNewTurn()
	{
		nextPlayerTurn();
		round.startNewTurn();
	}

	public int getPlayersNum()
	{
		return this.numPlayers;
	}

	public void setPlayersNum(int playerNum)
	{
		if (playerNum < 2)
		{
			StdOut.println("The game has to be played by two or more participants!");
		}

		this.numPlayers = playerNum;
	}

	public void addPlayer()
	{
		this.players = new Player[this.numPlayers];

		for (int i = 0; i < players.length; i++)
		{
			StdOut.print("*  Enter the name for player " + (i + 1) + " : " + "\n");
			String playerName = StdIn.readLine();
			Player newPlayer = new Player(playerName);
			players[i] = newPlayer;
		}
	}

	public String getPlayerName()
	{
		String playerName = players[nextTurnIndex].getName();
		return playerName;
	}

	public Player getCurrentPlayer()
	{
		this.turnPlayer = players[nextTurnIndex];
		return turnPlayer;
	}

	public Player nextPlayerTurn()
	{
		if (nextTurnIndex < this.players.length - 1)
			nextTurnIndex++;
		else
			nextTurnIndex = 0;

		this.turnPlayer = players[nextTurnIndex];

		return this.turnPlayer;
	}

	public int getNextTurnIndex()
	{
		return this.nextTurnIndex + 1;
	}

	public int getTurnNumber()
	{
		return round.getTurnNumber();
	}

	public void penalties()
	{
		if (round.getLastRoll() == null)
			return;

		if (round.getLastRoll().isDoubleSkunk())
		{
			getCurrentPlayer().eraseScore();
			getCurrentPlayer().subtractChips(4);
			setKitty(4);
		}

		else if (round.getLastRoll().isDeuceSkunk())
		{
			getCurrentPlayer().subtractChips(2);
			setKitty(2);
		}
		else if (round.getLastRoll().isSingleSkunk())
		{
			getCurrentPlayer().subtractChips(1);
			setKitty(1);
		}
	}

	public boolean win()
	{
		for (int i = 0; i < players.length; i++)
			if (players[i].getScore() >= 24)
			{
				this.winner = players[i];
				return true;
			}
		return false;
	}

	public Player getWinner()
	{
		return this.winner;
	}

	public boolean ends()
	{
		return this.round.ends();
	}

	public void setKitty(int chips)
	{
		this.kitty += chips;
	}

	public int getKitty()
	{
		return this.kitty;
	}

	public void winKitty()
	{
		getWinner().addChips(getKitty());
	}

	public void lastChanceTurn()
	{
		StdOut.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		StdOut.println(getWinner().getName() + " has reached a winning score");
		StdOut.println("Each of the other players get one more turn!");

		if (getCurrentPlayer().getScore() > 24)
		{
			nextPlayerTurn();
			getRound().startNewTurn();
		}

		while (true)
		{
			StdOut.println(getCurrentPlayer().getName() + ", Do you want to roll the dice? yes or no?");

			String response = StdIn.readLine();

			if (!response.equalsIgnoreCase("no"))
			{
				getRound().rollAgain();
				getRound().scoreTurn();
				StdOut.println(getCurrentPlayer() + " rolled a " + getRound().getLastRoll().getDice().getLastRoll());
				StdOut.println(getRound().getDiceVals());

				if (ends())
					break;
			}
			else
			{
				StdOut.println(getCurrentPlayer() + " declined to roll.");
				break;
			}

			int turnScore = getRound().getTurnScore();
			getCurrentPlayer().setScore(turnScore);
			penalties();
			nextPlayerTurn();
			getRound().startNewTurn();

		}

	}

	public void gameStats()
	{
		StdOut.println("==============================================");
		StdOut.println("Round Stats \n");
		StdOut.println("Turns played: " + getTurnNumber() + "\n");
		for (int i = 0; i < players.length; i++)
		{
			StdOut.print(players[i]);
			StdOut.println("=========================================");
		}
	}

	public void displayRules() throws IOException
	{
		String Line;
		Scanner fileScan;

		fileScan = new Scanner(new File("Skunk_Rules"));

		while (fileScan.hasNext())
		{
			Line = fileScan.nextLine();
			StdOut.println(Line);
		}
		fileScan.close();
	}

}
