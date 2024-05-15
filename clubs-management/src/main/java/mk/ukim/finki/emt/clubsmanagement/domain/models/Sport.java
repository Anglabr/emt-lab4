package mk.ukim.finki.emt.clubsmanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import org.springframework.lang.NonNull;

import java.util.Set;

@Entity
@Table(name = "sport")
@Getter
public class Sport extends AbstractEntity<SportId> {
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<SportCategory> categories;

    protected Sport() {
        super(SportId.randomId(SportId.class));
    }

    public Sport(@NonNull String name, String description, @NonNull Set<SportCategory> categories) {
        super(SportId.randomId(SportId.class));
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public static Sport build(String name, String description) {
        Sport sport = new Sport();
        sport.name = name;
        sport.description = description;
        return sport;
    }
}
