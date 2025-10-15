package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class SaleDomain extends Domain {

    private String codeSale;
    private CustomerDomain customer;
    private LocalDate date;

    public SaleDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setCodeSale(TextHelper.getDefault());
        setCustomer(CustomerDomain.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDomain (final UUID id) {
        super(id);
        setCodeSale(TextHelper.getDefault());
        setCustomer(CustomerDomain.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDomain (final UUID id, final String salesCode, final CustomerDomain customer) {
        super(id);
        setCodeSale(salesCode);
        setCustomer(customer);
        setDate(LocalDateHelper.getDateToday());
    }

    public String getCodeSale() {
        return codeSale;
    }

    public void setCodeSale(final String codeSale) {
        this.codeSale = TextHelper.getDefault(codeSale);
    }

    public CustomerDomain getCustomer() {
        return customer;
    }

    public void setCustomer(final CustomerDomain customer) {
        this.customer = ObjectHelper.getDefault(customer, CustomerDomain.getDefault());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateHelper.getDateToday();
    }

    public void setDate(final LocalDate date) {
        this.date = LocalDateHelper.getDefault(date);
    }

    public static SaleDomain getDefault() {
        return new SaleDomain();
    }
}
