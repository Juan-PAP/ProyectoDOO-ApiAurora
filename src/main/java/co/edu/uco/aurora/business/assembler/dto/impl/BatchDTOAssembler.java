package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.BatchDomain;
import co.edu.uco.aurora.dto.BatchDTO;

import java.util.List;

public final class BatchDTOAssembler implements DTOAssembler<BatchDTO, BatchDomain> {

    private static final DTOAssembler<BatchDTO, BatchDomain> instance =
            new BatchDTOAssembler();

    private BatchDTOAssembler() {

    }

    public static DTOAssembler<BatchDTO, BatchDomain> getBatchDTOAssaembler() {
        return instance;
    }

    @Override
    public BatchDTO toDTO(BatchDomain domain) {
        return null;
    }

    @Override
    public BatchDomain toDomain(BatchDTO dto) {
        return null;
    }

    @Override
    public List<BatchDTO> toDTO(List<BatchDomain> domainList) {
        return List.of();
    }
}
