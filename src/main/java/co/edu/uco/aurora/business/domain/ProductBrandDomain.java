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
    private UnitMeasurementDomain unitMeasurement;
    private UnitSalesDomain unitSales;
    private float price;
    private boolean confirmedPriceDefaultValue;
    private boolean hasAgeRestriction;
    private boolean confirmedAgeRestrictionDefaultValue;

    public ProductBrandDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setUnitMeasurement(UnitMeasurementDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setHasAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);
    }

    public ProductBrandDomain(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductDomain.createDefault());
        setBrand(BrandDomain.createDefault());
        setMeasure(TextHelper.getDefault());
        setUnitMeasurement(UnitMeasurementDomain.createDefault());
        setUnitSales(UnitSalesDomain.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setHasAgeRestriction(false);
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
        setUnitMeasurement(productSize);
        setUnitSales(unitSales);
        setPrice(price);
        setConfirmedPriceDefaultValue(false);
        setHasAgeRestriction(ageRestriction);
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

    public UnitMeasurementDomain getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(final UnitMeasurementDomain unitMeasurement) {
        this.unitMeasurement = ObjectHelper.getDefault(unitMeasurement, UnitMeasurementDomain.createDefault());
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

    public boolean isHasAgeRestriction() {
        return hasAgeRestriction;
    }

    public void setHasAgeRestriction(final boolean hasAgeRestriction) {
        this.hasAgeRestriction = hasAgeRestriction;
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