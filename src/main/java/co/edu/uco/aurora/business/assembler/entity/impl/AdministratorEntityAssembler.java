package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.entity.AdministratorEntity;

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
    public AdministratorEntity toEntity(AdministratorDomain domain) {
        return null;
    }

    @Override
    public AdministratorDomain toDomain(AdministratorEntity entity) {
        return null;
    }

    @Override
    public List<AdministratorEntity> toDTO(List<AdministratorDomain> domainList) {
        return List.of();
    }
}
