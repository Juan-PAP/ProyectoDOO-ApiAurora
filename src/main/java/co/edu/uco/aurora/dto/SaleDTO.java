package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class SaleDTO extends DTO {

    private String saleCode;
    private CustomerDTO customer;
    private LocalDate date;

    public SaleDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSaleCode(TextHelper.getDefault());
        setCustomer(CustomerDTO.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDTO(final UUID id) {
        super(id);
        setSaleCode(TextHelper.getDefault());
        setCustomer(CustomerDTO.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDTO(final UUID id, final String salesCode, final CustomerDTO customer, final LocalDate date) {
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(final CustomerDTO customer) {
        this.customer = ObjectHelper.getDefault(customer, CustomerDTO.getDefault());
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

    public static SaleDTO getDefault() {
        return new SaleDTO();
    }
}
