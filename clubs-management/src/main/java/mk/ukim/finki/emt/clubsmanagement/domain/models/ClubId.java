package mk.ukim.finki.emt.clubsmanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class ClubId extends DomainObjectId {
    private ClubId() {
        super(ClubId.randomId(ClubId.class).getId());
    }

    public ClubId(@NonNull String uuid) {
        super(uuid);
    }

}
