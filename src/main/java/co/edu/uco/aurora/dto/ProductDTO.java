package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductDTO extends DTO {

    private String name;
    private CategoryDTO category;

    public ProductDTO() {
        super (UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCategory(CategoryDTO.createDefault());
    }

    public ProductDTO(final UUID id) {
        super (id);
        setName(TextHelper.getDefault());
        setCategory(CategoryDTO.createDefault());
    }

    public ProductDTO(final UUID id, final String name, final CategoryDTO category) {
        super (id);
        setName(name);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(final CategoryDTO category) {
        this.category = ObjectHelper.getDefault(category, CategoryDTO.createDefault());
    }
    public static ProductDTO createDefault() {
        return new ProductDTO();
    }
}
