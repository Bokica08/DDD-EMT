package ukim.finki.emt.oglasslikamodule.domain.models;

import lombok.NonNull;
import ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OglasId extends DomainObjectId {
    private OglasId() {
        super(OglasId.randomId(OglasId.class).getId());
    }

    public OglasId(@NonNull String uuid) {
        super(uuid);
    }
}
