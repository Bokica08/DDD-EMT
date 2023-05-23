package ukim.finki.emt.oglasslikamodule.services.forms;

import lombok.Data;
import ukim.finki.emt.oglasslikamodule.valueObjects.AvtomobilId;
import ukim.finki.emt.oglasslikamodule.valueObjects.UserId;
import ukim.finki.emt.sharedkernel.domain.base.financial.Money;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class OglasForm {
    @NotNull
    private UserId userId;
    @Valid
    @NotEmpty
    private List<OglasSlikaForm> items=new ArrayList<>();
    @NotNull
    private AvtomobilId avtomobilId;
    @NotNull
    private String naslov;
    @NotNull
    private MoneyForm cena;
    @NotNull
    private String opis;
}
