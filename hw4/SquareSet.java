import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This class outlines a Collections Set object capable of holding Squares
 * @author dds7
 * @version 9.0.1
 */

public class SquareSet implements Set<Square>, Iterable<Square> {
    private Square[] backingArray = new Square[0];
    private int indexPointer = 0;

    /**
     * Constructs a no-arg SquareSet object
     */
    public SquareSet() {
        backingArray = new Square[10];
    }

    /**
     * Constructs a SquareSet object with predefined elements
     * @param c the Collection to be prefilled into this Set
     */
    public SquareSet(Collection<Square> c) throws NullPointerException {
        this();
        this.addAll(c);
    }
    /**
     * Adds a given Object to an existing set
     * @param o the given Object to add
     * @return the boolean value of if the given Object was sucessfully added
     */
    @Override
    public boolean add(Square s) throws NullPointerException {
        if (s == null) {
            throw new NullPointerException();
        }
        try {
            Square copy = new Square(s.getFile(), s.getRank());
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
            return true;
        } else {
            this.doubleSize();
            return this.add(s);
        }
    }

    /**
     * Adds multiple given Squares to an existing set
     * @param c the Collection of given Squares to add
     * @return the boolean value of whether the cllection was changed
     */
    @Override
    public boolean addAll(Collection<? extends Square> c)
        throws NullPointerException {
        boolean changed = false;
        SquareSet copyC = new SquareSet();
        for (Square o : c) {
            if (o == null) {
                throw new NullPointerException();
            } else {
                this.add(o);
                changed = changed ? true : this.add(o);
            }
        }
        // if (!copyC.isEmpty()) {
        //     for (Square s : copyC) {
        //         if (this.add(s)) {
        //             changed = this.add(s);;
        //         }
        //     }
        // }
        return changed;
    }

    /**
     * Removes all the elemments in this set
     */
    @Override
    public void clear() {
        backingArray = new Square[10];
        indexPointer = 0;
    }

    /**
     * Returns a boolean of if this Set contains a given element
     * @param o the given Square to search for
     * @return the boolean value of if the given Square is in Set
     */
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof Square)  {
            Square s = (Square) o;
            for (int i = 0; i < indexPointer; i++) {
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
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        Set<Square> copyC = new SquareSet();
        for (Object o : c) {
            if (!(o instanceof Square)) {
                return false;
            } else {
                copyC.add((Square) o);
            }
        }
        for (Square s : copyC)  {
            boolean found = false;
            for (int i = 0; i < indexPointer; i++) {
                if (backingArray[i].equals(s)) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a boolean of if this Set equals another
     * @param other the Set to be checked for equality
     * @return the boolean value of if the Sets are equal
     */
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
        if (that.size() == this.size() && that.containsAll(this)
            && this.containsAll(that)) {
            return true;
        }
        return false;
    }

    /**
     * Returns a the hasCode of this object
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        int hashNum = 31;
        for (int i = 0; i < indexPointer; i++) {
            hashNum += (17 * backingArray[i].hashCode());
        }
        return hashNum;
    }

    /**
     * Returns if the Set has no elements
     * @return the boolean of if two sets are equal
     */

    @Override
    public boolean isEmpty() {
        return indexPointer == 0;
    }

    /**
     * Returns an iterator over the elements in this set
     * @return an Iterator over the elements in this set
     */
    public Iterator<Square> iterator() {
        return new SquareIterator();
    }

    class SquareIterator implements Iterator<Square> {
        private int count = 0;
        @Override
        public boolean hasNext() {
            return (count < indexPointer);
        }
        @Override
        public Square next() throws NoSuchElementException {
            if (hasNext()) {
                count++;
                return backingArray[count - 1];
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    /**
     * Removes a inputed element
     * @param o the Square to be removed
     * @return the boolean value of if the Square was sucessfully removed
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }
        Square s = (Square) o;
        for (int i = 0; i < indexPointer; i++) {
            if (backingArray[i].equals(s)) {
                backingArray[i] = null;
                int j = i + 1;
                while (j < indexPointer && i < indexPointer) {
                    backingArray[i] = backingArray[j];
                    j++;
                    i++;
                }
                indexPointer--;
                if (indexPointer < 0) {
                    indexPointer = 0;
                }
                backingArray[indexPointer] = null;
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
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        Set<Square> copyC = new SquareSet();
        for (Object o : c) {
            if (!(o instanceof Square)) {
                return false;
            } else {
                copyC.add((Square) o);
            }
        }
        for (Square s : copyC) {
            if (this.remove(s)) {
                changed = true;
            }
        }
        return changed;
    }

    /**
     * After this operation the given set only contains the given Collection
     * @param c the collection of Squares to retain
     * @return the boolean value of if the Set was changed by this operation
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (Square s : backingArray) {
            if (!c.contains(s)) {
                this.remove(s);
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Returns the amount of elements in this Set
     * @return the number of elements int this Set
     */
    @Override
    public int size() {
        return this.indexPointer;
    }

    /**
     * Returns String representation of this Set
     * @return the String representation of this Set
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < indexPointer; i++) {
            result += (backingArray[i] + ", ");
        }
        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }
        String endResult = String.format("[%s]", result);
        return endResult;
    }

    /**
     * Returns an Array representation of this Set
     * @return the Array representation of this Set
     */
    @Override
    public Object[] toArray() {
        Object[] temp = new Object[indexPointer];
        for (int i = 0; i < indexPointer; i++) {
            temp[i] = backingArray[i];
        }
        return temp;
    }

    /**
     * Returns an Array representation of this Set with runtime type T
     * @param T the runtime type of the array to contain the collection
     * @param the array into which the elements of this set are to be stored,
     *          if it is big enough; otherwise, a new array of the same runtime
     *          type is allocated for this purpose
     * @return an array containing all the elements in this set
     */
    @Override
    public <T> T[] toArray(T[] a) throws ArrayStoreException {
        // if (!Square.class.isAssignableFrom(T)) {
        //     throw new ArrayStoreException();
        // }
        // int len;
        // if (a.length > indexPointer) {
        //     len = a.length;
        // } else {
        //     len = indexPointer;
        // }
        // T[] arr = new T[len];
        // for (int i = 0; i < indexPointer; i++) {
        //     arr[i] = backingArray[i];
        // }
        // return arr;
        return null;
    }

    /**
     * Doubles the size of the backing array of this set
     */
    private void doubleSize() {
        Square[] temp = (Square[]) new Object[2 * indexPointer];
        for (int i = 0; i < backingArray.length; i++) {
            temp[i] = backingArray[i];
        }
        backingArray = temp;
    }

}