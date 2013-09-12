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
        verify("shootAt()", ocean.hit(new Position(2, 4)), true);
        verify("shootAt()", ocean.hit(new Position(1, 3)), false);
        verify("shootAt()", ocean.hit(new Position(2, 3)), false);
        verify("shootAt()", ocean.hit(new Position(3, 3)), false);
        verify("shootAt()", ocean.hit(new Position(1, 4)), false);
        verify("shootAt()", ocean.hit(new Position(3, 4)), false);
        verify("shootAt()", ocean.hit(new Position(1, 5)), false);
        verify("shootAt()", ocean.hit(new Position(2, 5)), false);
        verify("shootAt()", ocean.hit(new Position(3, 5)), false);
        verify("shootAt()", ocean.hit(new Position(0, 10)), true);
        verify("shootAt()", ocean.hit(new Position(0, 9)), false);
        verify("shootAt()", ocean.hit(new Position(1, 10)), false);
        verify("shootAt()", ocean.hit(new Position(1, 9)), false);
        verify("shootAt()", ocean.hit(new Position(0, 10)), true);
        
    }
    
    public static void RunOceanTestScript() {
        verify("abc", "a", "a");
        verify("abc", 1, 2);
    }
    
    public static void main(String[] args) {
        RunOceanTestScript();
    }
}
