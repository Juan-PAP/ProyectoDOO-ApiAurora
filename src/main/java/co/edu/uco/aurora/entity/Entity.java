package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public class Entity {
    private UUID id;

    protected Entity(final UUID id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
}
