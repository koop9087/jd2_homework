package pojos;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_COLOR")
public class Color {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "4"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column(name = "VISIBILITY")
    private String visibility;

    @Embedded
    private Address address;

    public Color() {
    }

    public Color(String visibility, Address address) {
        this.visibility = visibility;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (id != color.id) return false;
        return visibility != null ? visibility.equals(color.visibility) : color.visibility == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (visibility != null ? visibility.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Color{");
        sb.append("id=").append(id);
        sb.append(", visibility='").append(visibility).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
