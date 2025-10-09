package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class UnitSalesEntity extends Entity{

    private String name;

    public UnitSalesEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public UnitSalesEntity(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public UnitSalesEntity (final UUID id, final String name) {
        super (id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static UnitSalesEntity createDefault() {
        return new UnitSalesEntity();
    }
}
