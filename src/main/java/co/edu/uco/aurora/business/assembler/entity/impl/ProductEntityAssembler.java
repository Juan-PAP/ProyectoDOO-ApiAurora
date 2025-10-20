package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.ProductDomain;
import co.edu.uco.aurora.entity.ProductEntity;

import java.util.List;

public final class ProductEntityAssembler implements EntityAssembler<ProductEntity, ProductDomain> {

    private static final EntityAssembler<ProductEntity,ProductDomain> instance =
            new ProductEntityAssembler();

    private ProductEntityAssembler() {

    }
    public static EntityAssembler<ProductEntity,ProductDomain> getCProductEntityAssembler() {
        return instance;
    }

    @Override
    public ProductEntity toEntity(ProductDomain domain) {
        return null;
    }

    @Override
    public ProductDomain toDomain(ProductEntity entity) {
        return null;
    }

    @Override
    public List<ProductEntity> toDTO(List<ProductDomain> domainList) {
        return List.of();
    }
}
