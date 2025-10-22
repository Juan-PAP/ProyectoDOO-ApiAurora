package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.BatchDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.BatchEntity;

import java.util.ArrayList;
import java.util.List;

public final class BatchEntityAssembler implements EntityAssembler<BatchEntity, BatchDomain> {

    private static final EntityAssembler<BatchEntity,BatchDomain> instance =
            new BatchEntityAssembler();

    private BatchEntityAssembler() {

    }
    public static EntityAssembler<BatchEntity,BatchDomain> getBatchEntityAssembler() {
        return instance;
    }


    @Override
    public BatchEntity toEntity(final BatchDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new BatchDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var productBrandEntityTmp = ProductBrandEntityAssembler.getProductBrandEntityAssembler().toEntity(domainTmp.getProductBrand());

        return new BatchEntity(domainTmp.getId(), productBrandEntityTmp, domainTmp.isPerishable(),
                domainTmp.getExpirationDate(), domainTmp.getAmount());
    }

    @Override
    public BatchDomain toDomain(final BatchEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new BatchEntity());
        var productBrandDomainTmp = ProductBrandEntityAssembler.getProductBrandEntityAssembler().toDomain(entityTmp.getProductBrand());

        return new BatchDomain(entityTmp.getId(), productBrandDomainTmp, entityTmp.isPerishable(),
                entityTmp.getExpirationDate(), entityTmp.getAmount());
    }

    @Override
    public List<BatchEntity> toEntity(final List<BatchDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var batchEntityList = new ArrayList<BatchEntity>();

        for (var batchDomain : domainList){
            batchEntityList.add(toEntity(batchDomain));
        }

        return batchEntityList;
    }
}
