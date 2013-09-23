
public class Ocean
{
	private Boat[] boats = new Boat[5];
	
	public void placeBoat(String boatName, String direction, Position pos) throws Exception
	{
		int i = 0;
		while (boats[i] != null)
		{
			System.out.println(boats[i]); 
			i++;
		}
		if(!checkInGrid(boatName, direction, pos))
		{
			throw new Exception("NOT TOTALLY IN GRID");
		}
		if(searchOverlap(boatName, direction, pos))
		{
			throw new Exception("OVERLAPPING ONE OR MORE BOATS");
		}
		
		boats[i] = new Boat(boatName, pos, direction);
	}
	
	private boolean checkInGrid(String boatname, String direction, Position pos)
	{
		int length = convertLength(boatname);
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		
		if(col < 0 || col > 9 || row < 0 || row > 9)
		{
			return false;
		}
		
		switch(direction)
		{
			case "HORIZONTAL":
				if(col + length > 9)
				{
					return false;
				}
				break;
			case "VERTICAL":
				if(row + length > 9)
				{
					return false;
				}
				break;
		}
		return true;
	}
	
	private boolean searchOverlap(String boatname, String direction, Position pos)
	{
		int length = convertLength(boatname);
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		for(int i = 0; i < length; i++)
		{
			if (checkOverlap(new Position(col, row)))
			{
				return true;
			}
			switch(direction)
			{	
				case "HORIZONTAL":
					col++;
					break;
				case "VERTICAL":
					row++;
					break;		
			}
		}
		return false;
	}
	
	private boolean checkOverlap(Position pos)
	{
		for(int i = 0; i < boats.length; i++)
		{
			if(boats[i].onBoat(pos))
			{
				return true;
			}
		}
		return false;
	}
	
	private int convertLength(String boatname)
	{
		switch (boatname)
		{
			case "Aircraft Carrier":
				return 5;
			case "Battleship":
				return 4;
			case "Cruiser":
				return 3;
			case "Submarine":
				return 3;
			case "Destroyer":
				return 2;
			default:
				return -1;
		}
	}
	
	public void shootAt(Position pos)
	{
		for (int i = 0; i < boats.length; i++)
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
	    for (int i = 0; i < boats.length; i++)
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
	
	public String boatName(Position pos)
	{
	    for (int i = 0; i < boats.length; i++)
	    {
			if(boats[i].onBoat(pos))
			{
				return boats[i].name();
			}
	    }
	    return null;
	}
	
	public char boatInitial(Position pos)
	{
	    for(int i = 0; i < boats.length; i++)
	    {
			if(boats[i].onBoat(pos))
			{
				return boats[i].abbreviation();
			}
	    }
	    return '\u0000';
	}
}
