package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class BrandEntity extends Entity {

    private String name;

    public BrandEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public BrandEntity(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public BrandEntity(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static BrandEntity createDefault() {
        return new BrandEntity();
    }
}
