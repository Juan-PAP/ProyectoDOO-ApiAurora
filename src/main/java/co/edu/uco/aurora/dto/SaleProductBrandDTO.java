package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.FloatHelper;
import co.edu.uco.aurora.crosscuting.helper.IntegerHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class SaleProductBrandDTO extends DTO {

    private SaleDTO Sale;
    private ProductBrandDTO ProductBrand;
    private float unitPrice;
    private Integer amount;

    public SaleProductBrandDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleDTO.getDefault());
        setProductBrand(ProductBrandDTO.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setAmount(IntegerHelper.getDefault());
    }

    public SaleProductBrandDTO(UUID id) {
        super(id);
        setSale(SaleDTO.getDefault());
        setProductBrand(ProductBrandDTO.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setAmount(IntegerHelper.getDefault());
    }

    public SaleProductBrandDTO(final UUID id, final SaleDTO sale, final ProductBrandDTO productBrand,
                               float unitPrice, final Integer cantidad) {
        super(id);
        setSale(sale);
        setProductBrand(productBrand);
        setUnitPrice(unitPrice);
        setAmount(cantidad);
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = FloatHelper.getDefault(unitPrice);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = IntegerHelper.getDefault(amount);
    }

    public ProductBrandDTO getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(ProductBrandDTO productBrand) {
        this.ProductBrand = ObjectHelper.getDefault(productBrand, ProductBrandDTO.createDefault());
    }

    public SaleDTO getSale() {
        return Sale;
    }

    public void setSale(SaleDTO sale) {
        this.Sale = ObjectHelper.getDefault(sale, SaleDTO.getDefault());
    }

    public static ProductBrandDTO createDefault() {
        return new ProductBrandDTO();
    }
}
