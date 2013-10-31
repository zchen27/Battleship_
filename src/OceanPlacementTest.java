import java.util.*;
public class OceanPlacementTest
{
	
	public static void main(String[] args)
	{
		long begin;
		long end;
		try
		{
			ThreadedPlace place = new ThreadedPlace();
		}
		catch (Exception e)
		{
		}
		double lim =  (25 * 5 * 31 * 2 * 40 * 4 * 66 * 2);
		for(int i = 1; i <= lim; i++)
		{
			begin = System.currentTimeMillis();
			System.out.println( + (i / lim * 100) + "%");
		}
	}
	
	public class ThreadedPlace implements Runnable
	{
		Ocean ocean = new Ocean();
		
		public void run()
		{
			ocean.placeAllBoats();
		}
	}
	
}
