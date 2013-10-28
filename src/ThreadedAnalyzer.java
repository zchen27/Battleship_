import java.util.*;

public class ThreadedAnalyzer
{
	public class HuntAnalyzer implements Runnable
	{	
		char[] initials;
		char[][] testBoard = new char[10][10];
		ArrayList<Position> filled = new ArrayList();
		
		
		public HuntAnalyzer(BattleshipGrid grid, char... stillAlive)
		{
			initials = stillAlive;
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					Position p = new Position(i, j);
					if(grid.empty(p))
					{
						testBoard[i][j] = '.';
					}
					else if (grid.miss(p))
					{
						testBoard[i][j] = '*';
						filled.add(p);
					}
					else
					{
						testBoard[i][j] = grid.boatInitial(p);
						filled.add(p);
					}
				}
			}
		}
		
		public int[] makeLengths()
		{
			int[] lengths = new int[initials.length];
			for(int i = 0; i < initials.length; i++)
			{
				switch(initials[i])
				{
					case 'A':
						lengths[i] = 5;
					case 'B':
						lengths[i] = 4;
					case 'C':
						lengths[i] = 3;
					case 'S':
						lengths[i] = 3;
					case 'D':
						lengths[i] = 2;
					default:
						lengths[i] = -1;
				}
			}
			return lengths;
		}
		
		public void spamPlace()
		{
			int[] lengths = makeLengths();
			for(int i = 0; i < lengths.length; i++)
			{
				
			}
		}
		
		public void run()
		{
			
		}
	}
}


