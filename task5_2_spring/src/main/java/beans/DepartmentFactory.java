package beans;

public class DepartmentFactory {
    public static Department getDepartmentInstance() {
        return new Department();
    }

    public static Person getPersonInstance() {
        return new Person();
    }
}
