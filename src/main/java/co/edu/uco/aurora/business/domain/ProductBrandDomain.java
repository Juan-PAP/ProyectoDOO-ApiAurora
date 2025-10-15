package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.FloatHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductBrandDomain extends Domain{

    private String reference;
    private ProductDomain product;
    private BrandDomain brand;
    private String measure;
    private ProductSizeDomain productSize;
    private UnitSalesDomain unitSales;
    private float price;
    private boolean ageRestriction;

    public ProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(false);
    }

    public ProductBrandDomain(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(false);
    }

    public ProductBrandDomain(final UUID id, final String reference, final ProductDomain product, final BrandDomain brand,
                              final String measure, final ProductSizeDomain productSize, final UnitSalesDomain unitSales,
                              final Float price, final boolean ageRestriction) {
        super(id);
        setReference(reference);
        setProduct(product);
        setBrand(brand);
        setMeasure(measure);
        setProductSize(productSize);
        setUnitSales(unitSales);
        setPrice(price);
        setAgeRestriction(ageRestriction);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(final String reference) {
        this.reference = TextHelper.getDefaultWithTrim(reference);
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(final ProductDomain product) {
        this.product = ObjectHelper.getDefault(product, ProductDomain.createDefault());
    }

    public BrandDomain getBrand() {
        return brand;
    }

    public void setBrand(final BrandDomain brand) {
        this.brand = ObjectHelper.getDefault(brand, BrandDomain.createDefault());
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(final String measure) {
        this.measure = TextHelper.getDefaultWithTrim(measure);
    }

    public ProductSizeDomain getProductSize() {
        return productSize;
    }

    public void setProductSize(final ProductSizeDomain productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, ProductSizeDomain.createDefault());
    }

    public UnitSalesDomain getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(final UnitSalesDomain unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesDomain.createDefault());
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(final Float price) {
        this.price = FloatHelper.getDefault(price);
    }

    public boolean isAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(final boolean ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public static ProductBrandDomain createDefault() {
        return new ProductBrandDomain();
    }
}