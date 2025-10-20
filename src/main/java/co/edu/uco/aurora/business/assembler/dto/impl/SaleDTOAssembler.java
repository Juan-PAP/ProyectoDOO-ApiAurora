package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.SaleDomain;
import co.edu.uco.aurora.dto.SaleDTO;

import java.util.List;

public final class SaleDTOAssembler implements DTOAssembler<SaleDTO, SaleDomain> {

    private static final DTOAssembler<SaleDTO, SaleDomain> instance =
            new SaleDTOAssembler();

    private SaleDTOAssembler() {

    }

    public static DTOAssembler<SaleDTO, SaleDomain> getSaleDTOAssaembler() {
        return instance;
    }

    @Override
    public SaleDTO toDTO(SaleDomain domain) {
        return null;
    }

    @Override
    public SaleDomain toDomain(SaleDTO dto) {
        return null;
    }

    @Override
    public List<SaleDTO> toDTO(List<SaleDomain> domainList) {
        return List.of();
    }
}
