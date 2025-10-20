package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.ProductBrandDomain;
import co.edu.uco.aurora.dto.ProductBrandDTO;

import java.util.List;

public final class ProductBrandDTOAssembler implements DTOAssembler<ProductBrandDTO, ProductBrandDomain> {

    private static final DTOAssembler<ProductBrandDTO, ProductBrandDomain> instance =
            new ProductBrandDTOAssembler();

    private ProductBrandDTOAssembler() {

    }

    public static DTOAssembler<ProductBrandDTO, ProductBrandDomain> getProductBrandDTOAssaembler() {
        return instance;
    }

    @Override
    public ProductBrandDTO toDTO(ProductBrandDomain domain) {
        return null;
    }

    @Override
    public ProductBrandDomain toDomain(ProductBrandDTO dto) {
        return null;
    }

    @Override
    public List<ProductBrandDTO> toDTO(List<ProductBrandDomain> domainList) {
        return List.of();
    }
}
