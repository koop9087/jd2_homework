package dao;

import pojos.Person;

import java.io.Serializable;

public interface PersonDao {
    Serializable savePerson(Person person);

    void deletePerson(Person person);

    Person loadPerson(int id);
}
