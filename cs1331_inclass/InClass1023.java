import java.util.*;

public class InClass1023 {
    public static void main(String[] args) {
/*        ArrayList<Integer> nums = new ArrayList<>();
        // best to put in type otherwise have object list
        for (int count = 0; count <= 10; count++) {
            nums.add(count);
        }
        System.out.println(nums);
        for (int num : nums) {
            System.out.println(num);
        }*/
        Set ints = new HashSet();
        ints.add(1);
        ints.add(1);
        ints.add(2);
        System.out.println(ints);

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("a", 4);
        System.out.println(map);
        Set<String> mapSet = map.keySet();
        for (String s : mapSet) {
            System.out.println(s + " = " + map.get(s));
        }
    }
}

/*
Node<E> {
    E data
    Node next
    // 1 --> 2 --> 3 --> 4 --> 5 --> null
}
*/