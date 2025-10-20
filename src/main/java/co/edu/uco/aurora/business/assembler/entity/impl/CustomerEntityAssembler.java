package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.entity.CustomerEntity;

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
    public CustomerEntity toEntity(CustomerDomain domain) {
        return null;
    }

    @Override
    public CustomerDomain toDomain(CustomerEntity entity) {
        return null;
    }

    @Override
    public List<CustomerEntity> toDTO(List<CustomerDomain> domainList) {
        return List.of();
    }
}
