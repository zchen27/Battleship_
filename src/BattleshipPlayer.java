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
		initializeGrid();
		if (name == null)
		{
			insertName();
		}	
	}
	
	public void initializeGrid()
	{
		grid = new BattleshipGrid();
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
		char col;
		int row;
		Position pos;
		
		try
		{
			col = promptCol();
			row = promptRow();
			pos = new Position(col, row);
		}
		catch (Exception e)
		{
			System.out.println("HINT: Column is a char, and Row is an int.");
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
		System.out.println(" Results from Turn " + turns);
		printGrid();
		if (hit)
		{
			System.out.println(boatName + " was hit. Good thing they aren't shooting back.");
		}
		else
		{
			System.out.println("Nope, gotta try harder. There is nothing at " + pos);
		}
		if (sunk)
		{
			System.out.println("Sleep with the fishes, " + boatName + "! It was nice knowing you.");
		}
		if (tooManyTurns)
		{
			System.out.println("Please do not force me to insult your intelligence, but you failed to hit a maximum of 100 squares in 100 turns");
		}
		if (gameOver)
		{
			System.out.println("Well, you won.");
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