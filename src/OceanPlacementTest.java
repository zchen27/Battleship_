
public class OceanPlacementTest
{
	static Ocean ocean = new Ocean();
	
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		ocean.placeAllBoats();
		long end = System.currentTimeMillis();
		System.out.println("START " + start);
		System.out.println("END " + end);
	}
}
