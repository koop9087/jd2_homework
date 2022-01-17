package by.academy.it.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @Column(name = "color_id")
    private Long id;

    private String tone;

    private String saturation;

    public Long getId() {
        return id;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getSaturation() {
        return saturation;
    }

    public void setSaturation(String saturation) {
        this.saturation = saturation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (id != null ? !id.equals(color.id) : color.id != null) return false;
        if (tone != null ? !tone.equals(color.tone) : color.tone != null) return false;
        return saturation != null ? saturation.equals(color.saturation) : color.saturation == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tone != null ? tone.hashCode() : 0);
        result = 31 * result + (saturation != null ? saturation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Color{");
        sb.append("id=").append(id);
        sb.append(", tone='").append(tone).append('\'');
        sb.append(", saturation='").append(saturation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
