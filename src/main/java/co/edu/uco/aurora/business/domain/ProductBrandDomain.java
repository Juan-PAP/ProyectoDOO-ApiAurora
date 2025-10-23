package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductBrandDomain extends Domain{

    private String reference;
    private ProductDomain product;
    private BrandDomain brand;
    private String measure;
    private UnitMeasurementDomain productSize;
    private UnitSalesDomain unitSales;
    private float price;
    private boolean confirmedPriceDefaultValue;
    private boolean ageRestriction;
    private boolean confirmedAgeRestrictionDefaultValue;

    public ProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(UnitMeasurementDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);
    }

    public ProductBrandDomain(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(UnitMeasurementDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);
    }

    public ProductBrandDomain(final UUID id, final String reference, final ProductDomain product, final BrandDomain brand,
                              final String measure, final UnitMeasurementDomain productSize, final UnitSalesDomain unitSales,
                              final Float price, final boolean ageRestriction) {
        super(id);
        setReference(reference);
        setProduct(product);
        setBrand(brand);
        setMeasure(measure);
        setProductSize(productSize);
        setUnitSales(unitSales);
        setPrice(price);
        setConfirmedPriceDefaultValue(false);
        setAgeRestriction(ageRestriction);
        setConfirmedAgeRestrictionDefaultValue(false);
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

    public UnitMeasurementDomain getProductSize() {
        return productSize;
    }

    public void setProductSize(final UnitMeasurementDomain productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, UnitMeasurementDomain.createDefault());
    }

    public UnitSalesDomain getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(final UnitSalesDomain unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesDomain.createDefault());
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
        setConfirmedPriceDefaultValue(false);
    }

    public boolean isConfirmedPriceDefaultValue() {
        return confirmedPriceDefaultValue;
    }

    public void setConfirmedPriceDefaultValue(final boolean confirmedPriceDefaultValue) {
        this.confirmedPriceDefaultValue = confirmedPriceDefaultValue;
    }

    public boolean isAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(final boolean ageRestriction) {
        this.ageRestriction = ageRestriction;
        setConfirmedAgeRestrictionDefaultValue(false);
    }

    public boolean isConfirmedAgeRestrictionDefaultValue() {
        return confirmedAgeRestrictionDefaultValue;
    }

    public void setConfirmedAgeRestrictionDefaultValue(final boolean confirmedAgeRestrictionDefaultValue) {
        this.confirmedAgeRestrictionDefaultValue = confirmedAgeRestrictionDefaultValue;
    }

    public static ProductBrandDomain createDefault() {
        return new ProductBrandDomain();
    }
}