package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.BrandDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.BrandEntity;

import java.util.ArrayList;
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
    public BrandEntity toEntity(final BrandDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new BrandDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new BrandEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public BrandDomain toDomain(final BrandEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new BrandEntity());
        return new BrandDomain(entityTmp.getId(), entityTmp.getName());
    }

    @Override
    public List<BrandEntity> toEntity(final List<BrandDomain> domainList) {

        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var brandEntityList = new ArrayList<BrandEntity>();

        for (var brandDomain: domainList){
            brandEntityList.add(toEntity(brandDomain));
        }

        return brandEntityList;
    }

    @Override
    public List<BrandDomain> toDomain(List<BrandEntity> entityList) {
        var entityListTmp = ObjectHelper.getDefault(entityList, new ArrayList<BrandEntity>());
        var domainList = new ArrayList<BrandDomain>();

        for (var entity : entityListTmp) {
            domainList.add(toDomain(entity));
        }

        return domainList;
    }
}
