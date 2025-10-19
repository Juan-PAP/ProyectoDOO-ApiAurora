package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.FloatHelper;
import co.edu.uco.aurora.crosscuting.helper.IntegerHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class SaleProductBrandDTO extends DTO {

    private SaleDTO Sale;
    private ProductBrandDTO ProductBrand;
    private float unitPrice;
    private boolean confirmedUnitPriceDefualtValue;
    private int amount;
    private boolean confirmedAmountDefualtValue;


    public SaleProductBrandDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setSale(SaleDTO.getDefault());
        setProductBrand(ProductBrandDTO.createDefault());
        setUnitPrice(0.0f);
        setConfirmedUnitPriceDefualtValue(true);
        setAmount(0);
        setConfirmedAmountDefualtValue(true);

    }

    public SaleProductBrandDTO(UUID id) {
        super(id);
        setSale(SaleDTO.getDefault());
        setProductBrand(ProductBrandDTO.createDefault());
        setUnitPrice(0.0f);
        setConfirmedUnitPriceDefualtValue(true);
        setAmount(0);
        setConfirmedAmountDefualtValue(true);

    }

    public SaleProductBrandDTO(final UUID id, final SaleDTO sale, final ProductBrandDTO productBrand,
                               float unitPrice, final int cantidad) {
        super(id);
        setSale(sale);
        setProductBrand(productBrand);
        setUnitPrice(unitPrice);
        setAmount(cantidad);
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(final float unitPrice) {
        this.unitPrice = unitPrice;
        setConfirmedUnitPriceDefualtValue(false);
    }

    public boolean isConfirmedUnitPriceDefualtValue() {
        return confirmedUnitPriceDefualtValue;
    }

    public void setConfirmedUnitPriceDefualtValue(final boolean confirmedUnitPriceDefualtValue) {
        this.confirmedUnitPriceDefualtValue = confirmedUnitPriceDefualtValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
        setConfirmedAmountDefualtValue(false);
    }

    public boolean isConfirmedAmountDefualtValue() {
        return confirmedAmountDefualtValue;
    }

    public void setConfirmedAmountDefualtValue(final boolean confirmedAmountDefualtValue) {
        this.confirmedAmountDefualtValue = confirmedAmountDefualtValue;
    }

    public ProductBrandDTO getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(final ProductBrandDTO productBrand) {
        this.ProductBrand = ObjectHelper.getDefault(productBrand, ProductBrandDTO.createDefault());
    }

    public SaleDTO getSale() {
        return Sale;
    }

    public void setSale(final SaleDTO sale) {
        this.Sale = ObjectHelper.getDefault(sale, SaleDTO.getDefault());
    }

    public static ProductBrandDTO createDefault() {
        return new ProductBrandDTO();
    }
}
