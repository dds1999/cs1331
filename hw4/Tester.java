import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

public class Tester {
    public static void main(String[] args) throws InvalidSquareException {
        Square s = new Square("a2");
        Set<Square> toAdd = new HashSet<Square>();
        toAdd.add(s);
        toAdd.add(new Square("b1"));
        toAdd.add(new Square("c2"));
        //toAdd.add(null);
        Set<Square> mine = new SquareSet();
        mine.addAll(toAdd);
        Square[] t = {new Square("a3"), new Square("b4")};
        Square[] s = mine.toArray(a);
        System.out.print("[");
        for (Square a : s) {
            System.out.print(a + " ");
        }
        System.out.println("]");





        // Set<Square> template = new HashSet<Square>(toAdd);
        // // System.out.println(template);
        // System.out.println(mine);
        // System.out.println(mine.size());
        mine.addAll(toAdd);
        // System.out.println(mine);
        // mine.add(new Square("c3"));
        // System.out.println(mine.removeAll(toAdd));
        // Object[] arr = mine.toArray();
        // System.out.println(arr);
        // System.out.print("[");
        // for (Object a : arr) {
        //     System.out.print(a + " ");
        // }
        // System.out.println("]");
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