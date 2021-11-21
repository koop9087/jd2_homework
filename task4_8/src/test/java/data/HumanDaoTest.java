package data;

import data.dao.HumanDao;
import data.pojos.professions.Doctor;
import data.pojos.professions.Human;
import data.pojos.professions.Racer;
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

public class HumanDaoTest {
    static SessionFactory sessionFactory;
    HumanDao humanDao;

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
        humanDao = new HumanDao(sessionFactory);
    }

    @After
    public void tearDown() {
        humanDao = null;
    }

    //test table per class hierarchy
    @Test
    public void saveDoctor() {
        Doctor doctor = new Doctor();
        doctor.setName("Igor");
        doctor.setAge(24);
        doctor.setExpAge(2);
        doctor.setLicenceNumber("728288BV");
        Serializable id = humanDao.saveDoctor(doctor);
        assertNotEquals(200, id);
        Doctor doctor1 = humanDao.loadDoctor(id);
        assertEquals("728288BV", doctor1.getLicenceNumber());
    }

    @Test
    public void saveRacer() {
        Racer racer = new Racer();
        racer.setName("Vitalii");
        racer.setAge(30);
        racer.setProfessionalStatus(true);
        racer.setMaxSpeed("290 m/s");
        Serializable id = humanDao.saveRacer(racer);
        assertNotEquals(220, id);
        Racer racer1 = humanDao.loadRacer(id);
        assertEquals("290 m/s", racer1.getMaxSpeed());
    }

    @Test
    public void saveHuman() {
        Human human = new Human();
        human.setAge(24);
        human.setName("Kiq");
        Serializable id = humanDao.saveHuman(human);
        assertNotEquals(240, id);
        Human human1 = humanDao.loadHuman(id);
        assertEquals("Kiq", human1.getName());
    }
}