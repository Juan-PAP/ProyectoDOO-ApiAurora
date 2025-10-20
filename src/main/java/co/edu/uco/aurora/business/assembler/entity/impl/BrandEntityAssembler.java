package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.BrandDomain;
import co.edu.uco.aurora.entity.BrandEntity;

import java.util.List;

public final class BrandEntityAssembler implements EntityAssembler<BrandEntity, BrandDomain> {

    private static final EntityAssembler<BrandEntity,BrandDomain> instance =
            new BrandEntityAssembler();

    private BrandEntityAssembler() {

    }
    public static EntityAssembler<BrandEntity,BrandDomain> getBrandEntityAssembler() {
        return instance;
    }


    @Override
    public BrandEntity toEntity(BrandDomain domain) {
        return null;
    }

    @Override
    public BrandDomain toDomain(BrandEntity entity) {
        return null;
    }

    @Override
    public List<BrandEntity> toDTO(List<BrandDomain> domainList) {
        return List.of();
    }
}
