
public class PlayerEvaluator
{
	int min = 100;
	int max = 0;
	float avg = 0;
	
	public PlayerEvaluator(ComputerBattleshipPlayer player, int runs)
	{
		int temp;
		int sum = 0;
		for(int i = 0; i < runs; i++)
		{
			BattleshipGame game = new BattleshipGame(player);
			temp = game.play();
			if(temp > max)
			{
				max = temp;
			}
			if(temp < min)
			{
				min = temp;
			}
			sum += temp;
		}
		avg = sum / runs;
	}
	
	public int maxTurns()
	{
		return max;
	}
	
	public int minTurns()
	{
		return min;
	}
	
	public float averageTurns()
	{
		
		return avg;
	}
}
