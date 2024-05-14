package mk.ukim.finki.emt.clubsmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Address implements ValueObject {
    private final String streetAddress;

    private final String city;

    private final int zipCode;

    protected Address() {
        this.streetAddress = "";
        this.city = "";
        this.zipCode = 0;
    }

    protected Address(String streetAddress, String city, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }
}
