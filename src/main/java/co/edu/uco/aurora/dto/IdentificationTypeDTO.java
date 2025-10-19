package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeDTO extends DTO {

    private String identificationType;

    public IdentificationTypeDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(TextHelper.getDefault());
    }

    public IdentificationTypeDTO(final UUID id) {
        super(id);
        setIdentificationType(TextHelper.getDefault());
    }

    public IdentificationTypeDTO(final UUID id, final String name) {
        super(id);
        setIdentificationType(this.identificationType);
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final String nombre) {
        this.identificationType = TextHelper.getDefault(identificationType);
    }

    public static IdentificationTypeDTO createDefault() {
        return new IdentificationTypeDTO();
    }
}
