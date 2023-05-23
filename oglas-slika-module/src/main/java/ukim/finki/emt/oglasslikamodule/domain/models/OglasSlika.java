package ukim.finki.emt.oglasslikamodule.domain.models;

import lombok.Getter;
import lombok.NonNull;
import ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "slika")
@Getter
public class OglasSlika extends AbstractEntity<OglasSlikaId> {
    public String opis;
    public int golemina;
    public OglasSlika(@NonNull String opis, int golemina)
    {
        super(OglasSlikaId.randomId(OglasSlikaId.class));
        this.opis=opis;
        this.golemina=golemina;
    }

    public OglasSlika() {

    }
}
