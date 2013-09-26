public class BattleshipGrid
{
	private char[][] grid = new char[10][10];

	public BattleshipGrid()
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid.length; i++)
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
			return false;
		}
		return true;
    }
    
    public boolean empty(Position pos)
	{
		int col = pos.columnIndex();
		int row = pos.rowIndex();
		if (grid[col][row] == '.')
		{
			return false;
		}
		return true;
    }
    
}
