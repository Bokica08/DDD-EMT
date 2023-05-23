package ukim.finki.emt.oglasslikamodule.xport.client.rest;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.emt.oglasslikamodule.domain.models.Oglas;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasId;
import ukim.finki.emt.oglasslikamodule.domain.models.OglasSlikaId;
import ukim.finki.emt.oglasslikamodule.services.OglasService;
import ukim.finki.emt.oglasslikamodule.services.forms.OglasForm;
import ukim.finki.emt.oglasslikamodule.services.forms.OglasSlikaForm;

import java.util.List;

@RestController
@RequestMapping("/api/oglas")
@AllArgsConstructor
public class OglasController {
    private final OglasService oglasService;
    @GetMapping
    public List<Oglas> findAll() {
        return oglasService.findAll();
    }
    @GetMapping("/findOglas/{id}")
    public ResponseEntity<Oglas> findById(@PathVariable OglasId id)
    {
        return oglasService.findById(id)
                .map(a->ResponseEntity.ok().body(a))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<OglasId> add(@RequestBody OglasForm oglasForm)
    {
        return oglasService.makeOglas(oglasForm)
                .map(a->ResponseEntity.ok().body(a))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/addSlika/{id}")
    public void addSlika(@PathVariable OglasId id,@RequestBody OglasSlikaForm oglasSlikaForm)
    {
          oglasService.addItem(id,oglasSlikaForm);
    }
    @DeleteMapping("/deleteSlika/{idOglas}/{idSlika}")
    public void deleteSlika(@PathVariable OglasId idOglas, @PathVariable OglasSlikaId idSlika)
    {
        oglasService.deleteItem(idOglas,idSlika);
    }


}
