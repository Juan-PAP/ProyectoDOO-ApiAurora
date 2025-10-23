package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitMeasurementEntity extends Entity {

    private String nombre;

    public UnitMeasurementEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setNombre(TextHelper.getDefault());
    }

    public UnitMeasurementEntity(UUID id) {
        super(id);
        setNombre(TextHelper.getDefault());
    }

    public UnitMeasurementEntity(final UUID id, final String unitMeasurement) {
        super(id);
        setNombre(this.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.getDefaultWithTrim(nombre);
    }

    public static UnitMeasurementEntity createDefault() {
        return new UnitMeasurementEntity();
    }
}
