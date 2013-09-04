
public class PositionTester
{
	public static void main(String[] args)
	{
		test2();
	}
	
	public static void test1()
	{
		Position position1 = new Position('A', 1);
		Position position2 = new Position('H', 9);
		
		System.out.println("TESTING: NAME, COLUMN, ROW, TOSTRING");
		System.out.println("position1 " + position1.col() + " " + position1.row() + " " + position1.toString());
		System.out.println("position2 " + position2.col() + " " + position2.row() + " " + position2.toString());
	}
	
	public static void test2()
	{
		Position position1 = new Position(2, 1);
		Position position2 = new Position(3, 9);
		
		System.out.println("TESTING: NAME, COLUMN, ROW, TOSTRING");
		System.out.println("position1 " + position1.col() + " " + position1.row() + " " + position1.toString());
		System.out.println("position2 " + position2.col() + " " + position2.row() + " " + position2.toString());
		
		System.out.println("TESTING: NAME, COLUMNINDEX, ROWINDEX");
		System.out.println("position1 " + position1.columnIndex() + " " + position1.rowIndex());
		System.out.println("position2 " + position2.columnIndex() + " " + position2.rowIndex());
	}
}
