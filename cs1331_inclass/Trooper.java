import java.util.*;

public class Trooper {
    private String name;
    private boolean mustached;
    public Trooper(String name, boolean hasMustache) {
        this.name = name;
        this.mustached = hasMustache;
    }
    public String getName() {
        return name;
    }
    public boolean hasMustache() {
        return mustached;
    }
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null || !(other instanceof Trooper)) return false;
        Trooper that = (Trooper) other;
        return this.getName().equals(that.getName()) && this.hasMustache() == that.hasMustache();
    }
    // public int hashCode() {
    //     return super.hashCode();
    // }

    public static void main(String[] args) {
        Set<Trooper> troopers = new HashSet<>();
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Rabbit", false));
        Trooper  mac = new Trooper("Mac", true);
        troopers.add(mac);
        System.out.println(troopers.contains(mac));
        // prints "false"
    }
}
