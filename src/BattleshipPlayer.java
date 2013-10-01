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
		System.out.println("WELCOME TO BATTLESHIP, " + name);
	}
	
	public String playerName()
	{
		return name;
	}
	
	public Position shoot()
	{
		char col;
		int row;
		col = promptCol();
		row = promptRow();
		return new Position(col, row);
	}
	
	private char promptCol()
	{
		char col;
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT COLUMN");
		col = sc.next().toUpperCase().toCharArray()[0];
		if((byte)col < (byte)'A' || (byte)col > (byte)'J')
		{
			System.out.println("INVALID COLUMN");
			promptCol();
		}
		return col;
	}
	
	private int promptRow()
	{
		int row;
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT ROW");
		row = sc.nextInt();
		if(row < 0 || row > 9)
		{
			System.out.println("INVALID ROW");
			promptRow();
		}
		return row;
	}
	
	public void updateGrid(Position pos, boolean hit, char initial)
	{
		grid.shotAt(pos, hit, initial);
	}
	
	public BattleshipGrid getGrid()
	{
		return grid;
	}

	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns)
	{
		updateGrid(pos, hit, initial);
		System.out.println("Turn " + turns);
		if(hit)
		{
			System.out.println(boatName + " was hit!");
		}
		else
		{
			System.out.println("Someone else take over the gun!");
		}
		if(sunk)
		{
			System.out.println("Target is knocked out, find another target.");
		}
		if(tooManyTurns)
		{
			System.out.println("Ammunition expended!");
		}
		if(gameOver)
		{
			System.out.println("Fall back, we've had enough for today.");
		}
	}
	
}
