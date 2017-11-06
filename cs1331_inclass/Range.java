// python for i in range(start inclusive, end exclusive, step size)
import java.util.Iterator; // a generic interface

public class Range implements Iterator<Integer>, Iterable<Integer> {
    private int start;
    private int end;
    private int step;

    public Range(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public Range(int start, int end) {
        this(start, end, 1);
    }

    public Range(int end) {
        this(0, end, 1);
    }

    @Override
    public boolean hasNext() {
        return (start < end);
    }
    @Override
    public Integer next() {
        int ret = start;
        start += 2;
        return ret;
    }

    public Iterator<Integer> iterator() {
        return this;
    }
    public static void main(String[] args) {
        Range evens = new Range(0, 10, 2) ;
        while (evens.hasNext()) {
            System.out.println(evens.next());
        }
        // // always call hasNext() before calling next to avoid OOB exceptions
        for (Integer i : new Range(0, 10, 2)) { //NEED ITERABLE no import needed
            System.out.println(i);
        }
    }
}