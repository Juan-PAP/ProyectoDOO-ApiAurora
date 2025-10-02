package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.*;

import java.util.UUID;

public class SaleProductBrandDomain extends Domain {
    private SaleDomain Sale;
    private ProductBrandDomain ProductBrand;
    private float UnitPrice;
    private Integer cantidad;

    public SaleProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleDomain.getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setCantidad(IntegerHelper.getDefault());
    }
    public SaleProductBrandDomain(UUID id) {
        super(id);
        setSale(SaleDomain.getDefault());
        setProductBrand(ProductBrandDomain.createDefault());
        setUnitPrice(FloatHelper.getDefault());
        setCantidad(IntegerHelper.getDefault());
    }

    public SaleProductBrandDomain (final UUID id,final SaleDomain sale,final ProductBrandDomain productBrand, float unitPrice,  final Integer cantidad) {
        super(id);
        setSale(Sale);
        setProductBrand(ProductBrand);
        setUnitPrice(UnitPrice);
        setCantidad(cantidad);
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.UnitPrice = FloatHelper.getDefault(unitPrice);
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = IntegerHelper.getDefault(cantidad);
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