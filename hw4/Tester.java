import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

public class Tester {
    public static void main(String[] args) throws InvalidSquareException {
        System.out.println("a2".hashCode());
        System.out.println("b1".hashCode());
        System.out.println(new Square("a2").hashCode());
        System.out.println(new Square("b1").hashCode());
        Square a = new Square("b1");
        // System.out.println(a.rank);
        // Set<Square> mine = new SquareSet();
        // SquareSet sset2 = new SquareSet();
        // sset2.add(new Square("a1"));
        // sset2.add(new Square("a2"));
        // sset2.add(new Square("a3"));
        // Square[] s = new Square[4];
        // System.out.println(mine);
        // mine.addAll(sset2);
        // System.out.println(mine);
        // Square[] end = mine.toArray(s);
        // if (end[0].equals(new Square("a1"))
        //         && (end[1].equals(new Square("a2")))
        //         && (end[2].equals(new Square("a3")))) {
        //     System.out.println("YAY!");
        // }
        // System.out.print(mine);
        // System.out.print("[");
        // for (Square a : end) {
        //     System.out.print(a + " ");
        // }
        // System.out.println("]");
        // toAdd.add(null);
        // Square s = new Square("a2");
        // Square[] t = {new Square("a3"), new Square("b4")};
        // Square[] s = mine.toArray(a);
        // System.out.print("[");
        // for (Square a : s) {
        //     System.out.print(a + " ");
        // }
        // System.out.println("]");
        // Set<Square> toAdd = new HashSet<Square>();
        // toAdd.add(s);
        // toAdd.add(new Square("b1"));
        // toAdd.add(new Square("c2"));
        // Set<Square> template = new HashSet<Square>(toAdd);
        // // System.out.println(template);
        // System.out.println(mine);
        // System.out.println(mine.size());
        // mine.addAll(toAdd);
        // System.out.println(mine);
        // mine.add(new Square("c3"));
        // System.out.println(mine.removeAll(toAdd));
        // Object[] arr = mine.toArray();
        // System.out.println(arr);
        // System.out.println(mine);
        // Set<Square> mine2 = new SquareSet(toAdd);
        // toAdd.add(new Square("b6"));
        // Set<Square> mine3 = new SquareSet(toAdd);
        // System.out.println(mine.equals(mine2)); // false
        // System.out.println(mine.equals(mine3)); // false
        // System.out.println(mine.hashCode());
        // System.out.println(mine2.hashCode());
        // System.out.println(mine3.hashCode());
        // System.out.println(mine.hashCode());
        // System.out.println(mine == mine2);


    }
}

// add works
// TA-app.cc.gatech.edu