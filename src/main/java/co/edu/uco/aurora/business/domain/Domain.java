package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

class Domain {

    private UUID id;

    protected Domain (final UUID id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
}
