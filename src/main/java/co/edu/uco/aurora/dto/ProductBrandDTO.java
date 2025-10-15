package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.FloatHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductBrandDTO extends DTO {

    private String reference;
    private ProductDTO product;
    private BrandDTO brand;
    private String measure;
    private ProductSizeDTO productSize;
    private UnitSalesDTO unitSales;
    private float price;
    private boolean ageRestriction;

    public ProductBrandDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setReference(TextHelper.getDefault());
        setProduct(ProductDTO.createDefault());
        setBrand(BrandDTO.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeDTO.createDefault());
        setUnitSales(UnitSalesDTO.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(false);
    }

    public ProductBrandDTO(final UUID id) {
        super(id);
        setReference(TextHelper.getDefault());
        setProduct(ProductDTO.createDefault());
        setBrand(BrandDTO.createDefault());
        setMeasure(TextHelper.getDefault());
        setProductSize(ProductSizeDTO.createDefault());
        setUnitSales(UnitSalesDTO.createDefault());
        setPrice(FloatHelper.getDefault());
        setAgeRestriction(false);
    }

    public ProductBrandDTO(final UUID id, final String reference, final ProductDTO product, final BrandDTO brand,
                              final String measure, final ProductSizeDTO productSize, final UnitSalesDTO unitSales,
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

    public ProductSizeDTO getProductSize() {
        return productSize;
    }

    public void setProductSize(final ProductSizeDTO productSize) {
        this.productSize = ObjectHelper.getDefault(productSize, ProductSizeDTO.createDefault());
    }

    public UnitSalesDTO getUnitSales() {
        return unitSales;
    }

    public void setUnitSales(final UnitSalesDTO unitSales) {
        this.unitSales = ObjectHelper.getDefault(unitSales, UnitSalesDTO.createDefault());
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

    public static ProductBrandDTO createDefault() {
        return new ProductBrandDTO();
    }
}
