package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public final class CustomerEntityAssembler implements EntityAssembler<CustomerEntity, CustomerDomain> {

    private static final EntityAssembler<CustomerEntity,CustomerDomain> instance =
            new CustomerEntityAssembler();

    private CustomerEntityAssembler() {

    }
    public static EntityAssembler<CustomerEntity,CustomerDomain> getCustomerEntityAssembler() {
        return instance;
    }


    @Override
    public CustomerEntity toEntity(final CustomerDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CustomerDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var identificationTypeEntityTmp = IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler().
                toEntity(domainTmp.getIdentificationType());
        return new CustomerEntity(domainTmp.getId(), identificationTypeEntityTmp, domainTmp.getIdentificationNumber()
                , domainTmp.getFullName(), domainTmp.getPhoneNumber(), domainTmp.isPhoneNumberConfirmed(), domainTmp.getBirthDate());
    }

    @Override
    public CustomerDomain toDomain(final CustomerEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new CustomerEntity());
        var identificationTypeDomainTmp = IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler().
                toDomain(entityTmp.getIdentificationType());
        return new CustomerDomain(entityTmp.getId(), identificationTypeDomainTmp, entityTmp.getIdentificationNumber()
                , entityTmp.getFullName(), entityTmp.getPhoneNumber(), entityTmp.isPhoneNumberConfirmed(), entityTmp.getBirthDate());
    }

    @Override
    public List<CustomerEntity> toEntity(final List<CustomerDomain> domainList) {
        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var customerEntityList = new ArrayList<CustomerEntity>();

        for (var customerDomain : domainList){
            customerEntityList.add(toEntity(customerDomain));
        }

        return customerEntityList;
    }
}
