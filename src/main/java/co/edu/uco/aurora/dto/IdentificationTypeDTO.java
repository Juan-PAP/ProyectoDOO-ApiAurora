package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeDTO extends DTO {

    private String name;

    public IdentificationTypeDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeDTO(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeDTO(final UUID id, final String name) {
        super(id);
        setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String nombre) {
        this.name = TextHelper.getDefault(name);
    }

    public static IdentificationTypeDTO createDefault() {
        return new IdentificationTypeDTO();
    }
}
