package mk.ukim.finki.emt.clubsmanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.clubsmanagement.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.net.URI;

@Entity
@Table(name = "club")
@Getter
public class Club extends AbstractEntity<ClubId> {

    private String name;

    private String description;

    private URI website;

    private String phoneNumber;

    @AttributeOverrides({
            @AttributeOverride(name="streetAddress", column = @Column(name="address_street_address")),
            @AttributeOverride(name="city", column = @Column(name="address_city")),
            @AttributeOverride(name="zipCode", column = @Column(name = "address_zip_code"))
    })
    private Address address;

    protected Club() {
        super(ClubId.randomId(ClubId.class));
    }

    public static Club build(String name, String description, URI website, String phoneNumber, Address address) {
        Club club = new Club();
        club.name = name;
        club.description = description;
        club.website = website;
        club.phoneNumber = phoneNumber;
        club.address = address;
        return club;
    }
}
