public class Tester {
    public static void main(String[] args) {
        try {
            new Square("a1");
        } catch (InvalidSquareException e) {
            System.out.println("InvalidSquareException for valid square: "
                + e.getMessage());
        }
        try {
            String invalidSquare = "a10";
            new Square(invalidSquare);
            System.out.println("No InvalidSquareException for invalid square: "
                + invalidSquare);
        } catch (InvalidSquareException e) {
            System.out.println("InvalidSquareException for invalid square: "
                + e.getMessage());
        }
        try {
            Square s = new Square("f7");
            assertEquals('f', s.getFile());
            assertEquals('7', s.getRank());
            Square s2 = new Square('e', '4');
            assertEquals("e4", s2.toString());
        } catch (Exception e) {
            System.out.println("THIS SHOULD NOT HAPPEN");
        }
    }
    public static void assertEquals(String s1, String s2) {
        System.out.println(s1.equals(s2));
    }
    public static void assertEquals(char c1, char c2) {
        System.out.println(c1 == c2);
    }
}