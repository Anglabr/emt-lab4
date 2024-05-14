package mk.ukim.finki.emt.clubsmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.clubsmanagement.domain.enums.City;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

@Embeddable
@Getter
public class Address implements ValueObject {
    private final String streetAddress;

    private final City city;

    private final int zipCode;

    protected Address() {
        this.streetAddress = "";
        this.city = City.SKOPJE;
        this.zipCode = 0;
    }

    public Address(@NonNull String streetAddress, @NonNull City city, @NonNull int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public static Address valueOf(@NonNull String streetAddress, @NonNull City city, @NonNull int zipCode) {
        return new Address(streetAddress, city, zipCode);
    }
}
