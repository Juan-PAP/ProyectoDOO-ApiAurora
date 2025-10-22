package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.ProductSizeDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.ProductSizeEntity;

import java.util.ArrayList;
import java.util.List;

public final class ProductSizeEntityAssembler implements EntityAssembler<ProductSizeEntity, ProductSizeDomain> {

    private static final EntityAssembler<ProductSizeEntity,ProductSizeDomain> instance =
            new ProductSizeEntityAssembler();

    private ProductSizeEntityAssembler() {

    }
    public static EntityAssembler<ProductSizeEntity,ProductSizeDomain> getProductSizeEntityAssembler() {
        return instance;
    }

    @Override
    public ProductSizeEntity toEntity(final ProductSizeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProductSizeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new ProductSizeEntity(domainTmp.getId(), domainTmp.getUnitMeasurement());
    }

    @Override
    public ProductSizeDomain toDomain(final ProductSizeEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new ProductSizeEntity());
        return new ProductSizeDomain(entityTmp.getId(), entityTmp.getUnitMeasurement());
    }

    @Override
    public List<ProductSizeEntity> toEntity(final List<ProductSizeDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var productSizeEntityList = new ArrayList<ProductSizeEntity>();

        for (var productSizeDomain : domainList) {
            productSizeEntityList.add(toEntity(productSizeDomain));
        }

        return productSizeEntityList;
    }
}
