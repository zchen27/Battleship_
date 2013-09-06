
public class BoatTester
{
    private static Boat aircraftCarrier;
    private static Boat battleship;
    private static Boat cruiser;
    private static Boat submarine;
    private static Boat destroyer;
    private static Boat horizontalBoat;
    private static Boat verticalBoat;
    private static Boat topBoat;
    private static Boat bottomBoat;
    private static Boat leftBoat;
    private static Boat rightBoat;
    private static Boat centreBoat;
    
    public static void main(String[] args)
    {
        aircraftCarrier = new Boat("Aircraft Carrier", new Position(0, 2), "vertical");
	battleship = new Boat("Battleship", new Position(3, 5), "horizontal");
	cruiser = new Boat("Cruiser", new Position(4, 6), "horizontal");
	submarine = new Boat("Submarine", new Position(9, 1), "vertical");
	destroyer = new Boat("Destroyer", new Position(8, 7), "horizontal");
	horizontalBoat = new Boat("Battleship", new Position(6, 9), "horizontal");
	verticalBoat = new Boat("Cruiser", new Position(0, 3), "vertical");
	topBoat = new Boat("Submarine", new Position(3, 0), "horizontal");
	bottomBoat = new Boat("Destroyer", new Position(9, 3), "horizontal");
	
	
    }
    
    public static void testBoat()
    {
        
    }
    
    public static void testName()
    {
        
    }
    
    public static void testAbbreviation()
    {
        
    }
    
    public static void testSize()
    {
        
    }
    
    
}
