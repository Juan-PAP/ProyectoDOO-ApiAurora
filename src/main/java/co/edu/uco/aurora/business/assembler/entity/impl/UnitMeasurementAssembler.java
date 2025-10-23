package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.UnitMeasurementDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.UnitMeasurementEntity;

import java.util.ArrayList;
import java.util.List;

public final class UnitMeasurementAssembler implements EntityAssembler<UnitMeasurementEntity, UnitMeasurementDomain> {

    private static final EntityAssembler<UnitMeasurementEntity, UnitMeasurementDomain> instance =
            new UnitMeasurementAssembler();

    private UnitMeasurementAssembler() {

    }
    public static EntityAssembler<UnitMeasurementEntity, UnitMeasurementDomain> getProductSizeEntityAssembler() {
        return instance;
    }

    @Override
    public UnitMeasurementEntity toEntity(final UnitMeasurementDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UnitMeasurementDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UnitMeasurementEntity(domainTmp.getId(), domainTmp.getNombre());
    }

    @Override
    public UnitMeasurementDomain toDomain(final UnitMeasurementEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new UnitMeasurementEntity());
        return new UnitMeasurementDomain(entityTmp.getId(), entityTmp.getNombre());
    }

    @Override
    public List<UnitMeasurementEntity> toEntity(final List<UnitMeasurementDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var productSizeEntityList = new ArrayList<UnitMeasurementEntity>();

        for (var productSizeDomain : domainList) {
            productSizeEntityList.add(toEntity(productSizeDomain));
        }

        return productSizeEntityList;
    }
}
