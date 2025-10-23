package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeDTO extends DTO {

    private String nombre;

    public IdentificationTypeDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setNombre(TextHelper.getDefault());
    }

    public IdentificationTypeDTO(final UUID id) {
        super(id);
        setNombre(TextHelper.getDefault());
    }

    public IdentificationTypeDTO(final UUID id, final String name) {
        super(id);
        setNombre(this.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = TextHelper.getDefault(this.nombre);
    }

    public static IdentificationTypeDTO createDefault() {
        return new IdentificationTypeDTO();
    }
}
