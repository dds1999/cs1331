import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Zeta");
        list.add("Gamma");
        list.add("Alpha____");
        list.add("Delta____________________");
        list.add("Beta_______");
        System.out.println("ORGINIAL:           " + list);
        Collections.sort(list);
        System.out.println("Alpabetical:        " + list);

        // static class StringComparator implements Comparator<String> {
        //     public int compare(String a, String b) {
        //         return -1 * a.compareTo(b);
        //     }
        // }
        // Collections.sort(list, new StringComparator());
        // System.out.println("Reverse Alpabetical" + list);

        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        System.out.println("Inc length:         " + list);

        Collections.sort(list, (a, b) -> b.length() - a.length());
        System.out.println("Dec length:         " + list);

        Test3 t = new Test3();
        Collections.sort(list, t :: stringLen);
        System.out.println("Inc length:         " + list);

    }
    public int stringLen(String s1, String s2) {
        return s1.length() - s2.length();
    }

}