import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game 
{
	private Player[] player;
	private int overallScore;
	private int numPlayers;
	private Round round;
	
	public Game() 
	{
		this.round = new Round();
	}
	
	public void addPlayer() 
	{		
		this.player = new Player[this.numPlayers];
		
		for (int i = 0; i < player.length; i++)
		{
			StdOut.print("*  Enter the name for player " + (i + 1) + " : " + "\n");
			String playerName = StdIn.readLine();
			Player newPlayer = new Player(playerName);
			player[i] = newPlayer;
		}
	}
	
	public void setPlayersNum(int playerNum)
	{
		this.numPlayers = playerNum;
	}
	
	public int getPlayersNum() 
	{
		return this.numPlayers;
	}
	
	public String getPlayerName(int playerIndex) 
	{
		String playerName = player[playerIndex].getName();
		return playerName;
	}
	
	public void displayRules() throws IOException {
		String Line;
		Scanner fileScan;
		
		fileScan = new Scanner(new File("Skunk_Rules"));
		
		while(fileScan.hasNext()) {
			Line = fileScan.nextLine();
			StdOut.println(Line);
			
		}
		fileScan.close();
			
	}
	
	
	
	public static void main(String[] args) throws IOException 
	{
		Game game = new Game();
//		game.displayRules();
		
		
		StdOut.println("Enter number of players: ");
		int numPlayers = StdIn.readInt();
		StdIn.readLine();
		game.setPlayersNum(numPlayers);
		
		game.addPlayer();
	}
}
