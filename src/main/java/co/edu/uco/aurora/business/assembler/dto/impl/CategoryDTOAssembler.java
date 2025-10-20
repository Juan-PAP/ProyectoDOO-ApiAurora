package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.CategoryDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public final class CategoryDTOAssembler implements DTOAssembler<CategoryDTO, CategoryDomain> {

    private static final DTOAssembler<CategoryDTO, CategoryDomain> instance =
            new CategoryDTOAssembler();

    private CategoryDTOAssembler() {

    }

    public static DTOAssembler<CategoryDTO, CategoryDomain> getCategoryDTOAssembler() {
        return instance;
    }

    @Override
    public CategoryDTO toDTO(final CategoryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CategoryDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new CategoryDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CategoryDomain toDomain(final CategoryDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CategoryDTO());
        return new CategoryDomain(dtoTmp.getId(),dtoTmp.getName());
    }

    @Override
    public List<CategoryDTO> toDTO(final List<CategoryDomain> domainList) {

        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var categoryDTOList = new ArrayList<CategoryDTO>();

        for (var categoryDomain: domainList) {
            categoryDTOList.add(toDTO(categoryDomain));
        }

        return categoryDTOList;
    }
}
