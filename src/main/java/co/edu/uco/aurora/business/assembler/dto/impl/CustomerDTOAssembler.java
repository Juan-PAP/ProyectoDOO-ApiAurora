package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public final class CustomerDTOAssembler implements DTOAssembler<CustomerDTO, CustomerDomain> {

    private static final DTOAssembler<CustomerDTO, CustomerDomain> instance =
            new CustomerDTOAssembler();

    private CustomerDTOAssembler() {

    }

    public static DTOAssembler<CustomerDTO, CustomerDomain> getCustomerDTOAssembler() {
        return instance;
    }

    @Override
    public CustomerDTO toDTO(final CustomerDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CustomerDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var identificationTypeDtoTmp = IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler().toDTO(domainTmp.getIdentificationType());
        return new CustomerDTO(domainTmp.getId(), identificationTypeDtoTmp, domainTmp.getIdentificationNumber()
                , domainTmp.getFullName(), domainTmp.getPhoneNumber(), domainTmp.isConfirmedPhoneNumber(), domainTmp.getBirthDate());
    }

    @Override
    public CustomerDomain toDomain(final CustomerDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CustomerDTO());
        var identificationTypeDomainTmp = IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler().toDomain(dtoTmp.getIdentificationType());
        return new CustomerDomain(dtoTmp.getId(), identificationTypeDomainTmp, dtoTmp.getIdentificationNumber()
                , dtoTmp.getFullName(), dtoTmp.getPhoneNumber(), dtoTmp.isConfirmedPhoneNumber(), dtoTmp.getBirthDate());
    }

    @Override
    public List<CustomerDTO> toDTO(final List<CustomerDomain> domainList) {

        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var customerDTOList = new ArrayList<CustomerDTO>();

        for (var customerDomain : domainList){
            customerDTOList.add(toDTO(customerDomain));
        }

        return customerDTOList;
    }
}
