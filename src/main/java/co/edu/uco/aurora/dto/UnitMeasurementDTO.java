package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitMeasurementDTO extends DTO {

    private String name;

    public UnitMeasurementDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public UnitMeasurementDTO(UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public UnitMeasurementDTO(final UUID id, final String unitMeasurement) {
        super(id);
        setName(unitMeasurement);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static UnitMeasurementDTO createDefault() {
        return new UnitMeasurementDTO();
    }

}
