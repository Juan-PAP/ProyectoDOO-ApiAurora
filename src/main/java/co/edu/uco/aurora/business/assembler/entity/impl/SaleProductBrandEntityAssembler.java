package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.SaleProductBrandDomain;
import co.edu.uco.aurora.entity.SaleProductBrandEntity;

import java.util.List;

public final class SaleProductBrandEntityAssembler implements EntityAssembler<SaleProductBrandEntity, SaleProductBrandDomain> {

    private static final EntityAssembler<SaleProductBrandEntity,SaleProductBrandDomain> instance =
            new SaleProductBrandEntityAssembler();

    private SaleProductBrandEntityAssembler() {

    }
    public static EntityAssembler<SaleProductBrandEntity,SaleProductBrandDomain> getSaleProductBrandEntityAssembler() {
        return instance;
    }


    @Override
    public SaleProductBrandEntity toEntity(SaleProductBrandDomain domain) {
        return null;
    }

    @Override
    public SaleProductBrandDomain toDomain(SaleProductBrandEntity entity) {
        return null;
    }

    @Override
    public List<SaleProductBrandEntity> toDTO(List<SaleProductBrandDomain> domainList) {
        return List.of();
    }
}
