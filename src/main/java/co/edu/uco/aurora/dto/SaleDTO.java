package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class SaleDTO extends DTO {

    private String codeSale;
    private CustomerDTO customer;
    private LocalDate date;

    public SaleDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setCodeSale(TextHelper.getDefault());
        setCustomer(CustomerDTO.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDTO(final UUID id) {
        super(id);
        setCodeSale(TextHelper.getDefault());
        setCustomer(CustomerDTO.getDefault());
        setDate(LocalDateHelper.getDefault());
    }

    public SaleDTO(final UUID id, final String salesCode, final CustomerDTO customer,
                   final LocalDate date) {
        super(id);
        setCodeSale(salesCode);
        setCustomer(customer);
        setDate();
    }

    public String getCodeSale() {
        return codeSale;
    }

    public void setCodeSale(String codeSale) {
        this.codeSale = TextHelper.getDefault(codeSale);
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = ObjectHelper.getDefault(customer, CustomerDTO.getDefault());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateHelper.getDateToday();
    }

    public void setDate(LocalDate date) {
        this.date = LocalDateHelper.getDefault(date);
    }

    public static SaleDTO getDefault() {
        return new SaleDTO();
    }
}
