package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.SaleDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.SaleDTO;

import java.util.ArrayList;
import java.util.List;

public final class SaleDTOAssembler implements DTOAssembler<SaleDTO, SaleDomain> {

    private static final DTOAssembler<SaleDTO, SaleDomain> instance =
            new SaleDTOAssembler();

    private SaleDTOAssembler() {

    }

    public static DTOAssembler<SaleDTO, SaleDomain> getSaleDTOAssembler() {
        return instance;
    }

    @Override
    public SaleDTO toDTO(final SaleDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new SaleDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var customerDtoTmp = CustomerDTOAssembler.getCustomerDTOAssembler().toDTO(domainTmp.getCustomer());
        return new SaleDTO(domainTmp.getId(), domainTmp.getSaleCode(),customerDtoTmp, domainTmp.getDate());
    }

    @Override
    public SaleDomain toDomain(final SaleDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new SaleDTO());
        var customerDomainTmp = CustomerDTOAssembler.getCustomerDTOAssembler().toDomain(dtoTmp.getCustomer());
        return new SaleDomain(dtoTmp.getId(), dtoTmp.getSaleCode(), customerDomainTmp, dtoTmp.getDate());
    }

    @Override
    public List<SaleDTO> toDTO(final List<SaleDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var saleDTOList = new ArrayList<SaleDTO>();

        for (var saleDomain : domainList){
            saleDTOList.add(toDTO(saleDomain));
        }

        return saleDTOList;
    }
}
