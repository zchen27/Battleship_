import java.util.*;

public class ZhehaoChenStrategy extends ComputerBattleshipPlayer
{
	public class StatisticalAnalyzer
	{
		private Ocean analysisOcean;
		private BattleshipGrid currentGrid;
		private ArrayList<Position> carrierForbidden;
		private ArrayList<Position> battleshipForbidden;
		private ArrayList<Position> cruiserForbidden;
		private ArrayList<Position> submarineForbidden;
		private ArrayList<Position> destroyerForbidden;
		
		public StatisticalAnalyzer(BattleshipGrid g)
		{
			currentGrid = g;
		}
		
		public double[][] analyze()
		{
			
			return null;
		}
		
		private void setCarrierForbidden(String dir)
		{
			int[] defaultForbidden = {6, 7, 8, 9};
			carrierForbidden = new ArrayList();
			if(dir.equalsIgnoreCase("horizontal"))
			{
				for(int i = 0; i < 10; i++)
				{
					for(int j = 0; j < defaultForbidden.length; j++)
					{
						carrierForbidden.add(new Position(defaultForbidden[j], i));
					}
				}
			}
			if(dir.equalsIgnoreCase("vertical"))
			{
				for(int i = 0; i < 10; i++)
				{
					for(int j = 0; j < defaultForbidden.length; j++)
					{
						carrierForbidden.add(new Position(i, defaultForbidden[j]));
					}
				}
			}
		}
		
		private void setBattleshipForbidden(String dir)
		{
			int[] defaultForbidden = {7, 8, 9};
			battleshipForbidden = new ArrayList();
		}
		
		private void setCruiserForbidden(String dir)
		{
			int[] defaultForbidden = {8, 9};
			cruiserForbidden = new ArrayList();
		}
		
		private void setSubmarineForbidden(String dir)
		{
			int[] defaultForbidden = {8, 9};
			submarineForbidden = new ArrayList();
		}
		
		private void setDestroyerForbidden(String dir)
		{
			int[] defaultForbidden = {9};
			destroyerForbidden = new ArrayList();
		}
		
		private void spamPlace()
		{
			
		}
	}
	
	public class Brain
	{
		
	}
}
