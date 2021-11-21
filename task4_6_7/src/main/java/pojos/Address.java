package pojos;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String city;
    private String region;
}
