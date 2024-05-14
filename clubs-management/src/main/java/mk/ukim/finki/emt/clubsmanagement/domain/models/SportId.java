package mk.ukim.finki.emt.clubsmanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class SportId extends DomainObjectId {
    private SportId() {
        super(SportId.randomId(SportId.class).getId());
    }

    public SportId(@NonNull String uuid) {
        super(uuid);
    }
}
