package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class BrandDTO extends DTO{

    private String name;

    public BrandDTO () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public BrandDTO (final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public BrandDTO (final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static BrandDTO createDefault() {
        return new BrandDTO();
    }
}
