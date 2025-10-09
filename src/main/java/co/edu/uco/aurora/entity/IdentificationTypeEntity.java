package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public class IdentificationTypeEntity extends Entity {

    private String name;

    public IdentificationTypeEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeEntity(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public IdentificationTypeEntity(final UUID id, final String name) {
        super(id);
        setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = TextHelper.getDefault(name);
    }

    public static IdentificationTypeEntity createDefault() {
        return new IdentificationTypeEntity();
    }
}
