package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.BatchDomain;
import co.edu.uco.aurora.entity.BatchEntity;

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
    public BatchEntity toEntity(BatchDomain domain) {
        return null;
    }

    @Override
    public BatchDomain toDomain(BatchEntity entity) {
        return null;
    }

    @Override
    public List<BatchEntity> toDTO(List<BatchDomain> domainList) {
        return List.of();
    }
}
