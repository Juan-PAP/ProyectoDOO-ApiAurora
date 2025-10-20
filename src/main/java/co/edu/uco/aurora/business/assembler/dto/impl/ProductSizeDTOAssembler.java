package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.ProductSizeDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.ProductSizeDTO;

import java.util.ArrayList;
import java.util.List;

public final class ProductSizeDTOAssembler implements DTOAssembler<ProductSizeDTO, ProductSizeDomain> {

    private static final DTOAssembler<ProductSizeDTO, ProductSizeDomain> instance =
            new ProductSizeDTOAssembler();

    private ProductSizeDTOAssembler() {

    }

    public static DTOAssembler<ProductSizeDTO, ProductSizeDomain> getProductSizeDTOAssembler() {
        return instance;
    }

    @Override
    public ProductSizeDTO toDTO(final ProductSizeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProductSizeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new ProductSizeDTO(domainTmp.getId(), domainTmp.getUnitMeasurement());
    }

    @Override
    public ProductSizeDomain toDomain(final ProductSizeDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ProductSizeDTO());
        return new ProductSizeDomain(dtoTmp.getId(), dtoTmp.getUnitMeasurement());
    }

    @Override
    public List<ProductSizeDTO> toDTO(final List<ProductSizeDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var productSizeDtoList = new ArrayList<ProductSizeDTO>();

        for (var productSizeDomain : domainList) {
            productSizeDtoList.add(toDTO(productSizeDomain));
        }

        return productSizeDtoList;
    }
}
