package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Person;
import util.SessionFactoryHolder;

import javax.persistence.FlushModeType;
import java.io.Serializable;

public class PersonDaoImplements implements PersonDao {
    public static final String NO_PERSON_WITH_THIS_ID_MESSAGE = "No person with this id";
    private final SessionFactory sessionFactory;

    public PersonDaoImplements(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonDaoImplements() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    @Override
    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        session.setFlushMode(FlushModeType.AUTO);
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

    @Override
    public Person loadPerson(int id) {
        try (Session session = sessionFactory.openSession()) {
            if (session.isDirty()) session.flush();
            session.setFlushMode(FlushModeType.AUTO);
            Person loadPerson = session.load(Person.class, id);
            if (loadPerson != null) {
                return loadPerson;
            } else {
                throw new Error(NO_PERSON_WITH_THIS_ID_MESSAGE);
            }
        }
    }

    public Person getPerson(int id) {
        try (Session session = sessionFactory.openSession()) {
            if (session.isDirty()) session.flush();
            session.setFlushMode(FlushModeType.AUTO);
            Person getMyPerson = session.get(Person.class, id);
            if (getMyPerson != null) {
                return getMyPerson;
            } else {
                return null;
            }
        }
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        session.setFlushMode(FlushModeType.AUTO);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deletePerson() {
        Person person = new Person(123, 12, "sdfs", "qw");
        Session session = sessionFactory.openSession();
        if (session.isDirty()) session.flush();
        session.setFlushMode(FlushModeType.AUTO);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
