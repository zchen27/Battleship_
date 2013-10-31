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
		Random random = new Random();
		facing.add(Facing.EAST);
		facing.add(Facing.NORTH);
		facing.add(Facing.WEST);
		facing.add(Facing.SOUTH);
		
		if(col == 0)
		{
			facing.remove(Facing.WEST);
		}
		else if(col == 9)
		{
			facing.remove(Facing.EAST);
		}
		
		if(row == 0)
		{
			facing.remove(Facing.NORTH);
		}
		else if(row == 9)
		{
			facing.remove(Facing.SOUTH);
		}
		
		Position east = new Position(col + 1, row);
		Position north = new Position(col, row - 1);
		Position west = new Position(col - 1, row);
		Position south = new Position(col, row + 1);
			
		if(getGrid().boatInitial(east) != abrv || getGrid().miss(east))
		{
			facing.remove(Facing.EAST);
		}
		else if(getGrid().boatInitial(north) != abrv || getGrid().miss(north))
		{
			facing.remove(Facing.NORTH);
		}
		else if(getGrid().boatInitial(west) != abrv || getGrid().miss(west))
		{
			facing.remove(Facing.WEST);
		}
		else if(getGrid().boatInitial(south) != abrv || getGrid().miss(south))
		{
			facing.remove(Facing.SOUTH);
		}
		int r = random.nextInt(facing.size());
		switch(facing.get(r))
		{
			case EAST:
				return east;
			case NORTH:
				return north;
			case WEST:
				return west;
			case SOUTH:
				return south;
			default:
				return null;
		}
	}
	
	private boolean checkParity(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		
		if(col - parity.parity < -1 || col + parity.parity > 10 || row - parity.parity < -1 || row + parity.parity > 10)
		{
			return false;
		}
		
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
