package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeDomain extends Domain{

    private String nombre;

    public IdentificationTypeDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setNombre(TextHelper.getDefault());
    }

    public IdentificationTypeDomain (final UUID id) {
        super(id);
        setNombre(TextHelper.getDefault());
    }

    public IdentificationTypeDomain (final UUID id, final String name) {
        super(id);
        setNombre(name);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.getDefault(this.nombre);
    }

    public static IdentificationTypeDomain createDefault() {
        return new IdentificationTypeDomain();
    }
}

