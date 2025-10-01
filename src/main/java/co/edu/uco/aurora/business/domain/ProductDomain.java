package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public class ProductDomain extends Domain {
    private String name;
    private CategoryDomain category;

    public ProductDomain () {
        super (UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCategory(CategoryDomain.createDefault());
    }
    public ProductDomain (final UUID id) {
        super (id);
        setName(TextHelper.getDefault());
        setCategory(CategoryDomain.createDefault());
    }
    public ProductDomain (final UUID id, final String name, final CategoryDomain category) {
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

    public CategoryDomain getCategory() {
        return category;
    }

    public void setCategory(CategoryDomain category) {
        this.category = ObjectHelper.getDefault(category, CategoryDomain.createDefault());
    }
    public static ProductDomain createDefault() {
        return new ProductDomain();
    }
}