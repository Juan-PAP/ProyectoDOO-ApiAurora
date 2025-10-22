package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.CategoryDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public final class CategoryEntityAssembler implements EntityAssembler<CategoryEntity, CategoryDomain> {

    private static final EntityAssembler<CategoryEntity,CategoryDomain> instance =
            new CategoryEntityAssembler();

    private CategoryEntityAssembler() {

    }
    public static EntityAssembler<CategoryEntity,CategoryDomain> getCategoryEntityAssembler() {
        return instance;
    }


    @Override
    public CategoryEntity toEntity(final CategoryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CategoryDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new CategoryEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CategoryDomain toDomain(final CategoryEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new CategoryEntity());
        return new CategoryDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<CategoryEntity> toEntity(final List<CategoryDomain> domainList) {
        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var categoryEntityList = new ArrayList<CategoryEntity>();

        for (var categoryDomain: domainList) {
            categoryEntityList.add(toEntity(categoryDomain));
        }

        return categoryEntityList;
    }
}
