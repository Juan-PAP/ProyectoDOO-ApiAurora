package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.SaleDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.SaleEntity;

import java.util.ArrayList;
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
    public SaleEntity toEntity(final SaleDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new SaleDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var customerEntityTmp = CustomerEntityAssembler.getCustomerEntityAssembler().toEntity(domainTmp.getCustomer());
        return new SaleEntity(domainTmp.getId(), domainTmp.getSaleCode(), customerEntityTmp, domainTmp.getDate());
    }

    @Override
    public SaleDomain toDomain(final SaleEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new SaleEntity());
        var customerDomainTmp = CustomerEntityAssembler.getCustomerEntityAssembler().toDomain(entityTmp.getCustomer());
        return new SaleDomain(entityTmp.getId(), entityTmp.getSaleCode(), customerDomainTmp, entityTmp.getDate());
    }

    @Override
    public List<SaleEntity> toEntity(final List<SaleDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var saleEntityList = new ArrayList<SaleEntity>();

        for (var saleDomain : domainList){
            saleEntityList.add(toEntity(saleDomain));
        }

        return saleEntityList;
    }
}
