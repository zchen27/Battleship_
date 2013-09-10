public class Position
{
	private int row;
	private int col;
	
	public Position(char c, int r)
	{
		row = processRow(r);
		col = processCol(c);
	}
	
	public Position(int c, int r)
	{
		row = r;
		col = c;
	}
	
	private int processCol(char col)
	{
		switch (col)
		{
		case 'A': return 0;
		case 'B': return 1;
		case 'C': return 2;
		case 'D': return 3;
		case 'E': return 4;
		case 'F': return 5;
		case 'G': return 6;
		case 'H': return 7;
		case 'I': return 8;
		case 'J': return 9;
		default: return -1;
		}
	}
	
	private int processRow(int row)
	{
		return row - 1;
	}
	
	
	public char col()
	{
		switch(col)
		{
		case 0: return 'A';
		case 1: return 'B';
		case 2: return 'C';
		case 3: return 'D';
		case 4: return 'E';
		case 5: return 'F';
		case 6: return 'G';
		case 7: return 'H';
		case 8: return 'I';
		case 9: return 'J';
		default: return '\u0000';
		}
	}
	
	public int row()
	{
		return row + 1;
	}
	
	
	public int columnIndex()
	{
		return col;
	}
	
	public int rowIndex()
	{
		return row;
	}
	
	@Override
	public String toString()
	{
		return this.col() + "-" + this.row();
	}
}