package ukim.finki.emt.oglasslikamodule.domain.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.emt.oglasslikamodule.domain.models.Oglas;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasId;

public interface OglasRepository extends JpaRepository<Oglas, OglasId> {

}
