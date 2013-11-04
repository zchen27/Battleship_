import java.util.*;
public class OceanPlacementTest
{
	
	public static void main(String[] args)
	{
		new OceanPlacementTest().place();
	}
	
	public void place()
	{
		long begin;
		long end;

		ThreadedPlace place = new ThreadedPlace();
		double lim =  (25 * 5 * 31 * 2 * 40 * 4 * 66 * 2);
		begin = System.currentTimeMillis();
		for(int i = 1; i <= lim; i++)
		{
			System.out.println( + (i / lim * 100) + "%");
			place.run();
		}
		end = System.currentTimeMillis();
	}
	
	public class ThreadedPlace implements Runnable
	{
		Ocean ocean = new Ocean();
		
		@Override
		public void run()
		{
			ocean.placeAllBoats();
		}
	}
	
}
