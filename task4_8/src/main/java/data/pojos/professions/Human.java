package data.pojos.professions;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_HUMAN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "HUMAN_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("H")
public class Human {
    @Id
    @Column(name = "HUMAN_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    private int age;

    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Human() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
