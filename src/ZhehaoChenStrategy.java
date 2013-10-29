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
		LEFT,
		RIGHT,
		UP,
		DOWN;
	}
	
	private Status status;
	private Parity parity;
	private Facing facing;
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
	
	private Position getNextTARGETTarget()
	{
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
