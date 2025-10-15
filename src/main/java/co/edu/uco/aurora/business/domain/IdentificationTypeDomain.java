package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class IdentificationTypeDomain extends Domain{

    private String name;

    public IdentificationTypeDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeDomain (final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeDomain (final UUID id, final String name) {
        super(id);
        setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String nombre) {
        this.name = TextHelper.getDefault(name);
    }

    public static IdentificationTypeDomain createDefault() {
        return new IdentificationTypeDomain();
    }
}

