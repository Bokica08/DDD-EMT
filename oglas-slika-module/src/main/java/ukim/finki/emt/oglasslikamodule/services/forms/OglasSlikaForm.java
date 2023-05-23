package ukim.finki.emt.oglasslikamodule.services.forms;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OglasSlikaForm {
    @NotNull
    private String opis;
    @Min(1)
    @NotNull int golemina;
}
