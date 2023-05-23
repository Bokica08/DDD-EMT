package ukim.finki.emt.oglasslikamodule.valueObjects;

import lombok.NonNull;
import org.apache.catalina.User;
import ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {
    protected UserId(@NonNull String uuid) {
        super(uuid);
    }
    public UserId() {

    }
}
