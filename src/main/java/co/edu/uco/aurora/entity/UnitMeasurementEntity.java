package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitMeasurementEntity extends Entity {

    private String name;

    public UnitMeasurementEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public UnitMeasurementEntity(UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public UnitMeasurementEntity(final UUID id, final String unitMeasurement) {
        super(id);
        setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static UnitMeasurementEntity createDefault() {
        return new UnitMeasurementEntity();
    }
}
