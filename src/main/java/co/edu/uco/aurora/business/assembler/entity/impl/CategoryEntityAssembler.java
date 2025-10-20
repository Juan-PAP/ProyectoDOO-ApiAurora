package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.CategoryDomain;
import co.edu.uco.aurora.entity.CategoryEntity;

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
    public CategoryEntity toEntity(CategoryDomain domain) {
        return null;
    }

    @Override
    public CategoryDomain toDomain(CategoryEntity entity) {
        return null;
    }

    @Override
    public List<CategoryEntity> toDTO(List<CategoryDomain> domainList) {
        return List.of();
    }
}
