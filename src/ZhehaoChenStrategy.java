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
	private int maxHoleSize;
	private ArrayList<Position> candidates;
	
	
	public ZhehaoChenStrategy()
	{
		status = Status.HUNT;
		parity = Parity.TWO;
		candidates = new ArrayList();
	}
	
	private void generateCandidates()
	{
		int div = parity.parity() - 1;
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if((i / div == 0) || (j / div == 0))
				{
					candidates.add(new Position(i , j));
				}
			}
		}
		
	}
	
	private Position nextHuntPosition()
	{
		return candidates.remove(0);
	}
	
	
}
