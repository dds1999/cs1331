import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public String toString() {
        return String.format("%s (%d)", name, age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int compareTo(Person other) {
        // sort by age
        return this.age - other.age;
    }

    @Override public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        Person that;
        if (other instanceof Person) {
            that = (Person) other;
        } else {
            return false;
        }
        return ( this.name.equals(that.name) && (this.age == that.age) );
    }

    public static void main(String[] args) {
        List<Person> teamAvatar = new ArrayList<>();
        //better to use List interface as compile type beacuse that way yo can change list type later on
        teamAvatar.add(new Person("Aang", 12));
        teamAvatar.add(new Person("Katara", 14));
        teamAvatar.add(new Person("Sokka", 15));
        teamAvatar.add(new Person("Toph", 13));
        teamAvatar.add(new Person("Zuko", 16));
        System.out.println(teamAvatar);
        Collections.sort(teamAvatar);
        System.out.println(teamAvatar);
    }

}