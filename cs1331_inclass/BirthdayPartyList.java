import java.util.*;

public class BirthdayPartyList extends ArrayList {
    public void univitePeople() {
        for (Person p : myList) {
            if (univite(p)) {
                myList.remove(p);
            }
        }
    }
    public static void main(String[] args) {
        BirthdayPartyList<Person> bdayList = new BirthdayPartyList<>();
        bdayList.add(new Person("Jean", 21));
        bdayList.add(new Person("Todd", 20));
        System.out.println(bdayList);
        bdayList.univitePeople(new Univiter());
        System.out.println(bdayList);
        bdayList.univitePeople((Person p)->p.getAge() < 21);
        System.out.println(bdayList);
    }
}


interface UninvitePerson<T> {
    public boolean univite(T t);
}


class Univiter implements UniviteInterface<Person> {
    public boolean univite(Person p) {
        return p.getAge() < 21;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
}

/*

 (parameter) -> { method body of functional interface abstract methos};
 */