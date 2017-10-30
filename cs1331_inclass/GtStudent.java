import java.util.*;

public class GtStudent implements Comparable<GtStudent> {
    private final String name;
    private String major;
    private int age;

    public GtStudent(String name, String major, int age) {
        this.name = name;
        this.major = major;
        this.age =  age;
    }

    public String getMajor() {
        return this.major;
    }
    public int getAge() {
        return this.age;
    }
    public int compareTo(GtStudent other) {
        return this.name.compareTo(other.name);
    }
    public String toString() {
        return String.format("%s (%d) studying %s", this.name, this.age,
            this.major);
    }
    public static String helperPrint(List list) {
        String result = "";
        for (int i = 0; i < list. size(); i++) {
            result += String.format("\t%d. %s\n", i + 1, list.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        List<GtStudent> teamAvatar = new ArrayList<>();
        //better to use List interface as compile type beacuse that way yo can change list type later on
        teamAvatar.add(new GtStudent("Aang", "Airbending", 12));
        teamAvatar.add(new GtStudent("Katara", "Waterbending", 14));
        teamAvatar.add(new GtStudent("Sokka","Space Sword!!", 15));
        teamAvatar.add(new GtStudent("Toph", "Earthbending", 13));
        teamAvatar.add(new GtStudent("Zuko", "Firebending", 16));
        System.out.println("ORIGINAL ARRAYLIST");
        System.out.println(helperPrint(teamAvatar));
        System.out.println("NATURAL SORT (BY NAME)");
        Collections.sort(teamAvatar);
        System.out.println(helperPrint(teamAvatar));
        System.out.println("UNNATURAL SORT (BY MAJOR)");
        Collections.sort(teamAvatar, new SortMajor());
        System.out.println(helperPrint(teamAvatar));
        System.out.println("UNNATURAL SORT (BY AGE)");
        Comparator SortAge = Comparator.comparing(GtStudent::getAge);
        Collections.sort(teamAvatar, SortAge);
        System.out.println(helperPrint(teamAvatar));
    }
}