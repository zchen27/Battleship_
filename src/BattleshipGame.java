

public class BattleshipGame
{
	private int turns;
	private Ocean ocean;
	private BattleshipPlayer lePlayer;
	
	public BattleshipGame(BattleshipPlayer player)
	{
		turns = 0;
		ocean = new Ocean();
		lePlayer = player;
	}
	
	public void play()
	{
		Position pos;
		boolean hit;
		char initial;
		String boatName;
		boolean sunk;
		boolean gameOver = false;
		boolean tooManyTurns = false;
		
		while(!tooManyTurns && !gameOver)
		{
			pos = lePlayer.shoot();
			ocean.shootAt(pos);
			turns++;
			hit = ocean.hit(pos);
			initial = ocean.boatInitial(pos);
			boatName = ocean.boatName(pos);
			sunk = ocean.sunk(pos);
			if(ocean.allSunk())
			{
				gameOver = true;
			}
			if(turns > 99)
			{
				tooManyTurns = true;
			}
			lePlayer.updatePlayer(pos, hit, initial, boatName, sunk, gameOver, tooManyTurns, turns);
		}
	}
	
}
