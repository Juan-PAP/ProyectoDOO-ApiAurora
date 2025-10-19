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
    private ProductSizeEntity productSize;
    private UnitSalesEntity unitSales;
    private float price;
    private boolean confirmedPriceDefaultValue;
    private boolean ageRestriction;
    private boolean confirmedAgeRestrictionDefaultValue;

    public ProductBrandEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductEntity.createDefault());
        setBrand(BrandEntity.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeEntity.createDefault());
        setUnitSales(UnitSalesEntity.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandEntity(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductEntity.createDefault());
        setBrand(BrandEntity.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeEntity.createDefault());
        setUnitSales(UnitSalesEntity.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandEntity(final UUID id, final String reference, final ProductEntity product, final BrandEntity brand,
                           final String measure, final ProductSizeEntity productSize, final UnitSalesEntity unitSales,
                           final float price, final boolean ageRestriction) {
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

    public ProductSizeEntity getProductSize() {
        return productSize;
    }

    public void setProductSize(final ProductSizeEntity productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, ProductSizeEntity.createDefault());
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

    public static ProductBrandEntity createDefault() {
        return new ProductBrandEntity();
    }
}
