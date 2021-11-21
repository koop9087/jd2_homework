package data.dao;

import data.pojos.airport.Airplane;
import data.pojos.airport.Engine;
import data.pojos.airport.Wings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.SessionFactoryHolder;

import java.io.Serializable;

public class AirplaneDao {
    SessionFactory sessionFactory;

    public AirplaneDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AirplaneDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable saveWings(Wings wings) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(wings);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable saveEngine(Engine engine) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(engine);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable saveAirplane(Airplane airplane) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(airplane);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Airplane loadAirplane(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Airplane loadAirplane = session.load(Airplane.class, id);
            if (loadAirplane != null) {
                return loadAirplane;
            } else {
                throw new Error("NO HUMAN WITH THIS ID");
            }
        }
    }

    public Engine loadEngine(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Engine loadEngine = session.load(Engine.class, id);
            if (loadEngine != null) {
                return loadEngine;
            } else {
                throw new Error("NO DOCTOR WITH THIS ID");
            }
        }
    }

    public Wings loadWings(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Wings loadWings = session.load(Wings.class, id);
            if (loadWings != null) {
                return loadWings;
            } else {
                throw new Error("NO RACER WITH THIS ID");
            }
        }
    }
}
