package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class SaleProductBrandEntity extends Entity {

    private SaleEntity Sale;
    private ProductBrandEntity ProductBrand;
    private float UnitPrice;
    private boolean confirmedUnitPriceDefualtValue;
    private float amount;
    private boolean confirmedAmountDefualtValue;

    public SaleProductBrandEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleEntity.getDefault());
        setProductBrand(ProductBrandEntity.createDefault());
        setUnitPrice(0.0f);
        setConfirmedUnitPriceDefualtValue(true);
        setAmount(0.0f);
        setConfirmedAmountDefualtValue(true);
    }

    public SaleProductBrandEntity(UUID id) {
        super(id);
        setSale(SaleEntity.getDefault());
        setProductBrand(ProductBrandEntity.createDefault());
        setUnitPrice(0.0f);
        setConfirmedUnitPriceDefualtValue(true);
        setAmount(0.0f);
        setConfirmedAmountDefualtValue(true);

    }

    public SaleProductBrandEntity (final UUID id, final SaleEntity sale, final ProductBrandEntity productBrand,
                                   float unitPrice,  final float amount) {
        super(id);
        setSale(sale);
        setProductBrand(productBrand);
        setUnitPrice(unitPrice);
        setConfirmedUnitPriceDefualtValue(false);
        setAmount(amount);
        setConfirmedAmountDefualtValue(false);
    }

    public float getUnitPrice() {
        return UnitPrice;
    }
    public void setUnitPrice(final float unitPrice) {
        this.UnitPrice = unitPrice;
        setConfirmedUnitPriceDefualtValue(false);
    }

    public boolean isConfirmedUnitPriceDefualtValue() {
        return confirmedUnitPriceDefualtValue;
    }

    public void setConfirmedUnitPriceDefualtValue(final boolean confirmedUnitPriceDefualtValue) {
        this.confirmedUnitPriceDefualtValue = confirmedUnitPriceDefualtValue;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(final float amount) {
        this.amount = amount;
        setConfirmedAmountDefualtValue(false);
    }

    public boolean isConfirmedAmountDefualtValue() {
        return confirmedAmountDefualtValue;
    }

    public void setConfirmedAmountDefualtValue(final boolean confirmedAmountDefualtValue) {
        this.confirmedAmountDefualtValue = confirmedAmountDefualtValue;
    }

    public ProductBrandEntity getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(final ProductBrandEntity productBrand) {
        this.ProductBrand = ObjectHelper.getDefault(productBrand, ProductBrandEntity.createDefault()) ;
    }

    public SaleEntity getSale() {
        return Sale;
    }

    public void setSale(final SaleEntity sale) {
        this.Sale = ObjectHelper.getDefault(sale, SaleEntity.getDefault());
    }

    public static SaleProductBrandEntity createDefault() {
        return new SaleProductBrandEntity();
    }
}
