
public class OceanPlacementTest
{
	static Ocean ocean = new Ocean();
	
	public static void main(String[] args)
	{
		long begin = System.currentTimeMillis();
		long end;
		for(int i = 0; i < 1000000000; i++)
		{
			ocean.placeAllBoats();
		}
		end = System.currentTimeMillis();
		System.out.println(begin - end);
	}
	
}
