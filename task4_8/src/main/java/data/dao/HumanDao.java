package data.dao;

import data.pojos.professions.Doctor;
import data.pojos.professions.Human;
import data.pojos.professions.Racer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.SessionFactoryHolder;

import java.io.Serializable;

public class HumanDao {
    SessionFactory sessionFactory;

    public HumanDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HumanDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable saveDoctor(Doctor doctor) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(doctor);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable saveRacer(Racer racer) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(racer);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable saveHuman(Human human) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(human);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Human loadHuman(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Human loadHuman = session.load(Human.class, id);
            if (loadHuman != null) {
                return loadHuman;
            } else {
                throw new Error("NO HUMAN WITH THIS ID");
            }
        }
    }

    public Doctor loadDoctor(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Doctor loadDoctor = session.load(Doctor.class, id);
            if (loadDoctor != null) {
                return loadDoctor;
            } else {
                throw new Error("NO DOCTOR WITH THIS ID");
            }
        }
    }

    public Racer loadRacer(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Racer loadRacer = session.load(Racer.class, id);
            if (loadRacer != null) {
                return loadRacer;
            } else {
                throw new Error("NO RACER WITH THIS ID");
            }
        }
    }
}
