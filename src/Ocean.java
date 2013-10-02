import java.util.*;

public class Ocean
{
	private Boat[] boats = new Boat[5];
	private char[][] grid = new char[10][10];
	private int currentBoats = 0;
	
	public Ocean()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				grid[i][j] = '.';
			}
		}
	}
	
	
	public void placeAllBoats()
	{
		String[] names = {"Aircraft Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
		String direction;
		int col;
		int row;
		int dir;
		Random rand = new Random();
		
		while(currentBoats < 5)
		{
			dir = rand.nextInt(2);
			col = rand.nextInt(10);
			row = rand.nextInt(10);
			
			switch(dir)
			{
				case 0:
					direction = "HORIZONTAL";
					break;
				case 1:
					direction = "VERTICAL";
					break;
				default:
					direction = "VERTICAL";
					break;
			}
			
			try
			{
			
				placeBoat(names[currentBoats], direction, new Position(col, row));
			}
			catch (Exception e)
			{
				placeAllBoats();
			}
		}
	}
	
	public void placeBoat(String boatname, String direction, Position pos) throws Exception
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		Boat temp = new Boat(boatname, pos, direction);
		if(currentBoats >= 5)
		{
			throw new Exception("TOO MANY BOATS");
		}
		if(col < 0 || row < 0 || col > 9 || row > 9)
		{
			throw new Exception("NOT IN GRID");
		}
		if(direction.equalsIgnoreCase("HORIZONTAL"))
		{
			if(col + temp.size() > 10)
			{
				throw new Exception("NOT IN GRID");
			}
			for(int i = 0; i < temp.size(); i++)
			{
				if(grid[col + i][row] != '.')
				{
					throw new Exception("OCCUPIED");
				}
			}
			for(int i = 0; i < temp.size(); i++)
			{
				grid[col + i][row] = temp.abbreviation();
			}
		}
		else if(direction.equalsIgnoreCase("VERTICAL"))
		{
			if(row + temp.size() > 10)
			{
				throw new Exception("NOT IN GRID");
			}
			for(int i = 0; i < temp.size(); i++)
			{
				if(grid[col][row + i] != '.')
				{
					throw new Exception("OCCUPIED");
				}
			}
			for(int i = 0; i < temp.size(); i++)
			{
				grid[col][row + i] = temp.abbreviation();
			}
		}
		boats[currentBoats] = temp;
		currentBoats++;
	}
	
	public void shootAt(Position pos)
	{
		for(int i = 0; i < currentBoats; i++)
		{
			if(boats[i].onBoat(pos))
			{
				boats[i].hit(pos);
			}
		}
	}
	
	public boolean hit(Position pos)
	{
		for(int i = 0; i < currentBoats; i++)
		{
			if(boats[i].isHit(pos))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean sunk(Position pos)
	{
		for(int i = 0; i < currentBoats; i++)
		{
			if(boats[i].onBoat(pos) && boats[i].sunk())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean allSunk()
	{
		for(int i = 0; i < currentBoats; i++)
		{
			if(!boats[i].sunk())
			{
				return false;
			}
		}
		return true;
	}
	
	public char boatInitial(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		/*
		 * debug
		*/
		System.out.println(col + " " + row);
		if(grid[col][row] != '.')
		{
			return grid[col][row];
		}
		return '\u0000';
	}
	
	public String boatName(Position pos)
	{
		for(int i = 0; i < currentBoats; i++)
		{
			if(boats[i].onBoat(pos))
			{
				return boats[i].name();
			}
		}
		return ""; 
	}
}
