package data.pojos.professions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Racer extends Human {

    private String maxSpeed;

    private boolean professionalStatus;

    public Racer(String maxSpeed, boolean professionalStatus) {
        this.maxSpeed = maxSpeed;
        this.professionalStatus = professionalStatus;
    }

    public Racer() {
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean getProfessionalStatus() {
        return professionalStatus;
    }

    public void setProfessionalStatus(boolean professionalStatus) {
        this.professionalStatus = professionalStatus;
    }
}
