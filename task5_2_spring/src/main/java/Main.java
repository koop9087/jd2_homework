import beans.Department;
import beans.Person;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String... args) {           //run main =)
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        context.getBean("department", Department.class);
        context.getBean("person", Person.class);
        context.close();
    }
}
