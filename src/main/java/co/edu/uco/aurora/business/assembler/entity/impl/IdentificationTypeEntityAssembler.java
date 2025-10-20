package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.util.List;

public final class IdentificationTypeEntityAssembler implements EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> {

    private static final EntityAssembler<IdentificationTypeEntity,IdentificationTypeDomain> instance =
            new IdentificationTypeEntityAssembler();

    private IdentificationTypeEntityAssembler() {

    }
    public static EntityAssembler<IdentificationTypeEntity,IdentificationTypeDomain> getIdentificationTypeEntityAssembler() {
        return instance;
    }

    @Override
    public IdentificationTypeEntity toEntity(IdentificationTypeDomain domain) {
        return null;
    }

    @Override
    public IdentificationTypeDomain toDomain(IdentificationTypeEntity entity) {
        return null;
    }

    @Override
    public List<IdentificationTypeEntity> toDTO(List<IdentificationTypeDomain> domainList) {
        return List.of();
    }
}
