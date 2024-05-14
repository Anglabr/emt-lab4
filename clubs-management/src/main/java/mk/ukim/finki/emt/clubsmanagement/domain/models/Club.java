package mk.ukim.finki.emt.clubsmanagement.domain.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.net.URI;

@Entity
@Getter
public class Club extends AbstractEntity<ClubId> {

    private String name;

    private String description;

    private URI website;

    private String phoneNumber;

    private String address;

    protected Club() {
        super(ClubId.randomId(ClubId.class));
    }

    public static Club build() {
        Club club = new Club();
        return club;
    }
}
