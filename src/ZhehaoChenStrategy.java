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
		FIVE;
	}
	
	private Status status;
	private Parity parity;
	private int maxHoleSize;
	private ArrayList<Position[]> holes;
	private boolean CASunk = false;
	private boolean BBSunk = false;
	private boolean CCSunk = false;
	private boolean SSSunk = false;
	private boolean DDSunk = false;
	
	public ZhehaoChenStrategy()
	{
		status = Status.HUNT;
		parity = Parity.TWO;
		holes = new ArrayList();
	}
	
	private int convertHoleSize(Parity parity)
	{
		switch (parity)
		{
			case TWO:
				return 1;
			case THREE:
				return 2;
			case FOUR:
				return 3;
			case FIVE:
				return 4;
			default:
				return -1;
		}
	}
	
	private Position nextPosition()
	{
		return null;
	}
}
