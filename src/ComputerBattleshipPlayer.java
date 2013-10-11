import java.lang.reflect.*;
import java.util.*;

public class ComputerBattleshipPlayer extends BattleshipPlayer
{
	
	@Override
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns)
	{
		this.updateGrid(pos, hit, initial);
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
		if(getGrid().empty(pos))
		{
			pos = shoot();
		}
		return pos;
	}
	
	@Override
	public void startGame()
	{
		try
		{
			System.out.println(this.getClass().getSuperClass().getDeclaredFields().length);
			//Field superName = this.getClass().getDeclaredFields()[0];
			//superName.setAccessible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
