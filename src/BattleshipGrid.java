
public class BattleshipGrid
{
	//EMPTY -- '.'
	//MISS  -- '*'
	
	private char[][] grid = new char[10][10];
	
	public BattleshipGrid()
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid.length; j++)
			{
				grid[i][j] = '.';
			}
		}
	}
	
	public void shotAt(Position pos, boolean hit, char initial)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if (hit)
		{
			grid[col][row] = initial;
		}
		else
		{
			grid[col][row] = '*';
		}
	}
	
	public boolean hit(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if (grid[col][row] == '.' || grid[col][row] == '*')
		{
			return false;
		}
		return true;
	}
	
	public boolean miss(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if (grid[col][row] == '*')
		{
			return true;
		}
		return false;
    }
    
    public boolean empty(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if (grid[col][row] == '.')
		{
			return true;
		}
		return false;
	}

	public char boatInitial(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if(hit(pos))
		{
			return grid[col][row];
		}
		else
		{
			return '\u0000';
		}
	}
}