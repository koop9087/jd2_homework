package data.dao;

import data.pojos.company.Employee;
import data.pojos.company.Person;
import data.pojos.company.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.SessionFactoryHolder;

import java.io.Serializable;

public class PersonDao {
    SessionFactory sessionFactory;

    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonDao() {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public Serializable saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(student);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Serializable saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(employee);
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

    public Person loadPerson(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Person loadPerson = session.load(Person.class, id);
            if (loadPerson != null) {
                return loadPerson;
            } else {
                throw new Error("NO PERSON WITH THIS ID");
            }
        }
    }

    public Student loadStudent(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Student loadStudent = session.load(Student.class, id);
            if (loadStudent != null) {
                return loadStudent;
            } else {
                throw new Error("NO STUDENT WITH THIS ID");
            }
        }
    }

    public Employee loadEmployee(Serializable id) {
        try (Session session = sessionFactory.openSession()) {
            Employee loadEmployee = session.load(Employee.class, id);
            if (loadEmployee != null) {
                return loadEmployee;
            } else {
                throw new Error("NO EMPLOYEE WITH THIS ID");
            }
        }
    }
}
