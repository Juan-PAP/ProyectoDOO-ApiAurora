package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class CategoryDTO extends DTO {

    private String name;

    public CategoryDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
    }

    public CategoryDTO(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
    }

    public CategoryDTO(final UUID id, final String name) {
        super(id);
        setName(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public static CategoryDTO createDefault() {
        return new CategoryDTO();
    }
}
