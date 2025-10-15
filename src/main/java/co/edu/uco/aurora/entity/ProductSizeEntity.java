package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductSizeEntity extends Entity {

    private String unitMeasurement;

    public ProductSizeEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUnitMeasurement(TextHelper.getDefault());
    }

    public ProductSizeEntity(UUID id) {
        super(id);
        setUnitMeasurement(TextHelper.getDefault());
    }

    public ProductSizeEntity(final UUID id, final String unitMeasurement) {
        super(id);
        setUnitMeasurement(this.unitMeasurement);
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(final String unitMeasurement) {
        this.unitMeasurement = TextHelper.getDefaultWithTrim(unitMeasurement);
    }

    public static ProductSizeEntity createDefault() {
        return new ProductSizeEntity();
    }
}
