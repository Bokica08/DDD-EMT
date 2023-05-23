package ukim.finki.emt.oglasslikamodule.services;

import ukim.finki.emt.oglasslikamodule.domain.models.Oglas;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasId;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasSlika;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasSlikaId;
import ukim.finki.emt.oglasslikamodule.services.forms.OglasForm;
import ukim.finki.emt.oglasslikamodule.services.forms.OglasSlikaForm;

import java.util.List;
import java.util.Optional;

public interface OglasService {
    Optional<OglasId> makeOglas(OglasForm oglasForm);
    List<Oglas> findAll();
    Optional<Oglas> findById(OglasId id);
    void addItem(OglasId oglasId, OglasSlikaForm oglasForm);
    void deleteItem(OglasId oglasId, OglasSlikaId oglasSlikaId);
}
