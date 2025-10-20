package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.SaleProductBrandDomain;
import co.edu.uco.aurora.dto.SaleProductBrandDTO;

import java.util.List;

public final class SaleProductBrandDTOAssembler implements DTOAssembler<SaleProductBrandDTO, SaleProductBrandDomain> {

    private static final DTOAssembler<SaleProductBrandDTO, SaleProductBrandDomain> instance =
            new SaleProductBrandDTOAssembler();

    private SaleProductBrandDTOAssembler() {

    }

    public static DTOAssembler<SaleProductBrandDTO, SaleProductBrandDomain> getSaleProductBrandDTOAssaembler() {
        return instance;
    }

    @Override
    public SaleProductBrandDTO toDTO(SaleProductBrandDomain domain) {
        return null;
    }

    @Override
    public SaleProductBrandDomain toDomain(SaleProductBrandDTO dto) {
        return null;
    }

    @Override
    public List<SaleProductBrandDTO> toDTO(List<SaleProductBrandDomain> domainList) {
        return List.of();
    }
}
