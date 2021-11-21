package pojos;

import javax.persistence.*;

@Entity
@Table(name = "T_PERSON")
public class Person {
    @Id
    @Column(name = "T_PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "HUNGRY")
    private boolean hungry;

    @Embedded
    private Address address;

    public Person() {
    }

    public Person(boolean hungry, Address address) {
        this.hungry = hungry;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return hungry == person.hungry;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hungry ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", hungry=").append(hungry);
        sb.append('}');
        return sb.toString();
    }
}
