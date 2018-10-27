import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game 
{
	private Player player;
	private int overallScore;
	private Round round;
	private Player play[];
	
	public Game() 
	{
		
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
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.displayRules();
	}
}
