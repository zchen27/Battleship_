

public class BattleshipGame
{
	private int turns;
	private Ocean ocean;
	private BattleshipPlayer currentPlayer;
	
	public BattleshipGame(BattleshipPlayer player)
	{
		turns = 0;
		ocean = new Ocean();
		currentPlayer = player;
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
		
		ocean.placeAllBoats();
		currentPlayer.startGame();
		while(!tooManyTurns && !gameOver)
		{
			pos = currentPlayer.shoot();
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
			if(turns > 100)
			{
				tooManyTurns = true;
			}
			currentPlayer.updatePlayer(pos, hit, initial, boatName, sunk, gameOver, tooManyTurns, turns);
		}
	}
	
}
