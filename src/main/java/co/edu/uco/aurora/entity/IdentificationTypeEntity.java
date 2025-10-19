package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeEntity extends Entity {

    private String identificationType;

    public IdentificationTypeEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(TextHelper.getDefault());
    }

    public IdentificationTypeEntity(final UUID id) {
        super(id);
        setIdentificationType(TextHelper.getDefault());
    }

    public IdentificationTypeEntity(final UUID id, final String name) {
        super(id);
        setIdentificationType(this.identificationType);
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final String nombre) {
        this.identificationType = TextHelper.getDefault(identificationType);
    }

    public static IdentificationTypeEntity createDefault() {
        return new IdentificationTypeEntity();
    }
}
