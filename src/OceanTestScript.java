
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Battleship Test Plan
 */
public class OceanTestScript {

    private static void verify(String name, String received, String expected) {
        if (received.equals(expected)) {
            System.out.println("OK:\t" + name + " returned " + received);
        } else {
            System.err.println("FAIL:\t" + name + " returned " + received + ",\texpected " + expected);
        }
    }

    private static void verify(String name, Object received, Object expected) {
        verify(name, received.toString(), expected.toString());
    }

    private static void testExc(String name, Object inst, Method tg, Object ... args) {
        try {
            tg.invoke(inst, args);
            System.err.println("FAIL:\t"+name+" didn't throw exception");
            assert(false); // Make it really obvious something happened
        } catch (IllegalAccessException ex) {
            System.err.println("FAIL:\tError calling method");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex){
        	System.err.println("FAIL:\tError calling method");
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            System.out.println("OK:\t"+name+" threw exception");
        }
    }

    private static void testNoExc(String name, Object inst, Method tg, Object ... args) {
        try {
            tg.invoke(inst, args);
            System.out.println("OK:\t"+name+" didn't throw exception");
        } catch (IllegalAccessException ex) {
            System.err.println("FAIL:\tError calling method");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex){
        	System.err.println("FAIL:\tError calling method");
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            System.err.println("FAIL:\t"+name+" threw exception");
            assert(false); // Make it really obvious something happened
        }
    }

    public static void testInformationMethods() {
        Ocean  ocean = new Ocean ();
        final String h = "horizontal";
        final String v = "vertical";

        Position a1 = new Position(1, 1);
        Position a2 = new Position(2, 1);
        Position a3 = new Position(3, 1);
        Position a4 = new Position(4, 1);
        Position a5 = new Position(5, 1);

        Position d1 = new Position(2, 3);
        Position d2 = new Position(3, 3);

        Position b1 = new Position(1, 6);
        Position b2 = new Position(2, 6);
        Position b3 = new Position(3, 6);
        Position b4 = new Position(4, 6);

        Position s1 = new Position(6, 5);
        Position s2 = new Position(6, 6);
        Position s3 = new Position(6, 7);

        Position c1 = new Position(8, 2);
        Position c2 = new Position(8, 3);
        Position c3 = new Position(8, 4);


        try {
            ocean.placeBoat("Aircraft Carrier", v, a1);
            ocean.placeBoat("Battleship", v, b1);
            ocean.placeBoat("Cruiser", h, c1);
            ocean.placeBoat("Destroyer", v, d1);
            ocean.placeBoat("Submarine", h, s1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify("[B.44] boatInitial testing Aircraft square 1", ocean.boatInitial(a1), 'A');
        verify("[B.44] boatInitial testing Aircraft square 2", ocean.boatInitial(a2), 'A');
        verify("[B.44] boatInitial testing Aircraft square 3", ocean.boatInitial(a3), 'A');
        verify("[B.44] boatInitial testing Aircraft square 4", ocean.boatInitial(a4), 'A');
        verify("[B.44] boatInitial testing Aircraft square 5", ocean.boatInitial(a5), 'A');

        verify("[B.44] boatName testing Aircraft square 1", ocean.boatName(a1), "Aircraft Carrier");
        verify("[B.44] boatName testing Aircraft square 2", ocean.boatName(a2), "Aircraft Carrier");
        verify("[B.44] boatName testing Aircraft square 3", ocean.boatName(a3), "Aircraft Carrier");
        verify("[B.44] boatName testing Aircraft square 4", ocean.boatName(a4), "Aircraft Carrier");
        verify("[B.44] boatName testing Aircraft square 5", ocean.boatName(a5), "Aircraft Carrier");

        verify("[B.45] boatInitial testing Battleship square 1", ocean.boatInitial(b1), 'B');
        verify("[B.45] boatInitial testing Battleship square 2", ocean.boatInitial(b2), 'B');
        verify("[B.45] boatInitial testing Battleship square 3", ocean.boatInitial(b3), 'B');
        verify("[B.45] boatInitial testing Battleship square 4", ocean.boatInitial(b4), 'B');

        verify("[B.45] boatName testing Battleship square 1", ocean.boatName(b1), "Battleship");
        verify("[B.45] boatName testing Battleship square 2", ocean.boatName(b2), "Battleship");
        verify("[B.45] boatName testing Battleship square 3", ocean.boatName(b3), "Battleship");
        verify("[B.45] boatName testing Battleship square 4", ocean.boatName(b4), "Battleship");

        verify("[B.46] boatInitial testing Cruiser square 1", ocean.boatInitial(c1), 'C');
        verify("[B.46] boatInitial testing Cruiser square 2", ocean.boatInitial(c2), 'C');
        verify("[B.46] boatInitial testing Cruiser square 3", ocean.boatInitial(c3), 'C');

        verify("[B.46] boatName testing Cruiser square 1", ocean.boatName(c1), "Cruiser");
        verify("[B.46] boatName testing Cruiser square 2", ocean.boatName(c2), "Cruiser");
        verify("[B.46] boatName testing Cruiser square 3", ocean.boatName(c3), "Cruiser");

        verify("[B.47] boatInitial testing Submarine square 1", ocean.boatInitial(s1), 'S');
        verify("[B.47] boatInitial testing Submarine square 2", ocean.boatInitial(s2), 'S');
        verify("[B.47] boatInitial testing Submarine square 3", ocean.boatInitial(s3), 'S');

        verify("[B.47] boatName testing Submarine square 1", ocean.boatName(s1), "Submarine");
        verify("[B.47] boatName testing Submarine square 2", ocean.boatName(s2), "Submarine");
        verify("[B.47] boatName testing Submarine square 3", ocean.boatName(s3), "Submarine");

        verify("[B.48] boatInitial testing Destroyer square 1", ocean.boatInitial(d1), 'D');
        verify("[B.48] boatInitial testing Destroyer square 2", ocean.boatInitial(d2), 'D');

        verify("[B.48] boatName testing Destroyer square 1", ocean.boatName(d1), "Destroyer");
        verify("[B.48] boatName testing Destroyer square 2", ocean.boatName(d2), "Destroyer");
    }

    public static void testPlaceBoat() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method placeBoat = Ocean .class.getMethod("placeBoat", String.class, String.class, Position.class);
        Ocean  oc = new Ocean ();
        testExc("[A.1] Place horizontal boat off right edge", oc, placeBoat,
                "Destroyer", "horizontal", new Position(0, 10));
        testExc("[A.2] Place horizontal boat off right edge", oc, placeBoat,
                "Battleship", "horizontal", new Position(0, 9));
        testExc("[A.3] Place horizontal boat off right edge", oc, placeBoat,
                "Destroyer", "horizontal", new Position(0, 9));
        testNoExc("[A.4] Place horizontal destroyer in top right", oc, placeBoat,
                "Destroyer", "horizontal", new Position(0, 8));
        testNoExc("[A.4] Place horizontal battleship in top right", oc, placeBoat,
                "Battleship", "horizontal", new Position(0, 4));
        testNoExc("[A.4] Place horizontal battleship in top left", oc, placeBoat,
                "Battleship", "horizontal", new Position(0, 0));
        testNoExc("[A.5] Place horizontal battleship in the bottom left", oc, placeBoat,
                "Battleship", "horizontal", new Position(9, 0));
        testNoExc("[A.5] Place horizontal battleship in the bottom right", oc, placeBoat,
                "Battleship", "horizontal", new Position(9, 4));
        oc = new Ocean ();
        testNoExc("[A.5] Place horizontal cruiser in the bottom right", oc, placeBoat,
                "Cruiser", "horizontal", new Position(9, 7));
        oc = new Ocean ();
        testNoExc("[A.5] Place horizontal submarine in the bottom right", oc, placeBoat,
                "Submarine", "horizontal", new Position(9, 7));
        oc = new Ocean ();
        testNoExc("[A.5] Place horizontal destroyer in the bottom right", oc, placeBoat,
                "Destroyer", "horizontal", new Position(9, 8));
        oc = new Ocean ();
        testExc("[A.6] Place horizontal destroyer above top row", oc, placeBoat,
                "Destroyer", "horizontal", new Position(-1, 3));
        testExc("[A.7] Place horizontal destroyer above top row", oc, placeBoat,
                "Destroyer", "horizontal", new Position(10, 3));
        // Begin A.8
        System.out.println("[HINT]\tIf you get an exception here, it might be because the ocean can't handle 5 boats");
        testNoExc("[A.8a] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(1, 1));
        testNoExc("[A.8b] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(2, 1));
        testNoExc("[A.8c] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(3, 1));
        testNoExc("[A.8d] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(4, 1));
        testNoExc("[A.8e] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(5, 1));
        oc = new Ocean (); // I hit the 5-boat limit here
        testNoExc("[A.8f] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(6, 1));
        testNoExc("[A.8g] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(7, 1));
        testNoExc("[A.8h] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(8, 1));
        testNoExc("[A.8i] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(9, 1));
        oc = new Ocean ();
        testNoExc("[A.8j] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(1, 5));
        testNoExc("[A.8k] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(2, 5));
        testNoExc("[A.8l] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(3, 5));
        testNoExc("[A.8m] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(4, 5));
        testNoExc("[A.8n] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(5, 5));
        oc = new Ocean (); // I hit the 5-boat limit here
        testNoExc("[A.8o] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(6, 5));
        testNoExc("[A.8p] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(7, 5));
        testNoExc("[A.8q] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(8, 5));
        testNoExc("[A.8r] Place horizontal aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(9, 5));
        //End A.8
        testExc("[A.9] Place horizontal aircraft carrier way off left edge", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(-6, 0));
        testExc("[A.9] Place horizontal destroyer way off left edge", oc, placeBoat,
                "Destroyer", "horizontal", new Position(-2, 0));
        testExc("[A.10] Place horizontal aircraft carrier a bit off left edge", oc, placeBoat,
                "Aircraft Carrier", "horizontal", new Position(-2, 0));
        testExc("[A.11] Place horizontal destroyer a bit off left edge", oc, placeBoat,
                "Destroyer", "horizontal", new Position(-1, 0));
        testExc("[A.12] Place vertical cruiser completely off bottom edge", oc, placeBoat,
                "Cruiser", "vertical", new Position(10, 1));
        testExc("[A.12] Place vertical sub completely off bottom edge", oc, placeBoat,
                "Submarine", "vertical", new Position(11, 8));
        testExc("[A.13] Place vertical battleship partly off bottom edge", oc, placeBoat,
                "Battleship", "vertical", new Position(8, 0));
        testExc("[A.14] Place vertical battleship very partly off bottom edge", oc, placeBoat,
                "Battleship", "vertical", new Position(7, 0));
        // Start A.15
        oc = new Ocean ();
        testNoExc("[A.15] Place vertical battleship in top right", oc, placeBoat,
                "Battleship", "vertical", new Position(0, 9));
        testNoExc("[A.15] Place vertical cruiser in bottom right", oc, placeBoat,
                "Cruiser", "vertical", new Position(6, 9));
        // End A.15
        // Start A.16
        oc = new Ocean ();
        testNoExc("[A.16] Place vertical sub in top right", oc, placeBoat,
                "Submarine", "vertical", new Position(0, 0));
        testNoExc("[A.16] Place vertical cruiser in bottom right", oc, placeBoat,
                "Cruiser", "vertical", new Position(6, 0));
        // End A.16
        testExc("[A.17] Place vertical cruiser over right edge", oc, placeBoat,
                "Cruiser", "vertical", new Position(6, 10));
        testExc("[A.17] Place vertical destroyer over right edge", oc, placeBoat,
                "Destroyer", "vertical", new Position(1, 10));
        testExc("[A.18] Place vertical cruiser over left edge", oc, placeBoat,
                "Cruiser", "vertical", new Position(6, -1));
        testExc("[A.18] Place vertical destroyer over left edge", oc, placeBoat,
                "Destroyer", "vertical", new Position(1, -1));
        // Begin A.19
        oc = new Ocean ();
        System.out.println("[HINT]\tIf you get an exception here, it might be because the ocean can't handle 5 boats");
        testNoExc("[A.19a] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 1));
        testNoExc("[A.19b] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 2));
        testNoExc("[A.19c] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 3));
        testNoExc("[A.19d] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 4));
        testNoExc("[A.19e] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 5));
        oc = new Ocean (); // I hit the 5-boat limit here
        testNoExc("[A.19f] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 6));
        testNoExc("[A.19g] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 7));
        testNoExc("[A.19h] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 8));
        testNoExc("[A.19i] Place vertical aircraft carrier near center", oc, placeBoat,
                "Aircraft Carrier", "vertical", new Position(2, 9));
        //End A.19
        testExc("[A.20] Place vertical destroyer over top edge", oc, placeBoat,
                "Destroyer", "vertical", new Position(-2, -1));
        testExc("[A.20] Place vertical cruiser over top edge", oc, placeBoat,
                "Cruiser", "vertical", new Position(-5, 0));
        testExc("[A.21] Place vertical cruiser a bit over top edge", oc, placeBoat,
                "Cruiser", "vertical", new Position(-2, 4));
        testExc("[A.22] Place vertical destroyer a little bit over top edge", oc, placeBoat,
                "Cruiser", "vertical", new Position(-1, 6));
        oc = new Ocean ();
        testNoExc("[A.23] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 3));
        testExc("[A.23] Place an overlapping horizontal cruiser", oc, placeBoat,
                "Cruiser", "horizontal", new Position(3, 2));
        testNoExc("[A.23b] (Setup) Place normal horizontal submarine", oc, placeBoat,
                "Submarine", "horizontal", new Position(4, 3));
        testNoExc("[A.23b] Place a non-overlapping horizontal destroyer", oc, placeBoat,
                "Destroyer", "horizontal", new Position(4, 1));
        oc = new Ocean ();
        testNoExc("[A.24] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 3));
        testExc("[A.24] Place an overlapping horizontal cruiser at battleship's start position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(3, 3));
        oc = new Ocean ();
        testNoExc("[A.25] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 0));
        testNoExc("[A.25] Place an overlapping horizontal cruiser at battleship's start position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(3, 4));
        oc = new Ocean ();
        testNoExc("[A.26] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 4));
        testNoExc("[A.26] Place an non-overlapping horizontal cruiser to the left of the battleship", oc, placeBoat,
                "Cruiser", "horizontal", new Position(3, 1));
        oc = new Ocean ();
        testNoExc("[A.27] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 3));
        testNoExc("[A.27] Place a horizontal cruiser one row above battleship's start position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(2, 3));
        oc = new Ocean ();
        testNoExc("[A.28] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 3));
        testNoExc("[A.28] Place a horizontal cruiser one row below battleship's start position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(4, 3));
        oc = new Ocean ();
        testNoExc("[A.28] (Setup) Place normal vertical battleship", oc, placeBoat,
                "Battleship", "vertical", new Position(0, 4));
        testNoExc("[A.28] Place a horizontal cruiser one row below battleship's start position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(4, 3));
        oc = new Ocean ();
        testNoExc("[A.29] (Setup) Place normal vertical battleship", oc, placeBoat,
                "Battleship", "vertical", new Position(1, 3));
        testNoExc("[A.29] Place a horizontal cruiser one row above battleship's start position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(0, 3));
        oc = new Ocean ();
        testNoExc("[A.30] (Setup) Place normal vertical battleship", oc, placeBoat,
                "Battleship", "vertical", new Position(0, 3));
        testNoExc("[A.30] Place a horizontal cruiser one row below battleship's position", oc, placeBoat,
                "Cruiser", "horizontal", new Position(4, 3));
        oc = new Ocean ();
        testNoExc("[A.43] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 0));
        testExc("[A.43] Place an overlapping vertical destroyer at cruiser's end position", oc, placeBoat,
                "Destroyer", "vertical", new Position(2, 0));
        oc = new Ocean ();
        testNoExc("[A.42] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 0));
        testExc("[A.42] Place an overlapping vertical destroyer at desroyer's start position", oc, placeBoat,
                "Destroyer", "vertical", new Position(3, 0));
        oc = new Ocean ();
        testNoExc("[A.41] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 0));
        testNoExc("[A.41] Place a non-overlapping vertical destroyer to the right of the battleship", oc, placeBoat,
                "Destroyer", "vertical", new Position(3, 4));
        oc = new Ocean ();
        testNoExc("[A.40] (Setup) Place normal horizontal battleship", oc, placeBoat,
                "Battleship", "horizontal", new Position(3, 1));
        testNoExc("[A.40] Place a non-overlapping vertical destroyer to the left of the battleship", oc, placeBoat,
                "Destroyer", "vertical", new Position(3, 0));

    }

    public static void testHitSunk() {
        Ocean  ocean = new Ocean ();
        try {

            ocean.placeBoat("Aircraft Carrier", "horizontal", new Position('D', 5));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            ocean.placeBoat("Battleship", "vertical", new Position('C', 6));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ocean.placeBoat("Cruiser", "horizontal", new Position('D', 9));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            ocean.placeBoat("Destroyer", "vertical", new Position('B', 7));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Boat Locations
        //Aircraft Carrier: D-5 E-5 F-5 G-5 H-5
        //Battleship: C-6 C-7 C-8 C-9
        //Cruiser: D-9 E-9 F-9
        //Destroyer: B-7 B-8
        ocean.shootAt(new Position(0, 9));
        ocean.shootAt(new Position(3, 8));

        System.out.println("LOCATIONS 0,9 AND 3,8 ARE HIT");
        verify("CHECKING 2,4 FOR HIT", ocean.hit(new Position(3, 8)), true);
        verify("CHECKING 1,3 FOR HIT", ocean.hit(new Position(2, 7)), false);
        verify("CHECKING 2,4 FOR HIT", ocean.hit(new Position(2, 8)), false);
        verify("CHECKING 3,3 FOR HIT", ocean.hit(new Position(2, 9)), false);
        verify("CHECKING 1,4 FOR HIT", ocean.hit(new Position(3, 7)), false);
        verify("CHECKING 3,4 FOR HIT", ocean.hit(new Position(3, 9)), false);
        verify("CHECKING 1,5 FOR HIT", ocean.hit(new Position(4, 7)), false);
        verify("CHECKING 2,5 FOR HIT", ocean.hit(new Position(4, 8)), false);
        verify("CHECKING 3,5 FOR HIT", ocean.hit(new Position(4, 9)), false);
        verify("CHECKING 0,9 FOR HIT", ocean.hit(new Position(0, 9)), false);
        verify("CHECKING 0,8 FOR HIT", ocean.hit(new Position(0, 8)), false);
        verify("CHECKING 1,9 FOR HIT", ocean.hit(new Position(1, 9)), false);
        verify("CHECKING 1,8 FOR HIT", ocean.hit(new Position(1, 8)), false);
        verify("CHECKING 1,9 FOR HIT", ocean.hit(new Position(0, 9)), false);

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
        ocean.shootAt(new Position('H', 5));
        ocean.shootAt(new Position('C', 7));
        ocean.shootAt(new Position('E', 9));
        ocean.shootAt(new Position('B', 7));

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
    	System.out.println("HITTING B-8, B-8 and B-7 sunk");
    	//SOME BOATS SUNK
    	ocean.shootAt(new Position('B', 8));
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
    	
    	//ALL BUT ONE BOAT SUNK
    	ocean.shootAt(new Position('D', 9));
    	ocean.shootAt(new Position('E', 9));
    	ocean.shootAt(new Position('F', 9));
    	ocean.shootAt(new Position('G', 9));
    	ocean.shootAt(new Position('C', 6));
    	ocean.shootAt(new Position('C', 7));
    	ocean.shootAt(new Position('C', 8));
    	ocean.shootAt(new Position('C', 9));
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
    	ocean.shootAt(new Position('E', 5));
    	ocean.shootAt(new Position('F', 5));
    	ocean.shootAt(new Position('G', 5));
    	ocean.shootAt(new Position('H', 5));
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
    	

    public static void RunOceanTestScript() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        testInformationMethods();
        testPlaceBoat();
        testHitSunk();
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        RunOceanTestScript();
    }
}
