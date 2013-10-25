import java.util.*;

public class ThreadedAnalyzer
{
	public class HuntAnalyzer implements Runnable
	{	
		char[] initials;
		char[][] testBoard = new char[10][10];
		float[][] results = new float[10][10];
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
						filled.add(p);
					}
					else if (grid.miss(p))
					{
						testBoard[i][j] = '*';
					}
					else
					{
						testBoard[i][j] = grid.boatInitial(p);
					}
				}
			}
		}
		
		public void run()
		{
		
		}
	}
}


