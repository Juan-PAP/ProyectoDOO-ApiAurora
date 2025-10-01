package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class BrandDomain extends Domain{

    private String name;

    public BrandDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public BrandDomain (final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public BrandDomain (final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}
