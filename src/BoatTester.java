
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
		testBoat();
		testName();
		testAbbreviation();
		testSize();
		testPosition();
		testDirection();
		testPosition();
		testOnBoat();
    }
	
	public static void testBoat()
	{
		System.out.println("TESTING Boat(), NO EXCEPTIONS SHOULD OCCUR");
		System.out.println("TESTINING 'Aircraft Carrier'");
		aircraftCarrier = new Boat("Aircraft Carrier", new Position(0, 2), "vertical");
        System.out.println("TESTING 'Battleship'");
		battleship = new Boat("Battleship", new Position(3, 5), "horizontal");
        System.out.println("TESTING 'Cruiser'");
		cruiser = new Boat("Cruiser", new Position(4, 6), "horizontal");
        System.out.println("TESING 'Submarine'");
		submarine = new Boat("Submarine", new Position(9, 1), "vertical");
        System.out.println("TESTING 'Destroyer'");
		destroyer = new Boat("Destroyer", new Position(8, 7), "horizontal");
        System.out.println("TESTING 'Horizontal'");
		horizontalBoat = new Boat("Battleship", new Position(6, 9), "horizontal");
        System.out.println("TESTING 'Vertical'");
		verticalBoat = new Boat("Cruiser", new Position(0, 3), "vertical");
        System.out.println("TESTING POSITION ON TOP");
		topBoat = new Boat("Submarine", new Position(3, 0), "horizontal");
        System.out.println("TESTING POSITION ON BOTTOM");
		bottomBoat = new Boat("Battleship", new Position(5, 9), "horizontal");
        System.out.println("TESTING POSITION ON LEFT");
		leftBoat = new Boat("Cruiser", new Position(0, 3), "vertical");
        System.out.println("TESTING POSITION ON RIGHT");
		rightBoat = new Boat("Submarine", new Position(9, 4), "vertical");
        System.out.println("TESTING POSITION ON RIGHT");
		centreBoat = new Boat("Battleship", new Position(3, 5), "horizontal");
		System.out.println("");
	}
    
	public static void testName()
	{
		System.out.println("TESTING name()");
		System.out.println("TESTING ARICRAFT CARRIER: 'AIRCRAFT CARRIER' EXPECTED " + aircraftCarrier.name());
		System.out.println("TESTING BATTLESHIP: 'BATTLESHIP' EXPECTED " + battleship.name());
		System.out.println("TESTING CRUISER: 'CRUISER EXPECTED' " + cruiser.name());
		System.out.println("TESTING SUBMARINE: 'SUBMARINE' EXPECTED " + submarine.name());
		System.out.println("TESTING DESTROYER: 'DESTROYER EXPECTED' " + destroyer.name());
		System.out.println("");
	}
    
	public static void testAbbreviation()
	{
		System.out.println("TESTING abbreviation()");
		System.out.println("TESTING AIRCRAFT CARRIER: 'A' EXPECTED " + aircraftCarrier.abbreviation());
		System.out.println("TESTING BATTLESHIP: 'B' EXPECTED " + battleship.abbreviation());
		System.out.println("TESTING CRUISER: 'C' EXPECTED " + cruiser.abbreviation());
		System.out.println("TESTING SUBMARINE: 'S' EXPECTED " + submarine.abbreviation());
		System.out.println("TESTING DESTROYER: 'D' EXPECTED " + destroyer.abbreviation());
		System.out.println("");
	}
    
	public static void testSize()
	{
		System.out.println("TESTING size()");
		System.out.println("TESTING AIRCRAFT CARRIER: '5' EXPECTED " + aircraftCarrier.size());
		System.out.println("TESTING BATTLESHIP: '4' EXPECTED " + battleship.size());
		System.out.println("TESTING CRUISER: '3' EXPECTED " + cruiser.size());
		System.out.println("TESTING SUBMARINE: '3' EXPECTED " + submarine.size());
		System.out.println("TESTING DESTROYER: '2' EXPECTED " + destroyer.size());
		System.out.println("");
	}
    
	public static void testDirection()
	{
		System.out.println("TESTING direction()");
		System.out.println("TESTING VERTICAL BOAT: 'VERTICAL' EXPECTED " + verticalBoat.direction());
		System.out.println("TESTING HORIZONTAL BOAT: 'HORIZONTAL' EXPECTED " + horizontalBoat.direction());
		System.out.println("");
	}
	
		public static void testPosition()
	{
		System.out.println("TESTING position()");
		System.out.println("TESTING TOP BOAT: POSITION ON TOP EXPECTED " + topBoat.position());
		System.out.println("TESTING BOTTOM BOAT: POSITION ON BOTTOM EXPECTED " + bottomBoat.position());
		System.out.println("TESTING LEFT BOAT: POSITION ON LEFT EXPECTED " + leftBoat.position());
		System.out.println("TESTING RIGHT BOAT: POSITION ON RIGHT EXPECTED " + rightBoat.position());
		System.out.println("TESTING CENTRE BOAT: POSITION IN CENTRE EXPECTED " + centreBoat.position());
		System.out.println("");
	}
	
	public static void testOnBoat()
	{
	    System.out.println("TESTING onBoat()");
		System.out.println("TESTING TOP BOAT AT D-1: TRUE EXPECTED " + topBoat.onBoat(new Position('D', 1)));
		System.out.println("TESTING TOP BOAT AT E-1: TRUE EXPECTED " + topBoat.onBoat(new Position('E', 1)));
		System.out.println("TESTING TOP BOAT AT F-1: TRUE EXPECTED " + topBoat.onBoat(new Position('F', 1)));
		System.out.println("TESTING TOP BOAT AT G-1: FALSE EXPECTED " + topBoat.onBoat(new Position('G', 1)));
		System.out.println("TESTING BOTTOM BOAT AT F-10: TRUE EXPECTED " + bottomBoat.onBoat(new Position('F', 10)));
		System.out.println("TESTING BOTTOM BOAT AT G-10: TRUE EXPECTED " + bottomBoat.onBoat(new Position('G', 10)));
		System.out.println("TESTING BOTTOM BOAT AT H-10: TRUE EXPECTED " + bottomBoat.onBoat(new Position('H', 10)));
		System.out.println("TESTING BOTTOM BOAT AT I-10: TRUE EXPECTED " + bottomBoat.onBoat(new Position('I', 10)));
		System.out.println("TESTING BOTTOM BOAT AT I-11: FALSE EXPECTED " + bottomBoat.onBoat(new Position('I', 11)));
		System.out.println("TESTING LEFT BOAT AT A-4: TRUE EXPECTED " + leftBoat.onBoat(new Position('A', 4)));
		System.out.println("TESTING LEFT BOAT AT A-5: TRUE EXPECTED " + leftBoat.onBoat(new Position('A', 5)));
		System.out.println("TESTING LEFT BOAT AT A-6: TRUE EXPECTED " + leftBoat.onBoat(new Position('A', 6)));
		System.out.println("TESTING LEFT BOAT AT A-3: FALSE EXPECTED " + leftBoat.onBoat(new Position('A', 3)));
		System.out.println("TESTING RIGHT BOAT AT J-5: TRUE EXPECTED " + rightBoat.onBoat(new Position('J', 5)));
		System.out.println("TESTING RIGHT BOAT AT J-6: TRUE EXPECTED " + rightBoat.onBoat(new Position('J', 6)));
		System.out.println("TESTING RIGHT BOAT AT J-7: TRUE EXPECTED " + rightBoat.onBoat(new Position('J', 7)));
		System.out.println("TESTING RIGHT BOAT AT H-4: FALSE EXPECTED " + rightBoat.onBoat(new Position('H', 4)));
		System.out.println("TESTING CENTRE BOAT AT D-6: TRUE EXPECTED " + centreBoat.onBoat(new Position('D', 6)));
		System.out.println("TESTING CENTRE BOAT AT E-6: TRUE EXPECTED " + centreBoat.onBoat(new Position('E', 6)));
		System.out.println("TESTING CENTRE BOAT AT F-6: TRUE EXPECTED " + centreBoat.onBoat(new Position('F', 6)));
		System.out.println("TESTING CENTRE BOAT AT G-6: TRUE EXPECTED " + centreBoat.onBoat(new Position('G', 6)));
		System.out.println("TESTING CENTRE BOAT AT C-6: FALSE EXPECTED " + centreBoat.onBoat(new Position('C', 6)));
		System.out.println("");
	}
	
	
}
