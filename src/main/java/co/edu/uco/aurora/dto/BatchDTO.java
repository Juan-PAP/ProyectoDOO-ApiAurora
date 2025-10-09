package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.BooleanHelper;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class BatchDTO extends DTO {

    private ProductBrandDTO product;
    private Boolean isPerishable;
    private LocalDate expirationDate;
    private int amount;

    public BatchDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProduct(ProductBrandDTO.createDefault());
        setPerishable(BooleanHelper.getDefault());
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchDTO(final UUID id) {
        super(id);
        setProduct(ProductBrandDTO.createDefault());
        setPerishable(BooleanHelper.getDefault());
        setExpirationDate(LocalDateHelper.getDefault());
        setAmount(0);
    }

    public BatchDTO(final UUID id, final ProductBrandDTO product , final Boolean isPerishable,
                    final LocalDate expirationDate, final int amount) {
        super(id);
        setProduct(product);
        setPerishable(isPerishable);
        setExpirationDate(expirationDate);
        setAmount(amount);
    }

    public ProductBrandDTO getProduct() {
        return product;
    }

    public void setProduct(ProductBrandDTO product) {
        this.product = ObjectHelper.getDefault(product, ProductBrandDTO.createDefault());
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
