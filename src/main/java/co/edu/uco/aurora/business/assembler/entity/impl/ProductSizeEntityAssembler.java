package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.ProductSizeDomain;
import co.edu.uco.aurora.entity.ProductSizeEntity;

import java.util.List;

public final class ProductSizeEntityAssembler implements EntityAssembler<ProductSizeEntity, ProductSizeDomain> {

    private static final EntityAssembler<ProductSizeEntity,ProductSizeDomain> instance =
            new ProductSizeEntityAssembler();

    private ProductSizeEntityAssembler() {

    }
    public static EntityAssembler<ProductSizeEntity,ProductSizeDomain> getProductSizeEntityAssemblerr() {
        return instance;
    }

    @Override
    public ProductSizeEntity toEntity(ProductSizeDomain domain) {
        return null;
    }

    @Override
    public ProductSizeDomain toDomain(ProductSizeEntity entity) {
        return null;
    }

    @Override
    public List<ProductSizeEntity> toDTO(List<ProductSizeDomain> domainList) {
        return List.of();
    }
}
