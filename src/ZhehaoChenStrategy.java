import java.util.*;

public class ZhehaoChenStrategy extends ComputerBattleshipPlayer
{	
	private enum Status
	{
		HUNT,
		TARGET;
	}
	
	private enum Parity
	{
		TWO (2),
		THREE (3),
		FOUR (4),
		FIVE (5);
		
		final int parity;
		Parity(int i)
		{
			this.parity = i;
		}

	}
	
	private enum Facing
	{
		EAST,
		NORTH,
		WEST,
		SOUTH;
	}
	
	private Status status;
	private Parity parity;
	private ArrayList<Parity> stillAlive;
	
	public ZhehaoChenStrategy()
	{
		status = Status.HUNT;
		stillAlive = new ArrayList();
		stillAlive.add(Parity.TWO);
		stillAlive.add(Parity.THREE);
		stillAlive.add(Parity.THREE);
		stillAlive.add(Parity.FOUR);
		stillAlive.add(Parity.FIVE);
		parity = Parity.TWO;
	}
	
	@Override
	public String playerName()
	{
		return "Zhehao Chen Strategy";
	}
	
	
	private Parity smallestParity()
	{
		Parity min = Parity.FIVE;
		for(Parity p: stillAlive)
		{
			if(p.compareTo(min) < 0)
			{
				min = p;
			}
		}
		return min;
	}
	
	private Position getNextHUNTTarget()
	{
		Position target;
		for(int col = 0; col < 10; col++)
		{
			for(int row = 0; row < 10; row++)
			{
				if(checkParity(new Position(col, row)))
				{
					target = new Position(col, row);
				}
			}
		}
		return null;
	}
	
	private Position getNextTARGETTarget(Parity parity, Position position, char abrv)
	{
		int col = position.columnIndex();
		int row = position.rowIndex();
		Position target;
		ArrayList<Facing> facing = new ArrayList();
		facing.add(Facing.EAST);
		facing.add(Facing.NORTH);
		facing.add(Facing.WEST);
		facing.add(Facing.SOUTH);
		
		Position east = new Position(col + 1, row);
		Position north = new Position(col, row - 1);
		Position west = new Position(col - 1, row);
		Position south = new Position(col, row + 1);
			
		if(getGrid().boatInitial(east) != abrv && !getGrid().empty(east))
		{
				facing.remove(Facing.EAST);
		}
		else if(getGrid().boatInitial(north) != abrv && !getGrid().empty(north))
		{
				facing.remove(Facing.NORTH);
		}
		else if(getGrid().boatInitial(west) != abrv && !getGrid().empty(west))
		{
				facing.remove(Facing.WEST);
		}
		else if(getGrid().boatInitial(south) != abrv && !getGrid().empty(south))
		{
				facing.remove(Facing.SOUTH);
		}
		
		for(int i = 0; i < parity.parity; i++)
		{

		}
		
		return null;
	}
	
	private boolean checkParity(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if(!getGrid().empty(new Position(col, row)))
		{
			return false;
		}
		for(int i = 1; i < parity.parity; i++)
		{
			try
			{
				if(!getGrid().empty(new Position(col + i, row)))
				{
					return false;
				}
			}
			catch(Exception e)
			{
			}
			
			try
			{
				if(!getGrid().empty(new Position(col, row + i)))
				{
					return false;
				}
			}
			catch(Exception e)
			{
			}
		}
		return true;
	}
}
