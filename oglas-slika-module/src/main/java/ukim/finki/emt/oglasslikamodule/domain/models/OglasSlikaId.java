package ukim.finki.emt.oglasslikamodule.domain.models;

import lombok.NonNull;
import ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OglasSlikaId extends DomainObjectId {
    private OglasSlikaId() {
        super(OglasSlikaId.randomId(OglasSlikaId.class).getId());
    }

    public OglasSlikaId(@NonNull String uuid) {
        super(uuid);
    }

}
