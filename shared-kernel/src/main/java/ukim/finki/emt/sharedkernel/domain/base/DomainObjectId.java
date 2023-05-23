package ukim.finki.emt.sharedkernel.domain.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {
    private String id;
    @JsonCreator
    protected DomainObjectId(@NonNull String uuid) {
        this.id = Objects.requireNonNull(uuid, "uuid must not be null");
    }
    protected DomainObjectId(){}
    /**
     * Creates a new, random instance of the given {@code idClass}.
     */
    @NonNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "idClass must not be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new instance of " + idClass, ex);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainObjectId that = (DomainObjectId) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
