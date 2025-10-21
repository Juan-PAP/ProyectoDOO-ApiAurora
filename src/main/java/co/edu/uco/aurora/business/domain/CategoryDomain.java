package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class CategoryDomain extends Domain{
    private String name;

    public CategoryDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public CategoryDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public CategoryDomain(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static CategoryDomain createDefault() {
        return new CategoryDomain();
    }
}