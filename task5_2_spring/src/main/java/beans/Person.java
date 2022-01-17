package beans;

public class Person {
    public Person() {
        System.out.println("This is a Person no args constructor");
    }

    public void destroy() {
        System.out.println("Person destroy method");
    }

    public void init() {
        System.out.println("Person init method");
    }

}
