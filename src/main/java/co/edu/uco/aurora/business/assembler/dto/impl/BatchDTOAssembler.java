package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.BatchDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.BatchDTO;

import java.util.ArrayList;
import java.util.List;

public final class BatchDTOAssembler implements DTOAssembler<BatchDTO, BatchDomain> {

    private static final DTOAssembler<BatchDTO, BatchDomain> instance =
            new BatchDTOAssembler();

    private BatchDTOAssembler() {

    }

    public static DTOAssembler<BatchDTO, BatchDomain> getBatchDTOAssembler() {
        return instance;
    }

    @Override
    public BatchDTO toDTO(final BatchDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new BatchDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var productBrandDtoTmp = ProductBrandDTOAssembler.getProductBrandDTOAssembler().toDTO(domainTmp.getProductBrand());

        return new BatchDTO(domainTmp.getId(), productBrandDtoTmp, domainTmp.isPerishable(),
                domainTmp.getExpirationDate(), domainTmp.getAmount());
    }

    @Override
    public BatchDomain toDomain(final BatchDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new BatchDTO());
        var productBrandDomainTmp = ProductBrandDTOAssembler.getProductBrandDTOAssembler().toDomain(dtoTmp.getProductBrand());

        return new BatchDomain(dtoTmp.getId(), productBrandDomainTmp, dtoTmp.isPerishable(),
                dtoTmp.getExpirationDate(), dtoTmp.getAmount());
    }

    @Override
    public List<BatchDTO> toDTO(final List<BatchDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var batchDTOList = new ArrayList<BatchDTO>();

        for (var batchDomain : domainList){
            batchDTOList.add(toDTO(batchDomain));
        }

        return batchDTOList;
    }
}
