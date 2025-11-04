package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.util.ArrayList;
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
    public IdentificationTypeEntity toEntity(final IdentificationTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new IdentificationTypeEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public IdentificationTypeDomain toDomain(final IdentificationTypeEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new IdentificationTypeEntity());
        return new IdentificationTypeDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<IdentificationTypeEntity> toEntity(final List<IdentificationTypeDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var identificationTypeEntityList = new ArrayList<IdentificationTypeEntity>();

        for (var identificationTypeDomain : domainList) {
            identificationTypeEntityList.add(toEntity(identificationTypeDomain));
        }

        return identificationTypeEntityList;
    }

    @Override
    public List<IdentificationTypeDomain> toDomain(List<IdentificationTypeEntity> entityList) {
        var entityListTmp = ObjectHelper.getDefault(entityList, new ArrayList<IdentificationTypeEntity>());
        var domainList = new ArrayList<IdentificationTypeDomain>();

        for (var entity : entityListTmp) {
            domainList.add(toDomain(entity));
        }

        return domainList;
    }
}
