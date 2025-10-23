package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitMeasurementDomain extends Domain{

    private String nombre;

    public UnitMeasurementDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setNombre(TextHelper.getDefault());
    }
    public UnitMeasurementDomain(UUID id) {
        super(id);
        setNombre(TextHelper.getDefault());
    }

    public UnitMeasurementDomain(final UUID id, final String unitMeasurement) {
        super(id);
        setNombre(unitMeasurement);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.getDefaultWithTrim(nombre);
    }

    public static UnitMeasurementDomain createDefault() {
        return new UnitMeasurementDomain();
    }
}