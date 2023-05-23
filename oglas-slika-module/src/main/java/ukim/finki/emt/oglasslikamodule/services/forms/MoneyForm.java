package ukim.finki.emt.oglasslikamodule.services.forms;

import lombok.Data;
import lombok.NonNull;
import ukim.finki.emt.sharedkernel.domain.base.financial.Currency;

import javax.validation.constraints.NotNull;

@Data
public class MoneyForm {
    @NotNull
    private Currency currency;
    @NotNull
    private double amount;
}
