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
	
	@Override
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns)
	{
		updateGrid(pos, hit, initial);
	}
	
	private class ProbabilityAnalyzer
	{
		private BattleshipGrid grid;
		private ArrayList<Position> filled;
		private int[][] probability;
		
		ProbabilityAnalyzer(BattleshipGrid g)
		{
			grid = g;
			fillFilled();
		}
		
		private void analyze()
		{
			String[] names = {"AIRCRAFT CARRIER", "BATTLESHIP", "CRUISER", "SUBMARINE", "DESTROYER"};
			String[] directions = {"VERTICAL", "HORIZONTAL"};
			Ocean testOcean = new Ocean();
			for(int i = 0; i < names.length; i++)
			{
				for(int j = 0; j < directions.length; j++)
				{
					for(int col = 0; col < 10; col++)
					{
						for(int row = 0; row < 10; row++)
						{
							
						}
					}
				}
			}
			
		}
		
		private void fillFilled()
		{
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					Position p = new Position(i, j);
					if(!grid.empty(p))
					{
						filled.add(p);
					}
				}
			}
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
		
		private ArrayList<Position> generateHuntForbidden(String boatName, String direction)
		{
			return mergePositions(generateAlwaysForbidden(boatName, direction), generateFilledForbidden(boatName, direction));
		}
		
		private ArrayList<Position> generateAlwaysForbidden(String boatName, String direction)
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
		
		private ArrayList<Position> generateFilledForbidden(String boatName, String direction)
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
		
		private ArrayList<Position> mergePositions(ArrayList... lists)
		{
			HashSet<Position> merge = new LinkedHashSet();
			ArrayList<Position> result = new ArrayList();
			if(lists.length == 1)
			{
				return lists[0];
			}
			for(int i = 0; i < lists.length; i++)
			{
				merge.addAll(lists[i]);
			}
			result.addAll(merge);
			return result;
		}
	}
}
