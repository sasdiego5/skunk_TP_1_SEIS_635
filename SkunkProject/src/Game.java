import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game
{
	private Player[] players;
	private int overallScore;
	private int numPlayers;
	private Round round;
	private Player turnPlayer;
	private int nextTurnIndex;
	private Turn turn;

	public Game()
	{
		this.round = new Round();
		this.nextTurnIndex = 0;
		
	}

	public void startNewTurn()
	{

		nextPlayerTurn();
		round.startNewTurn();
		// turn = new Turn();
		// round = new Round();
		// this.turnPlayer = players[nextTurnIndex];

	}

	public int getTurnNumber()
	{
		return round.getTurnNumber();
	}

	public Round getRound()
	{
		return this.round;
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

	public boolean winner()
	{
		for (int i = 0; i < players.length; i++)
			if (players[i].getScore() >= 11)
			return true;
		
		return false;
	}

	public boolean ends()
	{
		return this.round.ends();
		// return this.round.getCurrentTurn().ends();
		// return this.turn.ends();
	}

	public Player getCurrentPlayer()
	{
		// Player currentPlayer = players[nextTurnIndex];
		// return currentPlayer;

		this.turnPlayer = players[nextTurnIndex];
		return turnPlayer;
	}

	public int getNextTurnIndex()
	{
		return this.nextTurnIndex;
	}

	public void setPlayersNum(int playerNum)
	{
		this.numPlayers = playerNum;
	}

	public int getPlayersNum()
	{
		return this.numPlayers;
	}

	// public String getPlayerName(int playerIndex)
	// {
	// String playerName = players[playerIndex].getName();
	// return playerName;
	// }

	public String getPlayerName()
	{
		String playerName = players[nextTurnIndex].getName();
		return playerName;
	}

	public Player nextPlayerTurn()
	{
		// this.round.startNewTurn();

		if (nextTurnIndex < this.players.length - 1)
			nextTurnIndex++;
		else
			nextTurnIndex = 0;

		this.turnPlayer = players[nextTurnIndex];

		return this.turnPlayer;
	}
	
	public int playerArrayLength() 
	{
		return this.players.length;
	}

	public void setPlayerScore(int score)
	{
		this.turnPlayer.setScore(score);
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

	public static void main(String[] args) throws IOException
	{
		Game game = new Game();
		// game.displayRules();

		StdOut.println("Enter number of players: ");
		int numPlayers = StdIn.readInt();
		StdIn.readLine();
		game.setPlayersNum(numPlayers);

		game.addPlayer();
		
		StdOut.println(game.playerArrayLength());

		StdOut.println(game.getCurrentPlayer());

		game.getCurrentPlayer().setScore(2);

		StdOut.println(game.getCurrentPlayer().getScore());

		StdOut.println(game.getCurrentPlayer());
		StdOut.println(game.getCurrentPlayer().getScore());

		StdOut.println(game.nextPlayerTurn());
		StdOut.println(game.getCurrentPlayer().getScore());

		StdOut.println(game.nextPlayerTurn());
		StdOut.println(game.getCurrentPlayer().getScore());

		StdOut.println(game.nextPlayerTurn());
		StdOut.println(game.getCurrentPlayer().getScore());

		StdOut.println(game.nextPlayerTurn());
		StdOut.println(game.getCurrentPlayer().getScore());



	}
}
