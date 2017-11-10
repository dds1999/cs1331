public class Lambda {
    public static void main(String[] args) {
        Student s = new Student();
        // anonymous interclass
        s.greet(new Hello() {
            public void greeting() {
                System.out.println("Hiya!");
            }
        });
        // lambda expression
        s.greet(() -> {
                System.out.println("What's up?");
            });
    }
}

class Student {
    public void greet(Hello o) {
        o.greeting();
    }
}
// functional interface
interface Hello {
    void greeting();
}

// Anonymous Interclass
    // Type referenceName = new Type() {
    //     [class body]
    //     this is the only method it has
    // }