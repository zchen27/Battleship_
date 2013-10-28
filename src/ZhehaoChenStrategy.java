import java.util.*;

public class ZhehaoChenStrategy extends ComputerBattleshipPlayer
{	
	private enum Status
	{
		HUNT,
		TARGET
	}
	
	private enum Parity
	{
		TWO (2),
		THREE (3),
		FOUR (4),
		FIVE (5);
		
		private final int parity;
		private int parity()
		{
			return this.parity;
		}
		Parity(int i)
		{
			this.parity = i;
		}
	}
	
	private Status status;
	private Parity parity;
	private ArrayList<Position> candidates;
	private ArrayList<Integer> stillAlive = new ArrayList();
	
	
	public ZhehaoChenStrategy()
	{
		status = Status.HUNT;
		parity = Parity.TWO;
		candidates = new ArrayList();
		stillAlive.add(5);
		stillAlive.add(4);
		stillAlive.add(3);
		stillAlive.add(3);
		stillAlive.add(2);
	}
	
	@Override
	public String playerName()
	{
		return "Zhehao Chen Strategy";
	}
	
	private Position getNextTarget()
	{
		if(status.equals(Status.HUNT))
		{
			for(int col = 0; col < 10; col++)
			{
				for(int row = 0; row < 10; row++)
				{
					if(checkParity(new Position(col, row)))
					{
						return new Position(col, row);
					}
				}
			}
		}
		else if(status.equals(Status.TARGET))
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
		for(int i = 1; i < parity.parity(); i++)
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
