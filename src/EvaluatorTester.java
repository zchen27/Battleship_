

public class EvaluatorTester
{
	public static void main(String[] s)
	{
		PlayerEvaluator evaluator = new PlayerEvaluator(new ComputerBattleshipPlayer(), (10000));
		System.out.println("MAX TURNS\t" + evaluator.maxTurns());
		System.out.println("MIN TURNS\t" + evaluator.minTurns());
		System.out.println("AVERAGE TURNS\t" + evaluator.averageTurns());
	}
}
