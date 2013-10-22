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
	
	private class ProbabilityAnalyzer
	{
		private BattleshipGrid grid;
		private ArrayList<Position> filled;
		private int[][] probability;
		
		ProbabilityAnalyzer(BattleshipGrid g)
		{
			grid = g;
		}
		
		private int lengthConverter(String boatName)
		{
			int len;
			switch(boatName)
			{
				case "AIRCRAFT CARRIER":
					len = 5;
					break;
				case "BATTLESHIP":
					len = 4;
					break;
				case "CRUISER":
					len = 3;
					break;
				case "SUBMARINE":
					len = 3;
					break;
				case "DESTROYER":
					len = 2;
					break;
				default:
					len = 0;
					break;
			}
			return len;
		}
		
		private ArrayList<Position> generateDeFaultForbidden(String boatName, String direction)
		{
			int max;
			ArrayList<Position> forbidden = new ArrayList();
			boatName = boatName.toUpperCase();
			direction = direction.toUpperCase();
			max = lengthConverter(boatName) - 1;
			for(int i = 0; i <= max; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					switch(direction)
					{
						case "VERTICAL":
							forbidden.add(new Position(j, i));
							break;
						case "HORIZONTAL":
							forbidden.add(new Position(i, j));
							break;
						default:
							break;
					}
				}
			}
			return forbidden;
		}
		
		private ArrayList<Position> generateAdditionalForbidden(String boatName, String direction)
		{
			ArrayList<Position> forbidden = new ArrayList();
			direction = direction.toUpperCase();
			for(Position p: filled)
			{
				int col = p.columnIndex();
				int row = p.rowIndex();
				for(int i = 0; i < lengthConverter(boatName); i++)
				{
					switch(direction)
					{
						case "VERTICAL":
							forbidden.add(new Position(col, row - i));
							break;
							
						case "HORIZONTAL":
							forbidden.add(new Position(col - i, row));
							break;
					}
				}
			}
			return forbidden;
		}
	}
	
	
}
