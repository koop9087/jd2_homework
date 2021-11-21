package data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Animal;
import pojos.Color;
import pojos.Person;
import util.SessionFactoryHolder;

import java.io.Serializable;

public class IdentifierFactory {
    SessionFactory sessionFactory;

    public IdentifierFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public IdentifierFactory() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable saveAnimal(Animal animal) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(animal);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable saveColor(Color color) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(color);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }
}
