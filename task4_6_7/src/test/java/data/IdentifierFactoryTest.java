package data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.Address;
import pojos.Animal;
import pojos.Color;
import pojos.Person;

import java.io.Serializable;

public class IdentifierFactoryTest {

    static SessionFactory sessionFactory;
    IdentifierFactory identifierFactory;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.task4.cfg.test.xml")
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        identifierFactory = new IdentifierFactory(sessionFactory);
    }

    @After
    public void tearDown() {
        identifierFactory = null;
    }

    @Test
    public void save() {
        //given
        Animal animal = new Animal(200, new Address("35", "45", "90"));
        Person person = new Person(true, new Address("3534534", "3435345", "rets rteertt"));
        Color color = new Color("none", new Address("90234", "235346", "sfsdf"));
        //when
        Serializable id = identifierFactory.saveAnimal(animal);
        Serializable id1 = identifierFactory.savePerson(person);
        Serializable id2 = identifierFactory.saveColor(color);
        //then
        System.out.println(id);
        System.out.println(id1);
        System.out.println(id2);
    }
}