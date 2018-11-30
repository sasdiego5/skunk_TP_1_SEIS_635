import java.io.IOException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
	public SkunkController skunkDomain;
	public int numberOfPlayers;

	public SkunkApp()
	{
		skunkDomain = new SkunkController();
	}

	/**
	 * Runs the app within an event loop
	 * 
	 * @return
	 * @throws IOException 
	 */
	public boolean run() throws IOException
	{
		return skunkDomain.run();
	}

	public static void main(String[] args) throws IOException
	{
		new SkunkApp().run();

	}
}
