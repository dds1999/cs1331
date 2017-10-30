import java.util.*;

public class CollectionPractice {
    public static void main(String[] args) {
        //set : no dublicates
        //list : list of items, duplicates ok
        //queue : first in, first out
        //deque : delete from front and back
        //map : key - value pair

        List<String> list = new ArrayList<String>();
        list.add("hello");
        String a =  list.get(0);
        list.remove("hello");
        System.out.println(list);
        System.out.println(a);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(64);
        list2.add(4);
        list2.add(16);
        list2.add(64);
        System.out.println(list2);
        list2.remove((Integer)64);
        System.out.println(list2);
        int b =list2.get(2);
        System.out.print(b);

        // IntSet<String> a = new IntSet<String>();
        // for (int i = 0; i < 30; i++) {
        //     a.add("h");
        // }
        // System.out.println(a);

        // static <T extemds Comparable<? super T>> void sort(List<E> list)
    }
}