package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitMeasurementDomain extends Domain{

    private String name;

    public UnitMeasurementDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }
    public UnitMeasurementDomain(UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public UnitMeasurementDomain(final UUID id, final String unitMeasurement) {
        super(id);
        setName(unitMeasurement);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static UnitMeasurementDomain createDefault() {
        return new UnitMeasurementDomain();
    }
}