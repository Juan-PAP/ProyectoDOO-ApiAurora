package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.UnitSalesDomain;
import co.edu.uco.aurora.entity.UnitSalesEntity;

import java.util.List;

public final class UnitSalesEntityAssembler implements EntityAssembler<UnitSalesEntity, UnitSalesDomain> {

    private static final EntityAssembler<UnitSalesEntity,UnitSalesDomain> instance =
            new UnitSalesEntityAssembler();

    private UnitSalesEntityAssembler() {

    }
    public static EntityAssembler<UnitSalesEntity,UnitSalesDomain> getUnitSalesEntityAssembler() {
        return instance;
    }


    @Override
    public UnitSalesEntity toEntity(UnitSalesDomain domain) {
        return null;
    }

    @Override
    public UnitSalesDomain toDomain(UnitSalesEntity entity) {
        return null;
    }

    @Override
    public List<UnitSalesEntity> toDTO(List<UnitSalesDomain> domainList) {
        return List.of();
    }
}
