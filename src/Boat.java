
public class Boat
{
	private String type;
	private String direction;
	private Position[] positions;
	
	public Boat(String t, Position p, String dir)
	{
		type = t;
		direction = dir;
		this.setPositions(p);
	}
	
	private void setPositions(Position start)
	{
		int length;
		char abrv = this.abbreviation();
		switch(abrv)
		{
			case 'A': length = 5;
			case 'B': length = 4;
			case 'C': length = 3;
			case 'S': length = 3;
			case 'D': length = 2;
			default: length = 0;
		}
		
		positions = new Position[length];
		positions[0] = start;
		
		for(int i = 1; i < length; i++)
		{
			if (this.direction.equals("horizontal"))
			{	
				positions[i] = new Position(start.columnIndex() + 1, start.rowIndex());
			}
			else if (this.direction.equals("vertical"))
			{
				positions[i] = new Position(start.columnIndex(), start.rowIndex() + 1);
			}
			else
			{
				//FFFFFFFFFFFFUUUUUUUUUUUUUUUUUUUUUUU-
			}
		}
	}
	
	public String name()
	{
		return type;
	}
	
	public char abbreviation()
	{
		char[] typeArray = type.toCharArray();
		return typeArray[0];
	}
	
	public boolean onBoat(Position test)
	{
		for(int i = 0; i < length; i++)   
        {
            
        }
	}
	
}
