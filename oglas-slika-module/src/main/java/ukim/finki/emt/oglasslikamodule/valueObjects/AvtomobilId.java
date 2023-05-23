package ukim.finki.emt.oglasslikamodule.valueObjects;

import lombok.NonNull;
import ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class AvtomobilId extends DomainObjectId {
    protected AvtomobilId(@NonNull String uuid) {
        super(uuid);
    }

    public AvtomobilId() {

    }
}
