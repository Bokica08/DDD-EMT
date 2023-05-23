package ukim.finki.emt.oglasslikamodule.services.impl;

import org.springframework.stereotype.Service;
import ukim.finki.emt.oglasslikamodule.domain.models.Oglas;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasId;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasSlikaId;
import ukim.finki.emt.oglasslikamodule.domain.models.repository.OglasRepository;
import ukim.finki.emt.oglasslikamodule.services.OglasService;
import ukim.finki.emt.oglasslikamodule.services.forms.OglasForm;
import ukim.finki.emt.oglasslikamodule.services.forms.OglasSlikaForm;
import ukim.finki.emt.sharedkernel.domain.base.financial.Money;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OglasServiceImpl implements OglasService {
    private final OglasRepository oglasRepository;
    private final Validator validator;

    public OglasServiceImpl(OglasRepository oglasRepository, Validator validator) {
        this.oglasRepository = oglasRepository;
        this.validator = validator;
    }

    @Override
    public Optional<OglasId> makeOglas(OglasForm oglasForm) {
        Objects.requireNonNull(oglasForm,"Oglas must not be null");
            var violations=validator.validate(oglasForm);
        if(violations.size()>1 && oglasForm.getItems()==null)
        {
            return null;
        }
        var newOglas=oglasRepository.saveAndFlush(toDomainObj(oglasForm));
        return Optional.ofNullable(newOglas.getId());
    }

    @Override
    public List<Oglas> findAll() {
        return oglasRepository.findAll();
    }

    @Override
    public Optional<Oglas> findById(OglasId id) {
        return oglasRepository.findById(id);
    }

    @Override
    public void addItem(OglasId oglasId, OglasSlikaForm oglasForm) {
        Oglas oglas=oglasRepository.findById(oglasId).orElseThrow();
        oglas.addOglasSlika(oglasForm.getOpis(),oglasForm.getGolemina());
        oglasRepository.saveAndFlush(oglas);

    }

    @Override
    public void deleteItem(OglasId oglasId, OglasSlikaId oglasSlikaId) {
        Oglas oglas=oglasRepository.findById(oglasId).orElseThrow();
        oglas.removeItem(oglasSlikaId);
        oglasRepository.saveAndFlush(oglas);
    }
    private Oglas toDomainObj(OglasForm oglasForm)
    {
        var money=new Money(oglasForm.getCena().getCurrency(), oglasForm.getCena().getAmount());
        var oglas=new Oglas(money,oglasForm.getNaslov(),oglasForm.getOpis(),oglasForm.getUserId(),oglasForm.getAvtomobilId());
        oglasForm.getItems().forEach(item->oglas.addOglasSlika(item.getOpis(),item.getGolemina()));
        return oglas;
    }
}
