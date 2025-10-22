package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.UnitSalesDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.UnitSalesEntity;

import java.util.ArrayList;
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
    public UnitSalesEntity toEntity(final UnitSalesDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UnitSalesDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UnitSalesEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public UnitSalesDomain toDomain(final UnitSalesEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new UnitSalesEntity());
        return new UnitSalesDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<UnitSalesEntity> toEntity(final List<UnitSalesDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var unitSalesEntityList = new ArrayList<UnitSalesEntity>();

        for (var unitSalesDomain : domainList) {
            unitSalesEntityList.add(toEntity(unitSalesDomain));
        }

        return unitSalesEntityList;
    }
}
