
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
	
	public void placeBoat(String boatname, String direction, Position pos) throws Exception
	{
	    int col = pos.columnIndex();
	    int row = pos.rowIndex();
	    String dir = direction.toUpperCase();
	    Boat temp = new Boat(boatname, pos, direction);
	    if(col < 0 || row < 0 || col > 9 || row > 9)
	    {
		throw new Exception("NOT IN GRID");
	    }
	    switch(direction)
	    {
		case "HORIZONTAL":
		    if(col + temp.size() > 9)
		    {
			throw new Exception("NOT IN GRID");
		    }
		    for(int i = 0; i < temp.size(); i++)
		    {
			if(grid[col + i][row] != '.')
			{
			    throw new Exception("OCCUPIED");
			}
			grid[col + i][row] = temp.abbreviation();
		    }
		    break;
		case "VERTICAL":
		{
		    if(row + temp.size() > 9)
		    {
			throw new Exception("NOT IN GRID");
		    }
		    for(int i = 0; i < temp.size(); i++)
		    {
			if(grid[col][row + i] != '.')
			{
			    throw new Exception("OCCUPIED");
			}
			grid[col][row + i] = temp.abbreviation();
		    }
		    break;
		}
	    }
	    boats[currentBoats] = temp;
	    currentBoats++;
	}
	
	public void shootAt(Position pos)
	{
	    for(int i = 0; i < boats.length; i++)
	    {
		if(boats[i].onBoat(pos))
		{
		    boats[i].hit(pos);
		}
	    }
	}
	
	public boolean hit(Position pos)
	{
	    for(int i = 0; i < boats.length; i++)
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
	    for(int i = 0; i < boats.length; i++)
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
	    for(int i = 0; i < boats.length; i++)
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
	    if(grid[col][row] != '.')
	    {
		return grid[col][row];
	    }
	    return '\u0000';
	}
	
	public String boatName(Position pos)
	{
	    for(int i = 0; i < boats.length; i++)
	    {
		if(boats[i].onBoat(pos))
		{
		    return boats[i].name();
		}
	    }
	    return ""; 
	}
}
