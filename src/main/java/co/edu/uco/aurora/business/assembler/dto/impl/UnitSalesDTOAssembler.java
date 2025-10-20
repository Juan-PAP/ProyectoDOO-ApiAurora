package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.UnitSalesDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.UnitSalesDTO;

import java.util.ArrayList;
import java.util.List;

public final class UnitSalesDTOAssembler implements DTOAssembler<UnitSalesDTO, UnitSalesDomain> {

    private static final DTOAssembler<UnitSalesDTO, UnitSalesDomain> instance =
            new UnitSalesDTOAssembler();

    private UnitSalesDTOAssembler() {

    }

    public static DTOAssembler<UnitSalesDTO, UnitSalesDomain> getUnitSalesDTOAssembler() {
        return instance;
    }

    @Override
    public UnitSalesDTO toDTO(final UnitSalesDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UnitSalesDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UnitSalesDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public UnitSalesDomain toDomain(final UnitSalesDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new UnitSalesDTO());
        return new UnitSalesDomain(dtoTmp.getId(), dtoTmp.getName());
    }

    @Override
    public List<UnitSalesDTO> toDTO(final List<UnitSalesDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var unitSalesDtoList = new ArrayList<UnitSalesDTO>();

        for (var unitSalesDomain : domainList) {
            unitSalesDtoList.add(toDTO(unitSalesDomain));
        }

        return unitSalesDtoList;
    }
}
