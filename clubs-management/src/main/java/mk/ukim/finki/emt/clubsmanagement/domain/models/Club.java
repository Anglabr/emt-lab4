package mk.ukim.finki.emt.clubsmanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.clubsmanagement.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import org.springframework.lang.NonNull;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Sport> sports;

    protected Club() {
        super(ClubId.randomId(ClubId.class));
    }

    public Club(@NonNull String name,
                String description,
                @NonNull URI website,
                @NonNull String phoneNumber,
                @NonNull Address address,
                @NonNull Set<Sport> sports) {
        super(ClubId.randomId(ClubId.class));
        this.name = name;
        this.description = description;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sports = sports;
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

    public Set<SportCategory> getCategories() {
        Set<SportCategory> categories = new HashSet<>();
        for (Sport sport : this.sports) {
            categories.addAll(sport.getCategories());
        }

        return categories;
    }
}
