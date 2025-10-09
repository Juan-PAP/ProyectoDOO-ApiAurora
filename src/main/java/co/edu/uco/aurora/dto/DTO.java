package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public class DTO {

    private UUID id;

    protected DTO(final UUID id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
}
