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
		
		private void setCarrierForbidden()
		{
			int[] defaultForbidden = {5, 6, 7, 8, 9};
			carrierForbidden = new ArrayList();
			
		}
		
		private void setBattleshipForbidden()
		{
			int[] defaultForbidden = {6, 7, 8, 9};
			battleshipForbidden = new ArrayList();
		}
		
		private void setCruiserForbidden()
		{
			int[] defaultForbidden = {7, 8, 9};
			cruiserForbidden = new ArrayList();
		}
		
		private void setSubmarineForbidden()
		{
			int[] defaultForbidden = {7, 8, 9};
			submarineForbidden = new ArrayList();
		}
		
		private void setDestroyerForbidden()
		{
			int[] defaultForbidden = {8, 9};
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
