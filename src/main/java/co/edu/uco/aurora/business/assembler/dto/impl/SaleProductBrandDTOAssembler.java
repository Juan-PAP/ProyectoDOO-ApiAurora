package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.SaleProductBrandDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.SaleProductBrandDTO;

import java.util.ArrayList;
import java.util.List;

public final class SaleProductBrandDTOAssembler implements DTOAssembler<SaleProductBrandDTO, SaleProductBrandDomain> {

    private static final DTOAssembler<SaleProductBrandDTO, SaleProductBrandDomain> instance =
            new SaleProductBrandDTOAssembler();

    private SaleProductBrandDTOAssembler() {

    }

    public static DTOAssembler<SaleProductBrandDTO, SaleProductBrandDomain> getSaleProductBrandDTOAssembler() {
        return instance;
    }

    @Override
    public SaleProductBrandDTO toDTO(final SaleProductBrandDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new SaleProductBrandDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var saleDtoTmp = SaleDTOAssembler.getSaleDTOAssembler().toDTO(domainTmp.getSale());
        var productBrandDtoTmp = ProductBrandDTOAssembler.getProductBrandDTOAssembler().toDTO(domainTmp.getProductBrand());
        return new SaleProductBrandDTO(domainTmp.getId(), saleDtoTmp, productBrandDtoTmp, domainTmp.getUnitPrice(),
                domainTmp.getAmount());
    }

    @Override
    public SaleProductBrandDomain toDomain(final SaleProductBrandDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new SaleProductBrandDTO());
        var saleDomainTmp = SaleDTOAssembler.getSaleDTOAssembler().toDomain(dtoTmp.getSale());
        var productBrandDomainTmp = ProductBrandDTOAssembler.getProductBrandDTOAssembler().toDomain(dtoTmp.getProductBrand());
        return new SaleProductBrandDomain(dtoTmp.getId(), saleDomainTmp, productBrandDomainTmp, dtoTmp.getUnitPrice(),
                dtoTmp.getAmount());
    }

    @Override
    public List<SaleProductBrandDTO> toDTO(final List<SaleProductBrandDomain> domainList) {

        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var saleProductBrandDTOList = new ArrayList<SaleProductBrandDTO>();

        for (var productBrandDomain : domainList){
            saleProductBrandDTOList.add(toDTO(productBrandDomain));
        }

        return saleProductBrandDTOList;
    }
}
