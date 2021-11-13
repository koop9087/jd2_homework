package service;

import pojos.Person;

import javax.persistence.PostPersist;

public class StateListenerService {
    @PostPersist
    public void proceed(Person person) {
        System.out.println("Insert operation completed" + person.getName() + person.getSurname()
        + person.getAge());
    }
}
