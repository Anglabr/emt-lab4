package mk.ukim.finki.emt.clubsmanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "sport")
@Getter
public class Sport extends AbstractEntity<SportId> {
    private String name;

    private String description;

    protected Sport() {
        super(SportId.randomId(SportId.class));
    }

    public static Sport build(String name, String description) {
        Sport sport = new Sport();
        sport.name = name;
        sport.description = description;
        return sport;
    }
}
