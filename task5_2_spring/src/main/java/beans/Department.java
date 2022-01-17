package beans;

public class Department {
    public Department() {
        System.out.println("This is a department constructor");
    }

    public void specialInit() {
        System.out.println("Department special init method");
    }

    public void specialDestroy() {
        System.out.println("Department special destroy method");
    }

    public void init() {
        System.out.println("Department init method");
    }

    public void destroy() {
        System.out.println("Department destroy method");
    }
}
