package pojos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_ANIMAL")
public class Animal {
    @Id
    @Column(name = "ANIMAL_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "AGE")
    private int age;

    @Embedded
    private Address address;

    public Animal() {
    }

    public Animal(int age, Address address) {
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
