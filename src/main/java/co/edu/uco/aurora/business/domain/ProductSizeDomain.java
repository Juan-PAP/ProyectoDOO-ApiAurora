package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductSizeDomain extends Domain{

    private String unitMeasurement;

    public ProductSizeDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUnitMeasurement(TextHelper.getDefault());
    }
    public ProductSizeDomain(UUID id) {
        super(id);
        setUnitMeasurement(TextHelper.getDefault());
    }

    public ProductSizeDomain(final UUID id, final String unitMeasurement) {
        super(id);
        setUnitMeasurement(unitMeasurement);
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(final String unitMeasurement) {
        this.unitMeasurement = TextHelper.getDefaultWithTrim(unitMeasurement);
    }

    public static ProductSizeDomain createDefault() {
        return new ProductSizeDomain();
    }
}