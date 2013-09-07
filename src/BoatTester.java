
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
	bottomBoat = new Boat("Battleshipr", new Position(5, 9), "horizontal");
	leftBoat = new Boat("Cruiser", new Position(0, 3), "vertical");
	rightBoat = new Boat("Submarine", new Position(9, 4), "vertical");
	centreBoat = new Boat("Battlecruiser", new Position(3, 5), "horizontal");
    }
    
    public static void testBoat()
    {
        
    }
    
    public static void testName()
    {
        System.out.println("TESTING name()");
	System.out.println("TESTING ARICRAFT CARRIER: 'AIRCRAFT CARRIER' EXPECTED " + aircraftCarrier.name());
	System.out.println("TESTING BATTLESHIP: 'BATTLESHIP' EXPECTED" + battleship.name());
	System.out.println("TESTING CRUISER: 'CRUISER EXPECTED' " + cruiser.name());
	System.out.println("TESTING SUBMARINE: 'SUBMARINE' EXPECTED " + submarine.name());
	System.out.println("TESTING DESTROYER: 'DESTROYER EXPECTED' " + destroyer.name());
    }
    
    public static void testAbbreviation()
    {
        System.out.println("TESTING abbreviation()");
	System.out.println("TESTING AIRCRAFT CARRIER: 'A' EXPECTED " + aircraftCarrier.abbreviation());
	System.out.println("TESTING BATTLESHIP: 'B' EXPECTED " + battleship.abbreviation());
	System.out.println("TESTING CRUISER: 'C' EXPECTED " + cruiser.abbreviation());
	System.out.println("TESTING SUBMARINE: 'S' EXPECTED " + submarine.abbreviation());
	System.out.println("TESTING DESTROYER: 'D' EXPECTED " + destroyer.abbreviation());
    }
    
    public static void testSize()
    {
        System.out.println("TESTING size()");
	System.out.println("TESTING AIRCRAFT CARRIER: '5' EXCEPTED " + aircraftCarrier.size());
	System.out.println("TESTING BATTLESHIP: '4' EXPECTED " + battleship.size());
	System.out.println("TESTING CRUISER: '3' EXPECTED " + cruiser.size());
	System.out.println("TESTING SUBMARINE: '3' EXPECTED " + submarine.size());
	System.out.println("TESTING DESTROYER: '2' EXPECTED " + destroyer.size());
	
    }
    
    
}
