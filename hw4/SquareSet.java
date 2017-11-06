import java.util.Collection;
import java.util.Iterator;
import java.lang.NullPointerException;
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
     * Adds a given Object to an existing set
     * @param o the given Object to add
     * @return the boolean value of if the given Object was sucessfully added
     */
    //@Override
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
     * @return the boolean value of whether the cllection was changed
     */
    //@Override
    public boolean addAll(Collection<? extends Square> arr) {
        boolean changed = false;
        for (Square s : c) {
            if (this.add(s)) {
                changed = true;;
            }
        }
        return changed;
    }

    /**
     * Removes all the elemments in this set
     */
    //@Override
    public void clear() {
        backingArray = new Square[10];
        indexPointer = 0;
    }

    /**
     * Returns a boolean of if this Set contains a given element
     * @param e the given Square to search for
     * @return the boolean value of if the given Square is in Set
     */
    //@Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerExpection();
        }
        Square s;
        if (o instanceof Square)  {
            s = (Square) o;
            for (int i = 0; i < backingArray.length; i++) {
                if (backingArray[i].equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns a boolean of if this Set contains a several given elements
     * @param c the given collection of Squares to search for
     * @return the boolean value of if all Squares are contained
     */
    //@Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        for (Square s : c)  {
            boolean found = false;
            for (int i = 0; i < backingArray.length; i++) {
                if (backingArray[i].equals(s)) {
                    found = true;
                }
            }
            if (found == false) {
                return false;
            }
        }
        return true;
    }

    //@Override
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
        if (that.size() == this.size() && that.containsAll(this)
            && this.containsAll(that)) {
            return true;
        }
        return false;
    }

    //???
    public int hashCode() {
        return 1;
    }

    /*
     * Returns if the Set is empty
     */
    //@Override
    public boolean isEmpty() {
        return indexPointer == 0;
    }

    // !! NEED HELP HERE

    public Iterator<Square> iterator() {
        return null;
        //return new Iterator<Square>();
    }

    /**
     * Removes a inputed element
     * @param s the Square to be removed
     * @return the boolean value of if the Sqaure was sucessfully removed
     */
    //@Override
    public boolean remove(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }
        Square s = (Square) o;
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i].equals(s)) {
                backingArray[i] = null;
                for (int j = i + 1; j < backingArray.length; j++) {
                    backingArray[i] = backingArray[j];
                }
                indexPointer--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a collection of items
     * @param c the collection of Squares to be removed
     * @return the boolean value of if the Set was changed by this operation
     */
    //@Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Square s : c) {
            if (this.remove(s)) {
                changed = true;
            }
        }
        return changed;
    }

    public boolean retainAll(Collection<?> c) {
        boolean changed;
        for (Square s : backingArray) {
            if (!c.contains(s)) {
                this.remove(s);
                changed = true;
            }
        }
        return changed;
    }

    //@Override
    public int size() {
        return this.indexPointer;
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
    public Object[] toArray() {
        return this.backingArray;
    }

    //@Override
    public <T> T[] toArray(T[] a) {
        // if (a.length > 1) {
        //     Class t = a[0].getClass();
        //     t.isAssignableFrom(B.class)
        // }
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

}