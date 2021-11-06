package main;

import dao.PersonDaoImplements;
import pojos.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(3534, 21235, "asdasd", "dfgs");
        Person person2 = new Person(7567, 21237, "asda", "asda");
        Person person3 = new Person(2342, 451, "afasf", "asdzx");
        Person person4 = new Person(5464, 343, "wrwer", "zxczxc");
        PersonDaoImplements personDaoImplements = new PersonDaoImplements();
        personDaoImplements.savePerson(person1);
        personDaoImplements.savePerson(person2);
        personDaoImplements.savePerson(person3);
        personDaoImplements.savePerson(person4);
        personDaoImplements.deletePerson(person1);
        personDaoImplements.deletePerson();

    }
}
