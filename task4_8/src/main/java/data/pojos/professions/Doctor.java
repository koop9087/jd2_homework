package data.pojos.professions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Doctor extends Human {

    private String licenceNumber;

    private int expAge;

    public Doctor(String licenceNumber, int expAge) {
        this.licenceNumber = licenceNumber;
        this.expAge = expAge;
    }

    public Doctor() {
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public int getExpAge() {
        return expAge;
    }

    public void setExpAge(int expAge) {
        this.expAge = expAge;
    }
}
