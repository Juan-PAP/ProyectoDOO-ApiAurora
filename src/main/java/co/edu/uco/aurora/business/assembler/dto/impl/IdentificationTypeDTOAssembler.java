package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;

import java.util.ArrayList;
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
    public IdentificationTypeDTO toDTO(final IdentificationTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new IdentificationTypeDTO(domainTmp.getId(), domainTmp.getNombre());
    }

    @Override
    public IdentificationTypeDomain toDomain(final IdentificationTypeDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new IdentificationTypeDTO());
        return new IdentificationTypeDomain(dtoTmp.getId(), dtoTmp.getNombre());
    }

    @Override
    public List<IdentificationTypeDTO> toDTO(final List<IdentificationTypeDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var identificationTypeDtoList = new ArrayList<IdentificationTypeDTO>();

        for (var identificationTypeDomain : domainList) {
            identificationTypeDtoList.add(toDTO(identificationTypeDomain));
        }

        return identificationTypeDtoList;
    }
}
