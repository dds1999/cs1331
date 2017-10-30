import java.util.Comparator;

public class SortMajor implements Comparator<GtStudent> {
    public int compare(GtStudent s1, GtStudent s2) {
        return (s1.getMajor()).compareTo(s2.getMajor());
    }
}