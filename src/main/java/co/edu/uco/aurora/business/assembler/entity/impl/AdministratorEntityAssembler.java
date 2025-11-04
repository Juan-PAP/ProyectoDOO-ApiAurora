package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.AdministratorEntity;

import java.util.ArrayList;
import java.util.List;

public final class AdministratorEntityAssembler implements EntityAssembler<AdministratorEntity, AdministratorDomain> {

    private static final EntityAssembler<AdministratorEntity,AdministratorDomain> instance =
            new AdministratorEntityAssembler();

    private AdministratorEntityAssembler() {

    }
    public static EntityAssembler<AdministratorEntity,AdministratorDomain> getAdministratorEntityAssembler() {
        return instance;
    }

    @Override
    public AdministratorEntity toEntity(final AdministratorDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new AdministratorDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new AdministratorEntity(domainTmp.getId(), domainTmp.getUser(), domainTmp.getPassword());
    }

    @Override
    public AdministratorDomain toDomain(final AdministratorEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new AdministratorEntity());
        return new AdministratorDomain(entityTmp.getId(), entityTmp.getUser(), entityTmp.getPassword());
    }

    @Override
    public List<AdministratorEntity> toEntity(final List<AdministratorDomain> domainList) {

        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var administradorEntityList = new ArrayList<AdministratorEntity>();

        for (var administratorDomain : domainList) {
            administradorEntityList.add(toEntity(administratorDomain));
        }

        return administradorEntityList;
    }

    @Override
    public List<AdministratorDomain> toDomain(List<AdministratorEntity> entityList) {
        var entityListTmp = ObjectHelper.getDefault(entityList, new ArrayList<AdministratorEntity>());
        var domainList = new ArrayList<AdministratorDomain>();

        for (var entity : entityListTmp) {
            domainList.add(toDomain(entity));
        }

        return domainList;
    }
}
