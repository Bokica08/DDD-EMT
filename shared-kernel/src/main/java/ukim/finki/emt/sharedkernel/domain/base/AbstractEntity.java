package ukim.finki.emt.sharedkernel.domain.base;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Getter
public class AbstractEntity<ID extends DomainObjectId> {
    @EmbeddedId
    private ID id;

    protected AbstractEntity() {
    }

    /**
     * Copy constructor
     *
     * @param source the entity to copy from.
     */
    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        Objects.requireNonNull(source, "source must not be null");
        this.id = source.id;
    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), id);
    }



}
