package data.pojos.company;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_STUDENT")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Student extends Person {
    private String faculty;
    private Double mark;

    public Student() {
    }

    public Student(String name, int age, String faculty, Double mark) {
        super(name, age);
        this.faculty = faculty;
        this.mark = mark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
