package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchDTO extends DTO {

    private ProductBrandDTO productBrand;
    private boolean isPerishable;
    private boolean confirmedPerishableDefaultValue;
    private LocalDate expirationDate;
    private int amount;
    private boolean confirmedAmountDefaultValue;

    public BatchDTO () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProductBrand(ProductBrandDTO.createDefault());
        setPerishable(false);
        setConfirmedPerishableDefaultValue(true);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
        setConfirmedAmountDefaultValue(true);

    }

    public BatchDTO(final UUID id) {
        super(id);
        setProductBrand(ProductBrandDTO.createDefault());
        setPerishable(false);
        setConfirmedPerishableDefaultValue(true);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
        setConfirmedAmountDefaultValue(true);

    }

    public BatchDTO(final UUID id, final ProductBrandDTO product , final Boolean isPerishable, final LocalDate expirationDate, final int amount) {
        super(id);
        setProductBrand(product);
        setPerishable(isPerishable);
        setConfirmedPerishableDefaultValue(false);
        setExpirationDate(expirationDate);
        setAmount(amount);
        setConfirmedAmountDefaultValue(false);

    }

    public ProductBrandDTO getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrandDTO productBrand) {
        this.productBrand = ObjectHelper.getDefault(productBrand, ProductBrandDTO.createDefault());
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
        setConfirmedPerishableDefaultValue(false);
    }

    public boolean isConfirmedPerishableDefaultValue() {
        return confirmedPerishableDefaultValue;
    }

    public void setConfirmedPerishableDefaultValue(final boolean confirmedPerishableDefaultValue) {
        this.confirmedPerishableDefaultValue = confirmedPerishableDefaultValue;
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
        setConfirmedAmountDefaultValue(false);
    }

    public boolean isConfirmedAmountDefaultValue() {
        return confirmedAmountDefaultValue;
    }

    public void setConfirmedAmountDefaultValue(final boolean confirmedAmountDefaultValue) {
        this.confirmedAmountDefaultValue = confirmedAmountDefaultValue;
    }

    public static BatchDTO getDefault() {
        return new BatchDTO();
    }
}
