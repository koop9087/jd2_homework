package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.*;
import pojos.Person;

import java.io.Serializable;

public class PersonDaoTest {
    static SessionFactory sessionFactory;
    PersonDaoImplements personDaoImplements;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.task3.cfg.test.xml")
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        personDaoImplements = new PersonDaoImplements(sessionFactory);
    }

    @After
    public void tearDown() {
        personDaoImplements = null;
    }

    @Test
    public void savePerson() {
        //given
        Person person = new Person();
        person.setId(100);
        person.setAge(12);
        person.setName("Jakov");
        person.setSurname("Kial");
        //when
        Serializable id = personDaoImplements.savePerson(person);
        //then
        Assert.assertEquals(100, id);
    }

    @Test
    public void deletePerson() {
        Person person = new Person(200, 123, "Naq", "kqiol");
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(person);
            Person deletePerson = session.get(Person.class, person.getId());
            session.delete(deletePerson);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        }
        Assert.assertNull(session.get(Person.class, person.getId()));
    }

    @Test
    public void loadPerson() {
        Session session = sessionFactory.openSession();
        Person person = new Person(121, 12, "Even", "Noteven");
        Person personFind = new Person();
        try {
            session.save(person);
            personFind = session.load(Person.class, person.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(person, personFind);
    }

    @Test
    public void getPerson() {
        Session session = sessionFactory.openSession();
        Person person = new Person(87956, 1212, "Evsdfen", "qweqwe");
        Person personFind = new Person();
        try {
            session.save(person);
            personFind = session.get(Person.class, person.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(person, personFind);
    }

    @Test()
    public void getPersonWithNull() {
        Session session = sessionFactory.openSession();
        Person person = new Person(765, 1, "z", "x");
        Person personFind = new Person();
        try {
            session.save(person);
            personFind = session.get(Person.class, 2);
        } catch (Exception e) {         //when use null id we have a expected:<Person{id=765, age=1, name='z', surname='x'}> but was:<null>
            e.printStackTrace();
        }
        Assert.assertNotEquals(person, personFind);     //Assert.assertNotEquals to see difference between two tests
    }

    @Test
    public void loadPersonWithNull() {
        Session session = sessionFactory.openSession();
        Person person = new Person(121, 12, "Even", "Noteven");
        Person personFind = new Person();
        try {
            session.save(person);
            personFind = session.load(Person.class, 1);
        } catch (Exception e) {         //when use null id we have a "No row with the given identifier exists:" exception
            e.printStackTrace();
        }
        Assert.assertNotEquals(person, personFind);     //Assert.assertNotEquals to see difference between two tests
    }

}
