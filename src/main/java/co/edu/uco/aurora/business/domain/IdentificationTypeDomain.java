package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeDomain extends Domain{

    private String identificationType;

    public IdentificationTypeDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(TextHelper.getDefault());
    }

    public IdentificationTypeDomain (final UUID id) {
        super(id);
        setIdentificationType(TextHelper.getDefault());
    }

    public IdentificationTypeDomain (final UUID id, final String name) {
        super(id);
        setIdentificationType(name);
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final String nombre) {
        this.identificationType = TextHelper.getDefault(identificationType);
    }

    public static IdentificationTypeDomain createDefault() {
        return new IdentificationTypeDomain();
    }
}

