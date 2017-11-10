import java.util.*;

public class InnerClassStuff {
    public static void main(String[] args) {
        HelloWorld h = new HelloWorld() {
            public void greet() {
                System.out.println("hello");
            }
        };
        h.greet();
    }
}
interface HelloWorld {
    public void greet();
}
    // Functional interfaces. Have only one method to implement
        // example is Comparator (only has compare) and Comparable (inly compareTo)
    // Lambda expressions are short cuts
    //     Student a = new Student() {
    //         // student class body
    //         private String name;
    //         private double grade;

    //         public String getName() {
    //             return name;
    //         }

    //         public double getGrade() {
    //             return grade;
    //         }
    //     }
        ArrayList<String> arr = new ArrayList<>();
        arr.add("James");
        arr.add("Megan");
        arr.add("Frederick");
        arr.add("Nancy");
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        // how can I use a anonymous inner class to sort
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        System.out.println(arr);
        // VERSUS
        Collections.sort(arr, CompareStrings);
        class CompareStrings implements Comparator<Strings> {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        }
        // VERSUS
        Collections.sort(add, (String a, String b)->{
            return a.length() - b.length();
        });