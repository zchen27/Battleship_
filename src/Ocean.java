
public abstract class Ocean {
	abstract public void placeBoat(String boatName, String direction, Position pos) throws Exception;
	abstract public void shootAt(Position pos);
	abstract public boolean hit(Position pos);
	abstract public char boatInitial(Position pos);
	abstract public String boatName(Position pos);
	abstract public boolean sunk(Position pos);
	abstract public boolean allSunk();
}
