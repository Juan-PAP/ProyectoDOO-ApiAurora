package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class CategoryEntity extends Entity {

    private String name;

    public CategoryEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public CategoryEntity(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public CategoryEntity(final UUID id, final String name) {
        super(id);
        setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static CategoryEntity createDefault() {
        return new CategoryEntity();
    }
}
