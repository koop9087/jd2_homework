package service;

import dao.PersonDao;
import dao.PersonDaoImplements;
import pojos.Person;

import java.io.Serializable;

public class PersonServiceImplements implements PersonService {
    PersonDaoImplements personDaoImplements;

    @Override
    public Serializable savePerson(Person person) {
        return personDaoImplements.savePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDaoImplements.deletePerson(person);
    }

    @Override
    public Person loadPerson(int id) {
        return personDaoImplements.loadPerson(id);
    }

}
