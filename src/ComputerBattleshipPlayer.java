import java.util.*;

public class ComputerBattleshipPlayer extends BattleshipPlayer
{
	
	@Override
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns)
	{
		updateGrid(pos, hit, initial);
	}
	
	@Override
	public String playerName()
	{
		return "Computer Battleship Player";
	}
	
	@Override
	public Position shoot()
	{
		Random random = new Random();
		int col = random.nextInt(10);
		int row = random.nextInt(10);
		Position pos = new Position(col, row);
		if(!getGrid().empty(pos))
		{
			pos = shoot();
		}
		return pos;
	}
	
	@Override
	public void startGame()
	{
		super.initializeGrid();
	}
	
}
