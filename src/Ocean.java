
public class Ocean
{
	private Boat[] boats = new Boat[5];
	private Position[] occupied = new Position[17];
	private Position[] hit = new Position[100];
	private int placedBoats = 0;
	private int filledPositions = 0;
	
	public Ocean()
	{

	}
	
	public void placeBoat(String boatName, String direction, Position pos) throws Exception
	{
		if(!checkInGrid(boatName, direction, pos))
		{
			throw new Exception("NOT TOTALLY IN GRID");
		}
		if(!searchCleared(boatName, direction, pos))
		{
			throw new Exception("OVERLAPPING ONE OR MORE BOATS");
		}
		try
		{
			dropBoat(boatName, direction, pos);
		}
		catch (Exception e)
		{
			throw new Exception("MORE THAN FIVE BOATS");
		}
	}
	
	private void dropBoat(String boatName, String direction, Position pos)
	{
		Boat boat = new Boat(boatName, pos, direction);
		char abrv = boat.abbreviation();
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		
		boats[placedBoats] = boat;
		placedBoats++;
		for(int i = 0; i < boat.size(); i++)
		{
			switch(direction)
			{
				case "HORIZONTAL":
					occupied[filledPositions] = new Position(col + i, row);
				case "VERTICAL":
					occupied[filledPositions] = new Position(col, row + i);
			}
			filledPositions++;
		}
	}
	
	private boolean checkInGrid(String boatName, String direction, Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		int size = new Boat(boatName, pos, direction).size();
		if(col < 0 || row < 0 || col + size > 9 || row + size > 9)
		{
			return false;
		}
		
		return true;
	}
	
	private boolean searchCleared(String boatName, String direction, Position pos)
	{
		Boat tempBoat = new Boat(boatName, pos, direction);
		for(int i = 0; i <= filledPositions; i++)
		{
			if(tempBoat.onBoat(occupied[i]))
			{
				return false;
			}	
		}
		return true;
	}
	
	public void shootAt(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		
	}
}
