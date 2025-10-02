package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.*;

import java.util.UUID;

public class SaleProductBrandDomain extends Domain {
    private SaleDomain Sale;
    private ProductBrandDomain ProductBrand;
    private float UnitPrice;
    private Integer amount;

    public SaleProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleDomain.getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setAmount(IntegerHelper.getDefault());
    }
    public SaleProductBrandDomain(UUID id) {
        super(id);
        setSale(SaleDomain.getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setAmount(IntegerHelper.getDefault());
    }

    public SaleProductBrandDomain (final UUID id,final SaleDomain sale,final ProductBrandDomain productBrand, float unitPrice,  final Integer cantidad) {
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

    public ProductBrandDomain getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(ProductBrandDomain productBrand) {
        this.ProductBrand = ObjectHelper.getDefault(productBrand, ProductBrandDomain.createDefault()) ;
    }

    public SaleDomain getSale() {
        return Sale;
    }

    public void setSale(SaleDomain sale) {
        this.Sale = ObjectHelper.getDefault(sale, SaleDomain.getDefault());
    }

    public static SaleProductBrandDomain createDefault() {
        return new SaleProductBrandDomain();
    }
}