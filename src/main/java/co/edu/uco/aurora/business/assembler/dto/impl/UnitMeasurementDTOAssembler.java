package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.UnitMeasurementDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.UnitMeasurementDTO;

import java.util.ArrayList;
import java.util.List;

public final class UnitMeasurementDTOAssembler implements DTOAssembler<UnitMeasurementDTO, UnitMeasurementDomain> {

    private static final DTOAssembler<UnitMeasurementDTO, UnitMeasurementDomain> instance =
            new UnitMeasurementDTOAssembler();

    private UnitMeasurementDTOAssembler() {

    }

    public static DTOAssembler<UnitMeasurementDTO, UnitMeasurementDomain> getProductSizeDTOAssembler() {
        return instance;
    }

    @Override
    public UnitMeasurementDTO toDTO(final UnitMeasurementDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UnitMeasurementDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UnitMeasurementDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public UnitMeasurementDomain toDomain(final UnitMeasurementDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new UnitMeasurementDTO());
        return new UnitMeasurementDomain(dtoTmp.getId(), dtoTmp.getName());
    }

    @Override
    public List<UnitMeasurementDTO> toDTO(final List<UnitMeasurementDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var productSizeDtoList = new ArrayList<UnitMeasurementDTO>();

        for (var productSizeDomain : domainList) {
            productSizeDtoList.add(toDTO(productSizeDomain));
        }

        return productSizeDtoList;
    }
}
