package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.FloatHelper;
import co.edu.uco.aurora.crosscuting.helper.IntegerHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class SaleProductBrandEntity extends Entity {

    private SaleEntity Sale;
    private ProductBrandEntity ProductBrand;
    private float UnitPrice;
    private Integer amount;

    public SaleProductBrandEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleEntity.getDefault());
        setProductBrand(ProductBrandEntity.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setAmount(IntegerHelper.getDefault());
    }
    public SaleProductBrandEntity(UUID id) {
        super(id);
        setSale(SaleEntity.getDefault());
        setProductBrand(ProductBrandEntity.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setAmount(IntegerHelper.getDefault());
    }

    public SaleProductBrandEntity (final UUID id,final SaleEntity sale,final ProductBrandEntity productBrand,
                                   float unitPrice,  final Integer cantidad) {
        super(id);
        setSale(Sale);
        setProductBrand(ProductBrand);
        setUnitPrice(UnitPrice);
        setAmount(cantidad);
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.UnitPrice = FloatHelper.getDefault(unitPrice);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = IntegerHelper.getDefault(amount);
    }

    public ProductBrandEntity getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(ProductBrandEntity productBrand) {
        this.ProductBrand = ObjectHelper.getDefault(productBrand, ProductBrandEntity.createDefault()) ;
    }

    public SaleEntity getSale() {
        return Sale;
    }

    public void setSale(SaleEntity sale) {
        this.Sale = ObjectHelper.getDefault(sale, SaleEntity.getDefault());
    }

    public static SaleProductBrandEntity createDefault() {
        return new SaleProductBrandEntity();
    }
}
