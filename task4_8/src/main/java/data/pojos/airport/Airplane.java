package data.pojos.airport;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_AIRPLANE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Airplane {
    @Id
    @Column(name = "AIRPLANE_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    private String name;
    private int workAge;

    public Airplane() {
    }

    public Airplane(String name, int workAge) {
        this.name = name;
        this.workAge = workAge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
}
