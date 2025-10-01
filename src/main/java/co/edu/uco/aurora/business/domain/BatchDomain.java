package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.BooleanHelper;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchDomain extends Domain {

    private Boolean isPerishable;
    private LocalDate expirationDate;
    private int amount;

    public BatchDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setPerishable(BooleanHelper.getDefault());
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchDomain (final UUID id) {
        super(id);
        setPerishable(BooleanHelper.getDefault());
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchDomain (final UUID id, final Boolean isPerishable, final int amount) {
        super(id);
        setPerishable(isPerishable);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(amount);
    }

    public BatchDomain (final UUID id, final Boolean isPerishable, final LocalDate expirationDate, final int amount) {
        super(id);
        setPerishable(isPerishable);
        setExpirationDate(expirationDate);
        setAmount(amount);
    }

    public Boolean getPerishable() {
        return isPerishable;
    }

    public void setPerishable(Boolean perishable) {
        isPerishable = BooleanHelper.getDefault(perishable);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = LocalDateHelper.getDefault(expirationDate);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
