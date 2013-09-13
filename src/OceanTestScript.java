/*
 * Battleship Test Plan
 */

public class OceanTestScript {
    private static void verify(String name, String received, String expected) {
        if(received.equals(expected)) {
            System.out.println("OK:\t"+name+" returned "+received);
        } else {
            System.err.println("FAIL:\t"+name+" returned "+received+",\texpected "+expected);
        }
    }
    
    private static void verify(String name, Object received, Object expected) {
        verify(name, received.toString(), expected.toString());
    }
    
    public static void testPlaceBoat() {
        
    }
    
    public static void testHitSunk() {
        GoodOcean ocean = new GoodOcean();
        ocean.shootAt(new Position(0, 10));
        ocean.shootAt(new Position(2, 4));
	try{
	    ocean.placeBoat("Aircraft Carrier", "horizontal", new Position(3, 4));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	try{
	    ocean.placeBoat("Battleship", "vertical", new Position(2, 6));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	
	try{
	    ocean.placeBoat("Cruiser", "horizontal", new Position(3, 8));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	
	try{
	    ocean.placeBoat("Destroyer", "vertical", new Position(1, 6));
        }
        catch (Exception e) {
            System.out.println(e);     
        }
	
	//Boat Locations
	//Aircraft Carrier: D-5 E-5 F-5 G-5 H-5
	//Battleship: C-7 C-8 C-9 C-10
	//Cruiser: D-9 E-9 F-9
	//Destroyer: B-7 B-8
	
        verify("shootAt() and hit()", ocean.hit(new Position(2, 4)), true);
        verify("shootAt() and hit()", ocean.hit(new Position(1, 3)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(2, 3)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(3, 3)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(1, 4)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(3, 4)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(1, 5)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(2, 5)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(3, 5)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(0, 10)), true);
        verify("shootAt() and hit()", ocean.hit(new Position(0, 9)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(1, 10)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(1, 9)), false);
        verify("shootAt() and hit()", ocean.hit(new Position(0, 10)), true);
	//UNDAMAGED
	verify("sunk()", ocean.sunk(new Position('D', 5)), false);
	verify("sunk()", ocean.sunk(new Position('E', 5)), false);
	verify("sunk()", ocean.sunk(new Position('F', 5)), false);
	verify("sunk()", ocean.sunk(new Position('G', 5)), false);
	verify("sunk()", ocean.sunk(new Position('H', 5)), false);
	verify("sunk()", ocean.sunk(new Position('C', 7)), false);
	verify("sunk()", ocean.sunk(new Position('C', 8)), false);
	verify("sunk()", ocean.sunk(new Position('C', 9)), false);
	verify("sunk()", ocean.sunk(new Position('C', 10)), false);
	verify("sunk()", ocean.sunk(new Position('D', 9)), false);
	verify("sunk()", ocean.sunk(new Position('E', 9)), false);
	verify("sunk()", ocean.sunk(new Position('F', 9)), false);
	verify("sunk()", ocean.sunk(new Position('B', 7)), false);
	verify("sunk()", ocean.sunk(new Position('B', 8)), false);
	verify("allSunk()", ocean.allSunk(), false);
	
	ocean.hit(new Position('H', 5));
	ocean.hit(new Position('C', 7));
	ocean.hit(new Position('E', 9));
	ocean.hit(new Position('B', 7));
	//ALL BOATS DAMAGED
	verify("sunk()", ocean.sunk(new Position('H', 5)), false);
	verify("sunk()", ocean.sunk(new Position('C', 7)), false);
	verify("sunk()", ocean.sunk(new Position('E', 9)), false);
	verify("sunk()", ocean.sunk(new Position('B', 7)), false);
	verify("allSunk()", ocean.allSunk(), false);
	//SOME BOATS SUNK
	ocean.hit(new Position('B', 8));
	verify("sunk()", ocean.sunk(new Position('H', 5)), false);
	verify("sunk()", ocean.sunk(new Position('C', 7)), false);
	verify("sunk()", ocean.sunk(new Position('E', 9)), false);
	verify("sunk()", ocean.sunk(new Position('B', 7)), true);
	verify("allSunk()", ocean.allSunk(), false);
	//ALL BUT ONE BOAT SUNK
	ocean.hit(new Position('D', 9));
	ocean.hit(new Position('E', 9));
	ocean.hit(new Position('F', 9));
	ocean.hit(new Position('G', 9));
	ocean.hit(new Position('C', 7));
	ocean.hit(new Position('C', 8));
	ocean.hit(new Position('C', 9));
	ocean.hit(new Position('C', 10));
	verify("sunk()", ocean.sunk(new Position('H', 5)), false);
	verify("sunk()", ocean.sunk(new Position('C', 7)), true);
	verify("sunk()", ocean.sunk(new Position('E', 9)), true);
	verify("sunk()", ocean.sunk(new Position('B', 7)), true);
	verify("allSunk()", ocean.allSunk(), false);
	//ALL SUNK
	ocean.hit(new Position('D', 5));
	ocean.hit(new Position('E', 5));
	ocean.hit(new Position('F', 5));
	ocean.hit(new Position('G', 5));
	ocean.hit(new Position('H', 5));
	verify("sunk()", ocean.sunk(new Position('H', 5)), true);
	verify("sunk()", ocean.sunk(new Position('C', 7)), true);
	verify("sunk()", ocean.sunk(new Position('E', 9)), true);
	verify("sunk()", ocean.sunk(new Position('B', 7)), true);
	verify("allSunk()", ocean.allSunk(), true);
	
    }
    
    
    public static void RunOceanTestScript() {
        verify("abc", "a", "a");
        verify("abc", 1, 2);
    }
    
    public static void main(String[] args) {
        RunOceanTestScript();
    }
}
