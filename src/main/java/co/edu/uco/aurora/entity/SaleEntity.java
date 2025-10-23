package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class SaleEntity extends Entity{

    private String saleCode;
    private CustomerEntity customer;
    private LocalDate date;

    public SaleEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSaleCode(TextHelper.getDefault());
        setCustomer(CustomerEntity.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleEntity(final UUID id) {
        super(id);
        setSaleCode(TextHelper.getDefault());
        setCustomer(CustomerEntity.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleEntity(final UUID id, final String salesCode, final CustomerEntity customer, final LocalDate date) {
        super(id);
        setSaleCode(salesCode);
        setCustomer(customer);
        setDate(date);
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(final String saleCode) {
        this.saleCode = TextHelper.getDefault(saleCode);
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(final CustomerEntity customer) {
        this.customer = ObjectHelper.getDefault(customer, CustomerEntity.getDefault());
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

    public static SaleEntity getDefault() {
        return new SaleEntity();
    }
}
