package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.ProductDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public final class ProductDTOAssembler implements DTOAssembler<ProductDTO, ProductDomain> {

    private static final DTOAssembler<ProductDTO, ProductDomain> instance =
            new ProductDTOAssembler();

    private ProductDTOAssembler() {

    }

    public static DTOAssembler<ProductDTO, ProductDomain> getProductDTOAssembler() {
        return instance;
    }

    @Override
    public ProductDTO toDTO(final ProductDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProductDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var categoryDtoTmp = CategoryDTOAssembler.getCategoryDTOAssembler().toDTO(domainTmp.getCategory());
        return new ProductDTO(domainTmp.getId(), domainTmp.getName(), categoryDtoTmp);
    }

    @Override
    public ProductDomain toDomain(final ProductDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ProductDTO());
        var categoryDomainTmp  = CategoryDTOAssembler.getCategoryDTOAssembler().toDomain(dtoTmp.getCategory());
        return new ProductDomain(dtoTmp.getId(), dtoTmp.getName(), categoryDomainTmp);
    }

    @Override
    public List<ProductDTO> toDTO(final List<ProductDomain> domainList) {

        if (ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }

        var productDTOList = new ArrayList<ProductDTO>();

        for (var productDomain: domainList){
            productDTOList.add(toDTO(productDomain));
        }

        return productDTOList;
    }
}
