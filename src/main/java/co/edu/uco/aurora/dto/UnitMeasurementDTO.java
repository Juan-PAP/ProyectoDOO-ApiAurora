package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitMeasurementDTO extends DTO {

    private String nombre;

    public UnitMeasurementDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setNombre(TextHelper.getDefault());
    }

    public UnitMeasurementDTO(UUID id) {
        super(id);
        setNombre(TextHelper.getDefault());
    }

    public UnitMeasurementDTO(final UUID id, final String unitMeasurement) {
        super(id);
        setNombre(unitMeasurement);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.getDefaultWithTrim(nombre);
    }

    public static UnitMeasurementDTO createDefault() {
        return new UnitMeasurementDTO();
    }

}
