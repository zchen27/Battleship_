
public class PlayerEvaluator
{
	private int[] turns;
	
	public PlayerEvaluator(ComputerBattleshipPlayer player, int runs)
	{
		turns = new int[runs];
		for(int i = 0; i < runs; i++)
		{
			BattleshipGame game = new BattleshipGame(player);
			turns[i] = game.play();
		}
	}
	
	public int maxTurns()
	{
		int currentMax = 0;
		for(int i = 0; i < turns.length; i++)
		{
			if(turns[i] > currentMax)
			{
				currentMax = turns[i];
			}
		}
		return currentMax;
	}
	
	public int minTurns()
	{
		int currentMin = 100;
		for(int i = 0; i < turns.length; i++)
		{
			if(turns[i] < currentMin)
			{
				currentMin = turns[i];
			}
		}
		return currentMin;
	}
	
	public float averageTurns()
	{
		float sum = 0;
		for(int i = 0; i < turns.length; i++)
		{
			sum += turns[i];
		}
		return sum / turns.length;
	}
}
