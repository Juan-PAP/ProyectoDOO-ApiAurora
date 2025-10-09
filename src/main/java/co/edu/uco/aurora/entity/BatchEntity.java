package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.BooleanHelper;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchEntity extends Entity {

    private ProductBrandEntity product;
    private Boolean isPerishable;
    private LocalDate expirationDate;
    private int amount;

    public BatchEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProduct(ProductBrandEntity.createDefault());
        setPerishable(BooleanHelper.getDefault());
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchEntity(final UUID id) {
        super(id);
        setProduct(ProductBrandEntity.createDefault());
        setPerishable(BooleanHelper.getDefault());
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchEntity(final UUID id, final ProductBrandEntity product , final Boolean isPerishable, final LocalDate expirationDate, final int amount) {
        super(id);
        setProduct(product);
        setPerishable(isPerishable);
        setExpirationDate(expirationDate);
        setAmount(amount);
    }

    public ProductBrandEntity getProduct() {
        return product;
    }

    public void setProduct(ProductBrandEntity product) {
        this.product = ObjectHelper.getDefault(product, ProductBrandEntity.createDefault());
    }

    public Boolean getPerishable() {
        return isPerishable;
    }

    public void setPerishable(Boolean perishable) {
        this.isPerishable = BooleanHelper.getDefault(perishable);
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
