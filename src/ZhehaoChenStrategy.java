import java.util.*;

/*
 * 
 */

public class ZhehaoChenStrategy extends ComputerBattleshipPlayer
{	
	private enum Status
	{
		HUNT,
		TARGET;
	}
	
	private enum Parity
	{
		D (2, 'D'),
		C (3, 'C'),
		S (3, 'S'),
		B (4, 'B'),
		A (5, 'A');
		
		final char name;
		final int parity;
		Parity(int i, char c)
		{
			this.parity = i;
			this.name = c;
		}

	}
	
	private enum Direction
	{
		EAST (1, 0),
		NORTH (0, -1),
		WEST (-1, 0),
		SOUTH(0, 1);
		
		final int dcol;
		final int drow;
		Direction(int c, int r)
		{
			dcol = c;
			drow = r;
		}
	}
	
	private Status status;
	private Parity parity;
	private Position lastShot;
	private char target;
	private HashSet<Parity> stillAlive;
	private HashSet<Position> targetStack;
	
	public ZhehaoChenStrategy()
	{

	}
	
	@Override
	public void startGame()
	{
		status = Status.HUNT;
		stillAlive = new HashSet();
		stillAlive.add(Parity.D);
		stillAlive.add(Parity.C);
		stillAlive.add(Parity.S);
		stillAlive.add(Parity.B);
		stillAlive.add(Parity.A);
		parity = Parity.D;
		targetStack = new HashSet();
	}
	
	@Override
	public String playerName()
	{
		return "Zhehao Chen Strategy";
	}
	
	public String author()
	{
		return "Zhehao Chen";
	}
	
	
	@Override
	public Position shoot()
	{
		if (status == Status.HUNT)
		{
			return getNextHUNTTarget();
		}
		else if(status == Status.TARGET)
		{
			
		}
		return null;
	}
	
	@Override
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns)
	{
		lastShot = pos;
		parity = smallestParity();
		if(sunk)
		{
			for(Parity p: stillAlive)
			{
				if(p.name == initial)
				{
					stillAlive.remove(p);
				}
			}
			target = straggler();
		}
		else
		{
			if(hit)
			{
				target = initial;
			}
			else
			{
				target = '\u0000';
			}
		}
	}
	
	private Parity smallestParity()
	{
		Parity min = Parity.A;
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
		Position test;
		for(int col = 0; col < 10; col++)
		{
			for(int row = 0; row < 10; row++)
			{
				if(checkParity(new Position(col, row)))
				{
					test = new Position(col, row);
					return test;
				}
			}
		}
		return null;
	}
	
	private Position getNextTARGETTarget()
	{
		int col = lastShot.columnIndex();
		int row = lastShot.rowIndex();
		int size = toParity(target).parity;
		Random random = new Random();
		Position east = null;
		Position west = null;
		Position north = null;
		Position south = null;
		
		
		for(int i = 0; i < size; i++)
		{
			
		}
		
		return null;
	}
	
	
	private Parity toParity(char initial)
	{
		switch(initial)
		{
			case 'A':
				return Parity.A;
			case 'B':
				return Parity.B;
			case 'C':
				return Parity.C;
			case 'S':
				return Parity.S;
			case 'D':
				return Parity.D;
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
			Position testE = null;
			Position testN = null;
			Position testW = null;
			Position testS = null;
			
			if(col + i <= 9)
			{
				testE = new Position(col + i, row);
			}
			if(col - i >= 0)
			{
				testW = new Position(col - i, row);
			}
			if(row + i <= 9)
			{
				testS = new Position(col, row + i);
			}
			if(row - i >= 0)
			{
				testN = new Position(col, row - i);
			}
		
			if(testE != null)
			{
				if(!getGrid().empty(testE))
				{
					return false;
				}
			}
			if(testN != null)
			{
				if(!getGrid().empty(testN))
				{
					return false;
				}
			}
			if(testW != null)
			{
				if(!getGrid().empty(testW))
				{
					return false;
				}
			}
			if(testS != null)
			{
				if(!getGrid().empty(testS))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private char straggler()
	{
		BattleshipGrid grid = getGrid();
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				char abrv = grid.boatInitial(new Position(i, j));
				for(Parity p: stillAlive)
				{
					if(p.name == abrv)
					{
						return abrv;
					}
				}
			}
		}
		return '\u0000';
	}
}
