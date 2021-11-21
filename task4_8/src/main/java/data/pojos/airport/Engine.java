package data.pojos.airport;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_ENGINE")
public class Engine extends Airplane {
    private String mark;
    private boolean isWorked;

    public Engine(String name, int workAge, String mark, boolean isWorked) {
        super(name, workAge);
        this.mark = mark;
        this.isWorked = isWorked;
    }

    public Engine() {
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean getWorked() {
        return isWorked;
    }

    public void setWorked(boolean worked) {
        isWorked = worked;
    }
}
