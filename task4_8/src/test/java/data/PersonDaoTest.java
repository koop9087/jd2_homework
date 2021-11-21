package data;

import data.dao.PersonDao;
import data.pojos.company.Employee;
import data.pojos.company.Person;
import data.pojos.company.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PersonDaoTest {
    static SessionFactory sessionFactory;
    PersonDao personDao;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.task4_8.cfg.test.xml")
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDao(sessionFactory);
    }

    @After
    public void tearDown() {
        personDao = null;
    }

    //test table per subclass
    @Test
    public void saveEmployee() {
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setName("Ivan");
        employee.setCompany("EPAM");
        employee.setSalary(2901.00);
        Serializable id = personDao.saveEmployee(employee);
        assertNotEquals(200, id);
        Employee employee1 = personDao.loadEmployee(id);
        assertEquals("EPAM", employee1.getCompany());
    }

    @Test
    public void savePerson() {
        Person person = new Person();
        person.setAge(29);
        person.setName("Kuzya");
        Serializable id = personDao.savePerson(person);
        assertNotEquals(2900, id);
        Person person1 = personDao.loadPerson(id);
        assertEquals("Kuzya", person1.getName());
    }

    @Test
    public void saveStudent() {
        Student student = new Student();
        student.setAge(90);
        student.setName("Aiiaw");
        student.setFaculty("Art");
        student.setMark(9.0);
        Serializable id = personDao.saveStudent(student);
        assertNotEquals(27890, id);
        Student student1 = personDao.loadStudent(id);
        assertEquals("Art", student1.getFaculty());
    }

}