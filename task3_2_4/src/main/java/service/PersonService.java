package service;

import pojos.Person;

import java.io.Serializable;

public interface PersonService {
    Serializable savePerson(Person person);

    void deletePerson(Person person);

    Person loadPerson(int id);
}
