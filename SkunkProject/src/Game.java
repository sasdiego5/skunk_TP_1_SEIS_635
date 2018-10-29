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
		round = new Round();
	}

	public void startRound() 
	{
		turn = new Turn();
		round = new Round();
		round.startNewTurn();
	}
	
	public int getTurnNumber() 
	{
		return round.getTurnNumber();
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
	
	public boolean ends()
	{
		return this.round.ends();
//		return this.turn.ends();
	}
	
	public Player getCurrentPlayer() 
	{
		Player currentPlayer = players[nextTurnIndex];
		return currentPlayer;
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

//	public String getPlayerName(int playerIndex)
//	{
//		String playerName = players[playerIndex].getName();
//		return playerName;
//	}

	public String getPlayerName()
	{
		String playerName = players[nextTurnIndex].getName();
		return playerName;
	}


	public void nextPlayerTurn()
	{
		
		if (nextTurnIndex >= this.players.length)
			nextTurnIndex = 0;
		else
			nextTurnIndex++;
		
//		this.turnPlayer = this.players[nextTurnIndex];
		
		this.round.startNewTurn();
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
	}
}
