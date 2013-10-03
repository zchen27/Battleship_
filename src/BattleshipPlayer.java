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
		if (name == null)
		{
			insertName();
		}
		
	}
	
	private void insertName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT NAME HERE");
		name = sc.nextLine();
		System.out.println("WELCOME TO BATTLESHIP, " + name);
	}
	
	public String playerName()
	{
		return name;
	}
	
	public Position shoot()
	{
		char col = 'A';
		int row = 1;
		Position pos;
		
		try
		{
			col = promptCol();
			row = promptRow();
			pos = new Position(col, row);
		}
		catch (Exception e)
		{
			pos = shoot();
		}
		return pos;
	}
	
	private char promptCol()
	{
		char col;
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT COLUMN");
		col = sc.next().toUpperCase().toCharArray()[0];
		if ((byte)col < (byte)'A' || (byte)col > (byte)'J')
		{
			System.out.println("INVALID COLUMN");
			col = promptCol();
		}
		return col;
	}
	
	private int promptRow()
	{
		int row = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT ROW");
		row = sc.nextInt();
		if (row < 1 || row > 10)
		{
			System.out.println("INVALID ROW");
			row = promptRow();
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
		grid = getGrid();
		updateGrid(pos, hit, initial);
		printGrid();
		System.out.println("Turn " + turns);
		if (hit)
		{
			System.out.println(boatName + " was hit!");
		}
		else
		{
			System.out.println("Someone else take over the gun!");
		}
		if (sunk)
		{
			System.out.println("Target is knocked out, find another target.");
		}
		if (tooManyTurns)
		{
			System.out.println("Ammunition expended!");
		}
		if (gameOver)
		{
			System.out.println("Fall back, we've had enough for today");
		}	
	}
	
	public void printGrid()
	{
		System.out.println(" \t|A|B|C|D|E|F|G|H|I|J|");
		for (int i = 0; i < 10; i++)
		{
			System.out.print((i + 1) + "\t|");
			for (int j = 0; j < 10; j++)
			{
				if(grid.empty(new Position(j, i)))
				{
					System.out.print(".");
				}
				else if (grid.miss(new Position(j, i)))
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(grid.boatInitial(new Position(j, i)));
				}
				System.out.print("|");
			}
			System.out.println("");
		}
		
	}
	
}