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
		TWO,
		THREE,
		FOUR,
		FIVE
	}
	
	private Status status;
	private Parity parity;
	private int maxHoleSize;
	private ArrayList<Position> candidates;
	private boolean CASunk = false;
	private boolean BBSunk = false;
	private boolean CCSunk = false;
	private boolean SSSunk = false;
	private boolean DDSunk = false;
	
	public ZhehaoChenStrategy()
	{
		status = Status.HUNT;
		parity = Parity.TWO;
		candidates = new ArrayList();
	}
	
	private void generateCandidates()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(i % 2 != 0)
				{
					candidates.add(new Position(i, (2 * j + 1)));
				}
				else
				{
					candidates.add(new Position(i, (2 * j)));
				}
			}
		}
	}
	
	private Position nextPosition()
	{
		return null;
	}
	
}
