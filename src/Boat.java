
public class Boat
{
	private String type;
	private String direction;
	private Position[] positions;
	private boolean[] hits;
	
	public Boat(String t, Position p, String dir)
	{
		type = t;
		direction = dir;
		this.setPositions(p);
	}
	
	
	private void setPositions(Position start)
	{
		int length;
		char abrv;
        abrv = this.abbreviation();
		switch(abrv)
		{
			case 'A':
                length = 5;
				break;
			case 'B':
                length = 4;
				break;
			case 'C':
                length = 3;
				break;
			case 'S':
				length = 3;
				break;
			case 'D':
				length = 2;
				break;
            default:
				length = -1;
		}
		
		positions = new Position[length];
		positions[0] = start;
        hits = new boolean[length];
        for(int i = 0; i < length; i++)
        {
            hits[i] = false;
        }

		for(int i = 1; i < length; i++)
		{
			if(this.direction.equalsIgnoreCase("HORIZONTAL"))
			{
				positions[i] = new Position(start.columnIndex() + i, start.rowIndex());
			}    
			else if(this.direction.equalsIgnoreCase("VERTICAL"))
			{
				positions[i] = new Position(start.columnIndex(), start.rowIndex() + i);
			}
		}
		
	}
	
	public String name()
	{
		return type;
	}
	
	public char abbreviation()
	{
		type = type.toUpperCase();
        char[] typeArray = type.toCharArray();
		return typeArray[0];
	}
    
	public String direction()
    {
		return direction;
    }
    
	public int size()
	{
		return positions.length;
	}
	
	public Position position()
	{
		return positions[0];
	}
	
	public boolean onBoat(Position test)
	{
		if(indexOf(test) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    
	public void hit(Position test)
	{
		int i = indexOf(test);
		if(i > -1 && i < positions.length)
		{
			hits[i] = true;
		}
	}
    
    public boolean isHit(Position test)
    {
        
		int i = indexOf(test);
		if(i >= 0)
		{
			return hits[i];
		}
		else
		{
			return false;
		}
    }
    
	private int indexOf(Position test)
	{
		for(int i = 0; i < positions.length; i++)   
		{
			if(positions[i].rowIndex() == test.rowIndex() && positions[i].columnIndex() == test.columnIndex())
			{
				return i;
			}
		}
		return -1;
	}
    
	public boolean sunk()
	{
		for(int i = 0; i < positions.length; i++)
		{
			if(hits[i] == false)
			{
				return false;
			}
		}
		return true;
	}
}
