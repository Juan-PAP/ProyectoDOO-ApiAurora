package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.*;

import java.util.UUID;

public final class SaleProductBrandDomain extends Domain {

    private SaleDomain Sale;
    private ProductBrandDomain ProductBrand;
    private float UnitPrice;
    private boolean confirmedUnitPriceDefualtValue;
    private int amount;
    private boolean confirmedAmountDefualtValue;

    public SaleProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleDomain.getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setUnitPrice(0.0f);
        setConfirmedUnitPriceDefualtValue(true);
        setAmount(0);
        setConfirmedAmountDefualtValue(true);
    }
    public SaleProductBrandDomain(UUID id) {
        super(id);
        setSale(SaleDomain.getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setUnitPrice(0.0f);
        setConfirmedUnitPriceDefualtValue(true);
        setAmount(0);
        setConfirmedAmountDefualtValue(true);
    }

    public SaleProductBrandDomain (final UUID id, final SaleDomain Sale, final ProductBrandDomain ProductBrand,
                                   float UnitPrice, final int amount) {
        super(id);
        setSale(Sale);
        setProductBrand(ProductBrand);
        setUnitPrice(UnitPrice);
        setConfirmedUnitPriceDefualtValue(false);
        setAmount(amount);
        setConfirmedAmountDefualtValue(false);

    }

    public SaleDomain getSale() {
        return Sale;
    }

    public void setSale(final SaleDomain sale) {
        this.Sale = ObjectHelper.getDefault(sale, SaleDomain.getDefault());
    }

    public ProductBrandDomain getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(final ProductBrandDomain productBrand) {
        this.ProductBrand = ObjectHelper.getDefault(productBrand, ProductBrandDomain.createDefault()) ;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
        setConfirmedAmountDefualtValue(false);
    }

    public boolean isConfirmedAmountDefualtValue() {
        return confirmedAmountDefualtValue;
    }

    public void setConfirmedAmountDefualtValue(final boolean confirmedAmountDefualtValue) {
        this.confirmedAmountDefualtValue = confirmedAmountDefualtValue;
    }

    public static SaleProductBrandDomain createDefault() {
        return new SaleProductBrandDomain();
    }
}