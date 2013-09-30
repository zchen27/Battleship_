import java.util.*;

public class BattleshipPlayer
{
	private String name;
	private BattleshipGrid grid;
	
	public BattleshipPlayer()
	{
		name = null;
	}
	
	public void startGame()
	{
		grid = new BattleshipGrid();
		if(name == null)
		{
			insertName();
		}
		
	}
	
	private void insertName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("INSERT NAME HERE");
		name = sc.nextLine();
		System.out.println("WELCOME TO BATTLESHIP");
	}
	
	public String playerName()
	{
		return name;
	}
	
	public Position shoot()
	{
		char col;
		int row;
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT COLUMN");
		col = sc.next().toUpperCase().toCharArray()[0];
		System.out.println("INSERT ROW");
		row = sc.nextInt();
		if((byte)col < (byte)'A' || )
		
	}
	
}
