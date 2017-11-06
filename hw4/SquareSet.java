import java.util.Set;
/**
 * This class outlines a Collections Set object capable of holding Squares
 * @author dds7
 * @version 9.0.1
 */
public class SquareSet implements Set<Square> {
    private Square[] backingArray;
    private int indexPointer = 0;

    public SquareSet() {
        backingArray = new Square[10];
    }

    public SquareSet(Collection<Square> c) {
        this();
        this.addAll(c);
    }
    /**
     * Returns a boolean of if this Set contains a given element
     * @param e the given Square to search for
     * @return the boolean value of if the given Square is in Set
     */
    @Override
    public boolean contains(Square e) {
        if (e == null) {
            throw new NullPointerExpection();
        }
        for (int i = 0; i < backingArray.length(); i++) {
            if (backingArray[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a boolean of if this Set contains a several given elements
     * @param c the given collection of Squares to search for
     * @return the boolean value of if all Squares are contained
     */
    @Override
    public boolean containsAll(Collection<Square> c) {
        if (e == null) {
            throw new NullPointerExpection();
        }
        for (Square s : c)  {
            boolean found = false;
            for (int i = 0; i < backingArray.length(); i++) {
                if (backingArray[i].equals(e)) {
                    found = true;
                }
            }
            if (found == false) {
                return false;
            }
        }
        return true;
    }
    /**
     * Adds a given Square to an existing set
     * @param e the given Square to add
     * @return the boolean value of if the given Square was sucessfully added
     */
    @Override
    public boolean add(Square e) throws InvalidSquareException {
        if (e == null) {
            throw new NullPointerExpection();
        }
        if (this.contains(e)) {
            return false;
        }
        if (indexPointer < backingArray.length) {
            backingArray[indexPointer] = e;
            indexPointer++;
        } else {
            this.doubleSize();
            this.add(e);
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
    public boolean addAll(Square e) {
        if (indexPointer < backingArray.length) {
            backingArray[indexPointer] = e;
            indexPointer++;
        } else {
            this.doubleSize();
            this.add(e);
            return true;
        }
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
    @Override public boolean remove(<? extends Square> s) {
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i].equals(s)) {
                backingArray[i] = null;
                for (int j = i + 1; j < backingArray.length; j++) {
                    backingArray[i] = backingArray[j];
                }
                return true;
            }
        }
        return false;
    }
    // @Override public void removeAll(Collection<?> c) {
    //  for (int i = 0; i < c.size(); c++) {
    //      if (this.contains(c.get(0)) {
    //          this.remove
    //      }
    //  }
    // }

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

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < indexPointer; i++) {
            result += (backingArray[i] + ", ");
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof SquareSet)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        SquareSet that = (SquareSet) other;
        if (that.size() == this.size && that.containsAll(this)
            && this.containsAll(that)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (Square s : backingArray) {
            if (s != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean size() {
        return this.indexPointer;
    }

    @Override
    public Square[] toArray() {
        return this.backingArray;
    }
}