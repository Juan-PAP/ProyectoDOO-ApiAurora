package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchEntity extends Entity {

    private ProductBrandEntity productBrand;
    private boolean isPerishable;
    private boolean confirmedPerishableDefaultValue;
    private LocalDate expirationDate;
    private int amount;
    private boolean confirmedAmountDefaultValue;

    public BatchEntity () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProductBrand(ProductBrandEntity.createDefault());
        setPerishable(false);
        setConfirmedPerishableDefaultValue(true);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
        setConfirmedAmountDefaultValue(true);

    }

    public BatchEntity(final UUID id) {
        super(id);
        setProductBrand(ProductBrandEntity.createDefault());
        setPerishable(false);
        setConfirmedPerishableDefaultValue(true);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
        setConfirmedAmountDefaultValue(true);

    }

    public BatchEntity(final UUID id, final ProductBrandEntity product , final Boolean isPerishable, final LocalDate expirationDate, final int amount) {
        super(id);
        setProductBrand(product);
        setPerishable(isPerishable);
        setConfirmedPerishableDefaultValue(false);
        setExpirationDate(expirationDate);
        setAmount(amount);
        setConfirmedAmountDefaultValue(false);

    }

    public ProductBrandEntity getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrandEntity productBrand) {
        this.productBrand = ObjectHelper.getDefault(productBrand, ProductBrandEntity.createDefault());
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

    public static BatchEntity getDefault() {
        return new BatchEntity();
    }
}
