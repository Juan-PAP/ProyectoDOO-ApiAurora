package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class SaleDomain extends Domain {

    private String salesCode;
    private CustomerDomain customer;
    private LocalDate date;

    public SaleDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSalesCode(TextHelper.getDefault());
        setCustomer(CustomerDomain.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDomain (final UUID id) {
        super(id);
        setSalesCode(TextHelper.getDefault());
        setCustomer(CustomerDomain.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDomain (final UUID id, final String salesCode, final CustomerDomain customer, final LocalDate date) {
        super(id);
        setSalesCode(salesCode);
        setCustomer(customer);
        setDate(date);
    }

    public String getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(String salesCode) {
        this.salesCode = TextHelper.getDefault(salesCode);
    }

    public CustomerDomain getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDomain customer) {
        this.customer = ObjectHelper.getDefault(customer, CustomerDomain.getDefault());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDateHelper.getDefault(date);
    }

    public static SaleDomain getDefault() {
        return new SaleDomain();
    }
}
