package data.pojos.company;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_EMPLOYEE")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Employee extends Person {
    private String company;
    private Double salary;

    public Employee(String name, int age, String company, Double salary) {
        super(name, age);
        this.company = company;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
