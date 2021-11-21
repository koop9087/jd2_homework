package data;

import data.dao.AirplaneDao;
import data.pojos.airport.Airplane;
import data.pojos.airport.Engine;
import data.pojos.airport.Wings;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class AirplaneDaoTest {
    static SessionFactory sessionFactory;
    AirplaneDao airplaneDao;

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
        airplaneDao = new AirplaneDao(sessionFactory);
    }

    @After
    public void tearDown() {
        airplaneDao = null;
    }

    //test table per class
    @Test
    public void saveAirplane() {
        Airplane airplane = new Airplane();
        airplane.setName("Boeng 182");
        airplane.setWorkAge(12);
        Serializable id = airplaneDao.saveAirplane(airplane);
        assertNotEquals(200, id);
        Airplane airplane1 = airplaneDao.loadAirplane(id);
        assertEquals("Boeng 182", airplane1.getName());
    }

    @Test
    public void saveWings() {
        Wings wings = new Wings();
        wings.setName("Poqwe");
        wings.setWorkAge(8);
        wings.setColor("white");
        wings.setPrice(9012.0);
        Serializable id = airplaneDao.saveWings(wings);
        assertNotEquals(220, id);
        Wings wings1 = airplaneDao.loadWings(id);
        assertEquals("white", wings1.getColor());
    }

    @Test
    public void saveEngine() {
        Engine engine = new Engine();
        engine.setName("jsedjksdf");
        engine.setWorkAge(8812);
        engine.setMark("hiudfjhfdg");
        engine.setWorked(false);
        Serializable id = airplaneDao.saveEngine(engine);
        assertNotEquals(240, id);
        Engine engine1 = airplaneDao.loadEngine(id);
        assertFalse(engine1.getWorked());
    }
}