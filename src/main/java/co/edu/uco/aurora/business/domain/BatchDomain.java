package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchDomain extends Domain {

    private ProductBrandDomain productBrand;
    private boolean isPerishable;
    private boolean confirmedPerishableDefaultValue;
    private LocalDate expirationDate;
    private int amount;
    private boolean confirmedAmountDefaultValue;

    public BatchDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setPerishable(false);
        setConfirmedPerishableDefaultValue(true);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
        setConfirmedAmountDefaultValue(true);

    }

    public BatchDomain (final UUID id) {
        super(id);
        setProductBrand(ProductBrandDomain.createDefault());
        setPerishable(false);
        setConfirmedPerishableDefaultValue(true);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
        setConfirmedAmountDefaultValue(true);

    }

    public BatchDomain (final UUID id,final ProductBrandDomain product ,final Boolean isPerishable, final LocalDate expirationDate, final int amount) {
        super(id);
        setProductBrand(product);
        setPerishable(isPerishable);
        setConfirmedPerishableDefaultValue(false);
        setExpirationDate(expirationDate);
        setAmount(amount);
        setConfirmedAmountDefaultValue(false);

    }

    public ProductBrandDomain getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrandDomain productBrand) {
        this.productBrand = ObjectHelper.getDefault(productBrand, ProductBrandDomain.createDefault());
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

    public static BatchDomain getDefault() {
        return new BatchDomain();
    }

}
