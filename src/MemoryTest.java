import java.util.*;
public class MemoryTest
{
	public static void main(String[] s)
	{
		Runtime r = Runtime.getRuntime();
		long total = r.totalMemory();
		long free = r.freeMemory();
		long max = r.maxMemory();
		long cpu = r.availableProcessors();
		double m = 1048576.0;
		
		System.out.println("TOTAL MEMORY " + (total / m));
		System.out.println("MAX MEMORY " + (max / m));
		System.out.println("FREE MEMORY " + (free / m));
		System.out.println("AVAILABLE CORES " + cpu);
		
	}
}
