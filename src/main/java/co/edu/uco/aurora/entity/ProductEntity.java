package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class ProductEntity extends Entity {

    private String name;
    private CategoryEntity category;

    public ProductEntity() {
        super (UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCategory(CategoryEntity.createDefault());
    }

    public ProductEntity(final UUID id) {
        super (id);
        setName(TextHelper.getDefault());
        setCategory(CategoryEntity.createDefault());
    }
    public ProductEntity (final UUID id, final String name, final CategoryEntity category) {
        super (id);
        setName(name);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = ObjectHelper.getDefault(category, CategoryEntity.createDefault());
    }
    public static ProductEntity createDefault() {
        return new ProductEntity();
    }
}
