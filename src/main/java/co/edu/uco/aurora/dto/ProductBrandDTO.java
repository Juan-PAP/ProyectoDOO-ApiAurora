package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductBrandDTO extends DTO {

    private String reference;
    private ProductDTO product;
    private BrandDTO brand;
    private String measure;
    private UnitMeasurementDTO unitMeasurement;
    private UnitSalesDTO unitSales;
    private float price;
    private boolean confirmedPriceDefaultValue;
    private boolean hasAgeRestriction;
    private boolean confirmedAgeRestrictionDefaultValue;

    public ProductBrandDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDTO.createDefault());
        setBrand(BrandDTO.createDefault());
        setMeasure(TextHelper.getDefault());
        setUnitMeasurement(UnitMeasurementDTO.createDefault());
        setUnitSales(UnitSalesDTO.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setHasAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandDTO(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductDTO.createDefault());
        setBrand(BrandDTO.createDefault());
        setMeasure(TextHelper.getDefault());
        setUnitMeasurement(UnitMeasurementDTO.createDefault());
        setUnitSales(UnitSalesDTO.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setHasAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandDTO(final UUID id, final String reference, final ProductDTO product, final BrandDTO brand,
                           final String measure, final UnitMeasurementDTO productSize, final UnitSalesDTO unitSales,
                           final float price, final boolean ageRestriction) {
        super(id);
        setReference(reference);
        setProduct(product);
        setBrand(brand);
        setMeasure(measure);
        setUnitMeasurement(productSize);
        setUnitSales(unitSales);
        setPrice(price);
        setHasAgeRestriction(ageRestriction);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(final String reference) {
        this.reference = TextHelper.getDefaultWithTrim(reference);
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(final ProductDTO product) {
        this.product = ObjectHelper.getDefault(product, ProductDTO.createDefault());
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(final BrandDTO brand) {
        this.brand = ObjectHelper.getDefault(brand, BrandDTO.createDefault());
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(final String measure) {
        this.measure = TextHelper.getDefaultWithTrim(measure);
    }

    public UnitMeasurementDTO getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(final UnitMeasurementDTO unitMeasurement) {
        this.unitMeasurement = ObjectHelper.getDefault(unitMeasurement, UnitMeasurementDTO.createDefault());
    }

    public UnitSalesDTO getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(final UnitSalesDTO unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesDTO.createDefault());
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

    public static ProductBrandDTO createDefault() {
        return new ProductBrandDTO();
    }
}
