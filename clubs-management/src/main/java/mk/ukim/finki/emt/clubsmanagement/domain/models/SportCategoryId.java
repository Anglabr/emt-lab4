package mk.ukim.finki.emt.clubsmanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class SportCategoryId extends DomainObjectId {
    private SportCategoryId() {
        super(SportCategoryId.randomId(SportCategoryId.class).getId());
    }

    public SportCategoryId(@NonNull String uuid) {
        super(uuid);
    }
}
