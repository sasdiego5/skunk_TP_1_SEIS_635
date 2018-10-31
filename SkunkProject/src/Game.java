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

	public Game()
	{
		this.round = new Round();
		this.nextTurnIndex = 0;
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

	public Player winner()
	{
		return this.winner;
	}

	public boolean ends()
	{
		return this.round.ends();
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
		
	}
}
