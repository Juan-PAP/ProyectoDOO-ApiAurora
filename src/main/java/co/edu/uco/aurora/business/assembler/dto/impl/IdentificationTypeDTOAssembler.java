package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;

import java.util.List;

public final class IdentificationTypeDTOAssembler implements DTOAssembler<IdentificationTypeDTO,
        IdentificationTypeDomain> {

    private static final DTOAssembler<IdentificationTypeDTO, IdentificationTypeDomain> instance =
            new IdentificationTypeDTOAssembler();

    private IdentificationTypeDTOAssembler() {

    }

    public static DTOAssembler<IdentificationTypeDTO,
            IdentificationTypeDomain> getIdentificationTypeDTOAssembler() {
        return instance;
    }

    @Override
    public IdentificationTypeDTO toDTO(IdentificationTypeDomain domain) {
        return null;
    }

    @Override
    public IdentificationTypeDomain toDomain(IdentificationTypeDTO dto) {
        return null;
    }

    @Override
    public List<IdentificationTypeDTO> toDTO(List<IdentificationTypeDomain> domainList) {
        return List.of();
    }
}
