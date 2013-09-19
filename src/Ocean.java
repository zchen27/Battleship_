
public class Ocean
{
	private Boat[] boats = new Boat[5];
	private Position[] positions = new Position[17];
	
	public void placeBoat(String boatName, String direction, Position pos) throws Exception
	{
		for(int i = 0; i < boats.length; i++)
		{
			if (boats[i] != null)
			{
				if(!checkInGrid(boatName, direction, pos))
				{
					throw new Exception("OUT OF BOUNDS!");
				}
			}
		}
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
}
