package data.pojos.airport;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_WINGS")
public class Wings extends Airplane {
    private Double price;
    private String color;

    public Wings(String name, int workAge, Double price, String color) {
        super(name, workAge);
        this.price = price;
        this.color = color;
    }

    public Wings() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
