package ukim.finki.emt.oglasslikamodule.domain.models;

import lombok.Getter;
import lombok.NonNull;
import ukim.finki.emt.oglasslikamodule.valueObjects.AvtomobilId;
import ukim.finki.emt.oglasslikamodule.valueObjects.UserId;
import ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import ukim.finki.emt.sharedkernel.domain.base.financial.Money;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "oglas")
@Getter
public class Oglas extends AbstractEntity<OglasId> {
        private Money cena;
        private String naslov;
        private String opis;
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
        private UserId userId;
        @AttributeOverride(name = "id", column = @Column(name = "avtomobil_id"))
        private AvtomobilId avtomobilId;
        @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
        private Set<OglasSlika> oglasSlikaList;
        public int total_pictures_size()
        {
                return oglasSlikaList.stream().mapToInt(oglasSlikaList->oglasSlikaList.golemina).sum();
        }
        public Oglas()
        {
                super(OglasId.randomId(OglasId.class));
        }

        public Oglas(Money cena, String naslov, String opis, UserId userId, AvtomobilId avtomobilId) {
                super(OglasId.randomId(OglasId.class));
                this.cena = cena;
                this.naslov = naslov;
                this.opis = opis;
                this.userId = userId;
                this.avtomobilId = avtomobilId;
        }

        public OglasSlika addOglasSlika(String opis, int golemina)
        {
                if(total_pictures_size()+golemina>=100)
                {
                        return null;
                }
                var item=new OglasSlika(opis,golemina);
                oglasSlikaList.add(item);
                return item;

        }
        public void removeItem(OglasSlikaId oglasSlikaId)
        {
                Objects.requireNonNull(oglasSlikaId,"Slika id must not be null");
                oglasSlikaList.removeIf(oglasSlika -> oglasSlika.getId().equals(oglasSlikaId));
        }



}
