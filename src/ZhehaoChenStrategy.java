import java.util.*;

public class ZhehaoChenStrategy extends ComputerBattleshipPlayer
{	
	private enum Status {HUNT, TARGET}
	
	private Status status;
	
	public ZhehaoChenStrategy()
	{
		status = Status.HUNT;
		
	}
}
