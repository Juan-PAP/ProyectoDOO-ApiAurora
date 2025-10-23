package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductBrandEntity extends Entity {

    private String reference;
    private ProductEntity product;
    private BrandEntity brand;
    private String measure;
    private UnitMeasurementEntity unitMeasurement;
    private UnitSalesEntity unitSales;
    private float price;
    private boolean confirmedPriceDefaultValue;
    private boolean hasAgeRestriction;
    private boolean confirmedAgeRestrictionDefaultValue;

    public ProductBrandEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductEntity.createDefault());
        setBrand(BrandEntity.createDefault());
        setMeasure(TextHelper.getDefault());
        setUnitMeasurement(UnitMeasurementEntity.createDefault());
        setUnitSales(UnitSalesEntity.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setHasAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandEntity(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductEntity.createDefault());
        setBrand(BrandEntity.createDefault());
        setMeasure(TextHelper.getDefault());
        setUnitMeasurement(UnitMeasurementEntity.createDefault());
        setUnitSales(UnitSalesEntity.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setHasAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandEntity(final UUID id, final String reference, final ProductEntity product, final BrandEntity brand,
                              final String measure, final UnitMeasurementEntity productSize, final UnitSalesEntity unitSales,
                              final float price, final boolean ageRestriction) {
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(final ProductEntity product) {
        this.product = ObjectHelper.getDefault(product, ProductEntity.createDefault());
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(final BrandEntity brand) {
        this.brand = ObjectHelper.getDefault(brand, BrandEntity.createDefault());
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(final String measure) {
        this.measure = TextHelper.getDefaultWithTrim(measure);
    }

    public UnitMeasurementEntity getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(final UnitMeasurementEntity unitMeasurement) {
        this.unitMeasurement = ObjectHelper.getDefault(unitMeasurement, UnitMeasurementEntity.createDefault());
    }

    public UnitSalesEntity getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(final UnitSalesEntity unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesEntity.createDefault());
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

    public static ProductBrandEntity createDefault() {
        return new ProductBrandEntity();
    }
}
