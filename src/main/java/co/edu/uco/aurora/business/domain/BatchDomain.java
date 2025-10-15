package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.IntegerHelper;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchDomain extends Domain {

    private ProductBrandDomain product;
    private boolean isPerishable;
    private LocalDate expirationDate;
    private int amount;

    public BatchDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProduct(ProductBrandDomain.createDefault());
        setPerishable(false);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchDomain (final UUID id) {
        super(id);
        setProduct(ProductBrandDomain.createDefault());
        setPerishable(false);
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchDomain (final UUID id,final ProductBrandDomain product ,final Boolean isPerishable, final LocalDate expirationDate, final int amount) {
        super(id);
        setProduct(product);
        setPerishable(isPerishable);
        setExpirationDate(expirationDate);
        setAmount(amount);
    }

    public ProductBrandDomain getProduct() {
        return product;
    }

    public void setProduct(ProductBrandDomain product) {
        this.product = ObjectHelper.getDefault(product, ProductBrandDomain.createDefault());
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
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
        this.amount = IntegerHelper.getDefault(amount);
    }
}
