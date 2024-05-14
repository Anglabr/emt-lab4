package mk.ukim.finki.emt.sharedkernel.domain.base;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import org.springframework.lang.NonNull;

import java.util.Objects;

@MappedSuperclass
public class AbstractEntity<ID extends DomainObjectId> {
    @EmbeddedId
    private ID id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        Objects.requireNonNull(source, "source must not be null");
        this.id = source.id;
    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }
}
