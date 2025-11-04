package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.SaleProductBrandDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.SaleProductBrandEntity;

import java.util.ArrayList;
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
    public SaleProductBrandEntity toEntity(final SaleProductBrandDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new SaleProductBrandDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var saleEntityTmp = SaleEntityAssembler.getSaleEntityAssembler().toEntity(domainTmp.getSale());
        var productBrandEntityTmp = ProductBrandEntityAssembler.getProductBrandEntityAssembler()
                .toEntity(domainTmp.getProductBrand());
        return new SaleProductBrandEntity(domainTmp.getId(), saleEntityTmp, productBrandEntityTmp, domainTmp.getUnitPrice(),
                domainTmp.getAmount());
    }

    @Override
    public SaleProductBrandDomain toDomain(final SaleProductBrandEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new SaleProductBrandEntity(UUIDHelper.getUUIDHelper().getDefault()));
        var saleDomainTmp = SaleEntityAssembler.getSaleEntityAssembler().toDomain(entityTmp.getSale());
        var productBrandDomainTmp = ProductBrandEntityAssembler.getProductBrandEntityAssembler().toDomain(entityTmp.getProductBrand());
        return new SaleProductBrandDomain(entityTmp.getId(), saleDomainTmp, productBrandDomainTmp, entityTmp.getUnitPrice(),
                entityTmp.getAmount());
    }

    @Override
    public List<SaleProductBrandEntity> toEntity(final List<SaleProductBrandDomain> domainList) {
        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var saleProductBrandEntityList = new ArrayList<SaleProductBrandEntity>();

        for (var productBrandDomain : domainList){
            saleProductBrandEntityList.add(toEntity(productBrandDomain));
        }

        return saleProductBrandEntityList;
    }

    @Override
    public List<SaleProductBrandDomain> toDomain(List<SaleProductBrandEntity> entityList) {
        var entityListTmp = ObjectHelper.getDefault(entityList, new ArrayList<SaleProductBrandEntity>());
        var domainList = new ArrayList<SaleProductBrandDomain>();

        for (var entity : entityListTmp) {
            domainList.add(toDomain(entity));
        }

        return domainList;
    }
}
