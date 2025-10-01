package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.BooleanHelper;
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
    private Float price;
    private Boolean ageRestriction;

    public ProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(BooleanHelper.getDefault());
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
        setAgeRestriction(BooleanHelper.getDefault());
    }

    public ProductBrandDomain(final UUID id, final String reference, final ProductDomain product, final BrandDomain brand, final String measure, final ProductSizeDomain productSize, final UnitSalesDomain unitSales, final Float price, final Boolean ageRestriction) {
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

    public void setReference(String reference) {
        this.reference = TextHelper.getDefaultWithTrim(reference);
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = ObjectHelper.getDefault(product, ProductDomain.createDefault());
    }

    public BrandDomain getBrand() {
        return brand;
    }

    public void setBrand(BrandDomain brand) {
        this.brand = ObjectHelper.getDefault(brand, BrandDomain.createDefault());
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = TextHelper.getDefaultWithTrim(measure);
    }

    public ProductSizeDomain getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSizeDomain productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, ProductSizeDomain.createDefault());
    }

    public UnitSalesDomain getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(UnitSalesDomain unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesDomain.createDefault());
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = FloatHelper.getDefault(price);
    }

    public Boolean getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Boolean ageRestriction) {
        this.ageRestriction = BooleanHelper.getDefault(ageRestriction);
    }
    public static ProductBrandDomain createDefault() {
        return new ProductBrandDomain();
    }
}