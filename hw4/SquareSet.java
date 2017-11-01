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

    }

    public SquareSet(? extends Collection<Square> c) {

    }
    // NEED
    /**
     * Adds a given Square to an existing set
     * @param e the given Square to add
     * @return the boolean value of if the given Square was sucessfully added
     */
    @Override
    public boolean add(Square e) {
        if (e == null) {
            throw new NullPointerExpection();
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

    @Override public String toString() {
        String result = "[";
        for (int i = 0; i < indexPointer; i++) {
            result += (backingArray[i] + ", ");
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }
}