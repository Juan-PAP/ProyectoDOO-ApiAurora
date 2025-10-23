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
    private UnitMeasurementDTO productSize;
    private UnitSalesDTO unitSales;
    private float price;
    private boolean confirmedPriceDefaultValue;
    private boolean ageRestriction;
    private boolean confirmedAgeRestrictionDefaultValue;

    public ProductBrandDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDTO.createDefault());
        setBrand(BrandDTO.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(UnitMeasurementDTO.createDefault());
        setUnitSales(UnitSalesDTO.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setAgeRestriction(false);
        setConfirmedAgeRestrictionDefaultValue(true);

    }

    public ProductBrandDTO(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductDTO.createDefault());
        setBrand(BrandDTO.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(UnitMeasurementDTO.createDefault());
        setUnitSales(UnitSalesDTO.createDefault());
        setPrice(0.0f);
        setConfirmedPriceDefaultValue(true);
        setAgeRestriction(false);
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

    public UnitMeasurementDTO getProductSize() {
        return productSize;
    }

    public void setProductSize(final UnitMeasurementDTO productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, UnitMeasurementDTO.createDefault());
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

    public static ProductBrandDTO createDefault() {
        return new ProductBrandDTO();
    }
}
