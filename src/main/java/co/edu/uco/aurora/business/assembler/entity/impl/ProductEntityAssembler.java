package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.ProductDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public final class ProductEntityAssembler implements EntityAssembler<ProductEntity, ProductDomain> {

    private static final EntityAssembler<ProductEntity,ProductDomain> instance =
            new ProductEntityAssembler();

    private ProductEntityAssembler() {

    }
    public static EntityAssembler<ProductEntity,ProductDomain> getProductEntityAssembler() {
        return instance;
    }

    @Override
    public ProductEntity toEntity(final ProductDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProductDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var categoryEntityTmp = CategoryEntityAssembler.getCategoryEntityAssembler().toEntity(domainTmp.getCategory());
        return new ProductEntity(domainTmp.getId(), domainTmp.getName(), categoryEntityTmp);
    }

    @Override
    public ProductDomain toDomain(final ProductEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new ProductEntity());
        var categoryDomainTmp  = CategoryEntityAssembler.getCategoryEntityAssembler().toDomain(entityTmp.getCategory());
        return new ProductDomain(entityTmp.getId(), entityTmp.getName(), categoryDomainTmp);
    }

    @Override
    public List<ProductEntity> toEntity(final List<ProductDomain> domainList) {
        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var productEntityList = new ArrayList<ProductEntity>();

        for (var productDomain: domainList){
            productEntityList.add(toEntity(productDomain));
        }

        return productEntityList;
    }

    @Override
    public List<ProductDomain> toDomain(List<ProductEntity> entityList) {
        var entityListTmp = ObjectHelper.getDefault(entityList, new ArrayList<ProductEntity>());
        var domainList = new ArrayList<ProductDomain>();

        for (var entity : entityListTmp) {
            domainList.add(toDomain(entity));
        }

        return domainList;
    }
}
