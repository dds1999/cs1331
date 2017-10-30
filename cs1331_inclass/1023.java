import java.util.ArrayList;

public class InClass1023 {
    public static void main(String[] args) {
        ArrayList nums = {1, 2};
        // best to put in type otherwise have object list
        nums.add("hello");
        System.out.println(nums);
    }
}