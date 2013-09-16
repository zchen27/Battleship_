/*
 * Battleship Test Plan
 */

public class OceanTestScript {
    private static void verify(String name, String received, String expected) {
        if(received.equals(expected)) {
            System.out.println("OK:\t"+name+" returned "+received);
        } else {
            System.out.println("FAIL:\t"+name+" returned "+received+",\texpected "+expected);
        }
    }
    
    private static void verify(String name, Object received, Object expected) {
        verify(name, received.toString(), expected.toString());
    }
    
    public static void testPlaceBoat() {
        
    }
    
    public static void testHitSunk() {
        GoodOcean ocean = new GoodOcean();
	try{
	    
	    ocean.placeBoat("Aircraft Carrier", "horizontal", new Position('D', 5));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	try{
	    ocean.placeBoat("Battleship", "vertical", new Position('C', 6));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	
	try{
	    ocean.placeBoat("Cruiser", "horizontal", new Position('D', 9));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	
	try{
	    ocean.placeBoat("Destroyer", "vertical", new Position('B', 7));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	
	//Boat Locations
	//Aircraft Carrier: D-5 E-5 F-5 G-5 H-5
	//Battleship: C-6 C-7 C-8 C-9
	//Cruiser: D-9 E-9 F-9
	//Destroyer: B-7 B-8
	ocean.shootAt(new Position(0, 9));
        ocean.shootAt(new Position(2, 4));
	
	System.out.println("LOCATIONS 0,10 AND 2,4 ARE HIT");
        verify("CHECKING 2,4 FOR HIT", ocean.hit(new Position(2, 4)), true);
        verify("CHECKING 1,3 FOR HIT", ocean.hit(new Position(1, 3)), false);
        verify("CHECKING 2,4 FOR HIT", ocean.hit(new Position(2, 3)), false);
        verify("CHECKING 3,3 FOR HIT", ocean.hit(new Position(3, 3)), false);
        verify("CHECKING 1,4 FOR HIT", ocean.hit(new Position(1, 4)), false);
        verify("CHECKING 3,4 FOR HIT", ocean.hit(new Position(3, 4)), false);
        verify("CHECKING 1,5 FOR HIT", ocean.hit(new Position(1, 5)), false);
        verify("CHECKING 2,5 FOR HIT", ocean.hit(new Position(2, 5)), false);
        verify("CHECKING 3,5 FOR HIT", ocean.hit(new Position(3, 5)), false);
        verify("CHECKING 0,9 FOR HIT", ocean.hit(new Position(0, 9)), true);
        verify("CHECKING 0,8 FOR HIT", ocean.hit(new Position(0, 8)), false);
        verify("CHECKING 1,9 FOR HIT", ocean.hit(new Position(1, 9)), false);
        verify("CHECKING 1,8 FOR HIT", ocean.hit(new Position(1, 8)), false);
        verify("CHECKING 1,9 FOR HIT", ocean.hit(new Position(0, 9)), true);
	
	//UNDAMAGED
	System.out.println("ALL BOATS ARE UNDAMAGED");
	verify("sunk() D-5 ", ocean.sunk(new Position('D', 5)), false);
	verify("sunk() E-5", ocean.sunk(new Position('E', 5)), false);
	verify("sunk() F-5", ocean.sunk(new Position('F', 5)), false);
	verify("sunk() G-5", ocean.sunk(new Position('G', 5)), false);
	verify("sunk() H-5", ocean.sunk(new Position('H', 5)), false);
	verify("sunk() C-6", ocean.sunk(new Position('C', 6)), false);
	verify("sunk() C-7", ocean.sunk(new Position('C', 7)), false);
	verify("sunk() C-8", ocean.sunk(new Position('C', 8)), false);
	verify("sunk() C-9", ocean.sunk(new Position('C', 9)), false);
	verify("sunk() D-9", ocean.sunk(new Position('D', 9)), false);
	verify("sunk() E-9", ocean.sunk(new Position('E', 9)), false);
	verify("sunk() F-9", ocean.sunk(new Position('F', 9)), false);
	verify("sunk() B-7", ocean.sunk(new Position('B', 7)), false);
	verify("sunk() B-8", ocean.sunk(new Position('B', 8)), false);
	verify("allSunk()", ocean.allSunk(), false);
	System.out.println("");
	
	System.out.println("HITTING LOCATIONS H-5 C-6 E-9 B-7");
	ocean.hit(new Position('H', 5));
	ocean.hit(new Position('C', 7));
	ocean.hit(new Position('E', 9));
	ocean.hit(new Position('B', 7));
	
	//ALL BOATS DAMAGED
	verify("sunk() D-5", ocean.sunk(new Position('D', 5)), false);
	verify("sunk() E-5", ocean.sunk(new Position('E', 5)), false);
	verify("sunk() F-5", ocean.sunk(new Position('F', 5)), false);
	verify("sunk() G-5", ocean.sunk(new Position('G', 5)), false);
	verify("sunk() H-5", ocean.sunk(new Position('H', 5)), false);
	verify("sunk() C-6", ocean.sunk(new Position('C', 6)), false);
	verify("sunk() C-7", ocean.sunk(new Position('C', 7)), false);
	verify("sunk() C-8", ocean.sunk(new Position('C', 8)), false);
	verify("sunk() C-9", ocean.sunk(new Position('C', 9)), false);
	verify("sunk() D-9", ocean.sunk(new Position('D', 9)), false);
	verify("sunk() E-9", ocean.sunk(new Position('E', 9)), false);
	verify("sunk() F-9", ocean.sunk(new Position('F', 9)), false);
	verify("sunk() B-7", ocean.sunk(new Position('B', 7)), false);
	verify("sunk() B-8", ocean.sunk(new Position('B', 8)), false);
	verify("allSunk()", ocean.allSunk(), false);
	System.out.println("");
	
	System.out.println("HITTING B-8, B-8 and B-7 sunk");
	//SOME BOATS SUNK
	ocean.hit(new Position('B', 8));
	verify("sunk() D-5", ocean.sunk(new Position('D', 5)), false);
	verify("sunk() E-5", ocean.sunk(new Position('E', 5)), false);
	verify("sunk() F-5", ocean.sunk(new Position('F', 5)), false);
	verify("sunk() G-5", ocean.sunk(new Position('G', 5)), false);
	verify("sunk() H-5", ocean.sunk(new Position('H', 5)), false);
	verify("sunk() C-6", ocean.sunk(new Position('C', 6)), false);
	verify("sunk() C-7", ocean.sunk(new Position('C', 7)), false);
	verify("sunk() C-8", ocean.sunk(new Position('C', 8)), false);
	verify("sunk() C-9", ocean.sunk(new Position('C', 9)), false);
	verify("sunk() D-9", ocean.sunk(new Position('D', 9)), false);
	verify("sunk() E-9", ocean.sunk(new Position('E', 9)), false);
	verify("sunk() F-9", ocean.sunk(new Position('F', 9)), false);
	verify("sunk() B-7", ocean.sunk(new Position('B', 7)), true);
	verify("sunk() B-8", ocean.sunk(new Position('B', 8)), true);
	verify("allSunk()", ocean.allSunk(), false);
	System.out.println("");
	
	System.out.println("HITTING LOCATIONS D-9 E-9 F-9 G-9 C-6 C-7 C-8 C-9");
	System.out.println("EVERYTHING BUT D-5 E-5 F-5 G-5 H-5");
	//ALL BUT ONE BOAT SUNK
	ocean.hit(new Position('D', 9));
	ocean.hit(new Position('E', 9));
	ocean.hit(new Position('F', 9));
	ocean.hit(new Position('G', 9));
	ocean.hit(new Position('C', 7));
	ocean.hit(new Position('C', 8));
	ocean.hit(new Position('C', 9));
	ocean.hit(new Position('C', 10));
	verify("sunk() D-5", ocean.sunk(new Position('D', 5)), false);
	verify("sunk() E-5", ocean.sunk(new Position('E', 5)), false);
	verify("sunk() F-5", ocean.sunk(new Position('F', 5)), false);
	verify("sunk() G-5", ocean.sunk(new Position('G', 5)), false);
	verify("sunk() H-5", ocean.sunk(new Position('H', 5)), false);
	verify("sunk() C-6", ocean.sunk(new Position('C', 6)), true);
	verify("sunk() C-7", ocean.sunk(new Position('C', 7)), true);
	verify("sunk() C-8", ocean.sunk(new Position('C', 8)), true);
	verify("sunk() C-9", ocean.sunk(new Position('C', 9)), true);
	verify("sunk() D-9", ocean.sunk(new Position('D', 9)), true);
	verify("sunk() E-9", ocean.sunk(new Position('E', 9)), true);
	verify("sunk() F-9", ocean.sunk(new Position('F', 9)), true);
	verify("sunk() B-7", ocean.sunk(new Position('B', 7)), true);
	verify("sunk() B-8", ocean.sunk(new Position('B', 8)), true);
	verify("allSunk()", ocean.allSunk(), false);
	System.out.println("");
	
	//ALL SUNK
	System.out.println("HITTING LOCATIONS D-5 E-5 F-5 G-5 H-5 EVERYTHING IS SUNK");
	verify("sunk() D-5", ocean.sunk(new Position('D', 5)), true);
	verify("sunk() E-5", ocean.sunk(new Position('E', 5)), true);
	verify("sunk() F-5", ocean.sunk(new Position('F', 5)), true);
	verify("sunk() G-5", ocean.sunk(new Position('G', 5)), true);
	verify("sunk() H-5", ocean.sunk(new Position('H', 5)), true);
	verify("sunk() C-6", ocean.sunk(new Position('C', 6)), true);
	verify("sunk() C-7", ocean.sunk(new Position('C', 7)), true);
	verify("sunk() C-8", ocean.sunk(new Position('C', 8)), true);
	verify("sunk() C-9", ocean.sunk(new Position('C', 9)), true);
	verify("sunk() D-9", ocean.sunk(new Position('D', 9)), true);
	verify("sunk() E-9", ocean.sunk(new Position('E', 9)), true);
	verify("sunk() F-9", ocean.sunk(new Position('F', 9)), true);
	verify("sunk() B-7", ocean.sunk(new Position('B', 7)), true);
	verify("sunk() B-8", ocean.sunk(new Position('B', 8)), true);
	verify("allSunk()", ocean.allSunk(), true);
	System.out.println("");
	
    }
    
    
    public static void RunOceanTestScript() {
	  testHitSunk();
    }
    
    public static void main(String[] args) {
        RunOceanTestScript();
    }
}
