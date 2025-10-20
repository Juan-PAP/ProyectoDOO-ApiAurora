package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.BrandDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.BrandDTO;

import java.util.ArrayList;
import java.util.List;

public final class BrandDTOAssembler implements DTOAssembler<BrandDTO, BrandDomain> {

    private static final DTOAssembler<BrandDTO, BrandDomain> instance =
            new BrandDTOAssembler();

    private BrandDTOAssembler() {

    }

    public static DTOAssembler<BrandDTO, BrandDomain> getBrandDTOAssembler() {
        return instance;
    }

    @Override
    public BrandDTO toDTO(BrandDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new BrandDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new BrandDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public BrandDomain toDomain(BrandDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new BrandDTO());
        return new BrandDomain(dtoTmp.getId(), dtoTmp.getName());

    }

    @Override
    public List<BrandDTO> toDTO(List<BrandDomain> domainList) {

        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

         var branDTOList = new ArrayList<BrandDTO>();

        for (var brandDomain: domainList){
            branDTOList.add(toDTO(brandDomain));
        }

        return branDTOList;
    }
}
