package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductSizeDTO extends DTO {

    private String unitMeasurement;

    public ProductSizeDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUnitMeasurement(TextHelper.getDefault());
    }

    public ProductSizeDTO(UUID id) {
        super(id);
        setUnitMeasurement(TextHelper.getDefault());
    }

    public ProductSizeDTO(final UUID id, final String unitMeasurement) {
        super(id);
        setUnitMeasurement(unitMeasurement);
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(final String unitMeasurement) {
        this.unitMeasurement = TextHelper.getDefaultWithTrim(unitMeasurement);
    }

    public static ProductSizeDTO createDefault() {
        return new ProductSizeDTO();
    }

}
