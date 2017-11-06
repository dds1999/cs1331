//<T extends Comparable<? super T>>
// the ? is saying that the compared object doesn't have to have super type T
// BUT it extends something that extends something that eventually extends T
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Recitation1031 {

    public static void main(String[] args) {
        // List<Student> arr = new ArrayList<Student>();
        // arr.add(new Student("Zuko", "Firebending", 16));
        // arr.add(new Student("Aang", "Airbending", 11));
        // arr.add(new Student("Katara", "Waterbending", 14));
        // arr.add(new Student("Sokka", "Boomerang", 15));
        // System.out.println(arr);
        // Collections.sort(arr);
        // System.out.println(arr);
        // Collections.sort(arr, new AgeComparator());
        // System.out.println(arr);
        GTStudent a = new GTStudent("Alba", 21);
        GTStudent b = new GTStudent("Bianca", 18);
        GTStudent c = new GTStudent("Carrie", 19);
        List<GTStudent> arr = new ArrayList<GTStudent>();
        arr.add(c);
        arr.add(b);
        arr.add(a);
        System.out.println("ORIGINAL:   "+ arr);
        Collections.sort(arr);
        System.out.println("NAME SORT:  " + arr);
        Collections.sort(arr, new AgeComparator());
        System.out.println("AGE SORT:   " + arr);
    }
}

class AgeComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.age - b.age;
    }
}

class Student implements Comparable<Student> {
    private final String name;
    private String major;
    public int age;

    public Student(String name, String major, int age) {
        this.name = name;
        this.major = major;
        this.age =  age;
    }

    public String toString() {
        return String.format(this.name + "(%s)", this.age);
    }
    public String getName() {
        return this.name;
    }
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

}

class GTStudent extends Student {

    public GTStudent(String name, int age) {
        super(name, "GEORGIA TECH", age);
    }

    public String toString() {
        return super.toString();
    }

}

class SuperSpecialStudentSet implements Iterable<E> {
    private int size;
    private E backingArray = (E[]) (new Object[5])

    public Iterator<E> iterator() {
        return new StudentIterator();
    }
// this class HAS TO BE AN INTERCLASS that how it can acces size
    private class StudentIterator implements Iterator<E> {
        private int ind;

        public boolean hasNext() {
            return ind < size;
        }

        public E next() {
            if (hasNext()) {
                return backingArray[ind++];
            } else {
                throw new NoSuchElementException("nothing left lol");
            }
        }
    }
}

