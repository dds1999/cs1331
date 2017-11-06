import java.util.Set;
import java.util.Collection;
/**
 * This class outlines a Collections Set object capable of holding Squares
 * @author dds7
 * @version 9.0.1
 */
public class TryNewThing implements Set<Square> {
    private Square[] backingArray;
    private int indexPointer = 0;

    public TryNewThing() {
        backingArray = new Square[10];
    }

    public TryNewThing(Collection<Square> c) {
        this();
        this.addAll(c);
    }
    /**
     * Returns a boolean of if this Set contains a given element
     * @param e the given Square to search for
     * @return the boolean value of if the given Square is in Set
     */
    @Override
    public boolean contains(Object o) {
        return false;
    }
    /**
     * Returns a boolean of if this Set contains a several given elements
     * @param c the given collection of Squares to search for
     * @return the boolean value of if all Squares are contained
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return true;
    }
    /**
     * Adds a given Square to an existing set
     * @param e the given Square to add
     * @return the boolean value of if the given Square was sucessfully added
     */
    @Override
    public boolean add(Object o) {
        if (o == null) {
            throw new NullPointerExpection();
        }
        if (!(o instanceof Square)) {
            return false;
        }
        Square s;
        try {
           s = (Square) o;
        } catch (InvalidSquareException e) {
            System.out.println("InvalidSquareException for invalid square: "
                + e.getMessage());
       }

        if (this.contains(s)) {
            return false;
        }
        if (indexPointer < backingArray.length) {
            backingArray[indexPointer] = s;
            indexPointer++;
        } else {
            this.doubleSize();
            this.add(s);
            return true;
        }
        return false;
    }
    /**
     * Adds multiple given Squares to an existing set
     * @param arr the array of given Squares to add
     * @return the boolean value of if the all the given Sqaures
     *         were sucessfully added
     */
    @Override
    public boolean addAll(Collection<? extends Square> arr) {
        return false;
    }
    /**
     * Removes all the elemments in this set
     */
    @Override
    public void clear() {
        backingArray = new Square[10];
    }
    /**
     * Removes a inputed element
     * @param s the Square to be removed
     * @return the boolean value of if the Sqaure was sucessfully removed
     */
    //@Override
    public boolean remove(Object o) {
        return false;
    }
    /**
     * Returns boolean value of if the Set has been changed
     * @param c the Collection of objects to be removed
     * @return if the Set has been changed
     */
    //@Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Doubles the size of the backing array of this set
     */
    private void doubleSize() {
        Square[] temp = (Square[]) new Object[2 * backingArray.length];
        for (int i = 0; i < backingArray.length; i++) {
            temp[i] = backingArray[i];
        }
        backingArray = temp;
    }

    //@Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < indexPointer; i++) {
            result += (backingArray[i] + ", ");
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }

    //@Override
    public boolean equals(Object other) {
        return false;
    }

    //@Override
    public boolean isEmpty() {
        return false;
    }

    //@Override
    public int size() {
        return this.indexPointer;
    }

    //@Override
    public Square[] toArray() {
        return this.backingArray;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }
}