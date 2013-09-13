public class GoodOcean
{
    private Boat[] myboats = new Boat[5];
    private int[][] grid = new int[10][10];
    private int boatsplaced = 0;
    
    GoodOcean() {
	for (int pos = 0; pos < 10; pos++) {
	    for (int pos2 = 0; pos2 < 10; pos2++)
		grid[pos][pos2] = -1;
	}
    }
    
    public void placeBoat(String boatName, String direction, Position pos)
	throws Exception {
	Boat myboat = new Boat(boatName, pos, direction);
	if (pos.rowIndex() < 0 || pos.columnIndex() < 0)
	    throw new Exception("out of grid");
	if (direction.equalsIgnoreCase("vertical")) {
	    if (myboat.size() + pos.rowIndex() > 10)
		throw new Exception("out of grid");
	    for (int pos1 = pos.rowIndex();
		 pos1 < myboat.size() + pos.rowIndex(); pos1++) {
		if (grid[pos1][pos.columnIndex()] != -1)
		    throw new Exception("overlapping");
	    }
	    for (int pos1 = pos.rowIndex();
		 pos1 < myboat.size() + pos.rowIndex(); pos1++)
		grid[pos1][pos.columnIndex()] = boatsplaced;
	} else {
	    if (myboat.size() + pos.columnIndex() > 10)
		throw new Exception("out of grid");
	    for (int pos1 = pos.columnIndex();
		 pos1 < myboat.size() + pos.columnIndex(); pos1++) {
		if (grid[pos.rowIndex()][pos1] != -1)
		    throw new Exception("overlapping");
	    }
	    for (int pos1 = pos.columnIndex();
		 pos1 < myboat.size() + pos.columnIndex(); pos1++)
		grid[pos.rowIndex()][pos1] = boatsplaced;
	}
	myboats[boatsplaced] = myboat;
	boatsplaced++;
    }
    
    public void shootAt(Position pos) {
	if (grid[pos.rowIndex()][pos.columnIndex()] != -1)
	    myboats[grid[pos.rowIndex()][pos.columnIndex()]].hit(pos);
    }
    
    public boolean hit(Position pos) {
	if (grid[pos.rowIndex()][pos.columnIndex()] != -1)
	    return myboats[grid[pos.rowIndex()][pos.columnIndex()]].isHit(pos);
	return false;
    }
    
    public char boatInitial(Position pos) {
	if (grid[pos.rowIndex()][pos.columnIndex()] != -1)
	    return myboats[grid[pos.rowIndex()][pos.columnIndex()]]
		       .abbreviation();
	return ' ';
    }
    
    public String boatName(Position pos) {
	if (grid[pos.rowIndex()][pos.columnIndex()] != -1)
	    return myboats[grid[pos.rowIndex()][pos.columnIndex()]].name();
	return "";
    }
    
    public boolean sunk(Position pos) {
	if (grid[pos.rowIndex()][pos.columnIndex()] != -1)
	    return myboats[grid[pos.rowIndex()][pos.columnIndex()]].sunk();
	return false;
    }
    
    public boolean allSunk() {
	for (int pos = 0; pos < boatsplaced; pos++) {
	    if (!myboats[pos].sunk())
		return false;
	}
	return true;
    }
}
