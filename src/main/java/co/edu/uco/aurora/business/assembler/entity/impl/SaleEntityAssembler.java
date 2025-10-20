package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.SaleDomain;
import co.edu.uco.aurora.entity.SaleEntity;

import java.util.List;

public final  class SaleEntityAssembler implements EntityAssembler<SaleEntity, SaleDomain> {

    private static final EntityAssembler<SaleEntity,SaleDomain> instance =
            new SaleEntityAssembler();

    private SaleEntityAssembler() {

    }
    public static EntityAssembler<SaleEntity,SaleDomain> getSaleEntityAssembler() {
        return instance;
    }


    @Override
    public SaleEntity toEntity(SaleDomain domain) {
        return null;
    }

    @Override
    public SaleDomain toDomain(SaleEntity entity) {
        return null;
    }

    @Override
    public List<SaleEntity> toDTO(List<SaleDomain> domainList) {
        return List.of();
    }
}
