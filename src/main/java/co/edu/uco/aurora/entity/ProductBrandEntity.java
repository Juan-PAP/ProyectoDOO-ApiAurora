package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.BooleanHelper;
import co.edu.uco.aurora.crosscuting.helper.FloatHelper;
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
    private Float price;
    private Boolean ageRestriction;

    public ProductBrandEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductEntity.createDefault());
        setBrand(BrandEntity.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeEntity.createDefault());
        setUnitSales(UnitSalesEntity.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(BooleanHelper.getDefault());
    }

    public ProductBrandEntity(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductEntity.createDefault());
        setBrand(BrandEntity.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeEntity.createDefault());
        setUnitSales(UnitSalesEntity.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(BooleanHelper.getDefault());
    }

    public ProductBrandEntity(final UUID id, final String reference, final ProductEntity product, final BrandEntity brand,
                              final String measure, final ProductSizeEntity productSize, final UnitSalesEntity unitSales,
                              final Float price, final Boolean ageRestriction) {
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = ObjectHelper.getDefault(product, ProductEntity.createDefault());
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = ObjectHelper.getDefault(brand, BrandEntity.createDefault());
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = TextHelper.getDefaultWithTrim(measure);
    }

    public ProductSizeEntity getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSizeEntity productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, ProductSizeEntity.createDefault());
    }

    public UnitSalesEntity getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(UnitSalesEntity unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesEntity.createDefault());
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
    public static ProductBrandEntity createDefault() {
        return new ProductBrandEntity();
    }
}
