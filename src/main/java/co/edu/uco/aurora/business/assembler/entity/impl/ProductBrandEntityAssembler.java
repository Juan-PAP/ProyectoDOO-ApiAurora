package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.ProductBrandDomain;
import co.edu.uco.aurora.entity.ProductBrandEntity;

import java.util.List;

public final class ProductBrandEntityAssembler implements EntityAssembler<ProductBrandEntity, ProductBrandDomain> {

    private static final EntityAssembler<ProductBrandEntity,ProductBrandDomain> instance =
            new ProductBrandEntityAssembler();

    private ProductBrandEntityAssembler() {

    }
    public static EntityAssembler<ProductBrandEntity,ProductBrandDomain> getProductBrandEntityAssembler (){
        return instance;
    }


    @Override
    public ProductBrandEntity toEntity(ProductBrandDomain domain) {
        return null;
    }

    @Override
    public ProductBrandDomain toDomain(ProductBrandEntity entity) {
        return null;
    }

    @Override
    public List<ProductBrandEntity> toDTO(List<ProductBrandDomain> domainList) {
        return List.of();
    }
}
