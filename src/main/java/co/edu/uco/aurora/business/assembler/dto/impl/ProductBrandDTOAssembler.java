package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.ProductBrandDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.ProductBrandDTO;

import java.util.ArrayList;
import java.util.List;

public final class ProductBrandDTOAssembler implements DTOAssembler<ProductBrandDTO, ProductBrandDomain> {

    private static final DTOAssembler<ProductBrandDTO, ProductBrandDomain> instance =
            new ProductBrandDTOAssembler();

    private ProductBrandDTOAssembler() {

    }

    public static DTOAssembler<ProductBrandDTO, ProductBrandDomain> getProductBrandDTOAssembler() {
        return instance;
    }

    @Override
    public ProductBrandDTO toDTO(final ProductBrandDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProductBrandDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var productDtoTmp = ProductDTOAssembler.getProductDTOAssembler().toDTO(domainTmp.getProduct());
        var brandDtoTmp = BrandDTOAssembler.getBrandDTOAssembler().toDTO(domainTmp.getBrand());
        var productSizeDtoTmp = UnitMeasurementDTOAssembler.getProductSizeDTOAssembler().toDTO(domainTmp.getProductSize());
        var unitSalesDtoTmp = UnitSalesDTOAssembler.getUnitSalesDTOAssembler().toDTO(domainTmp.getUnitSales());

        return new ProductBrandDTO(domainTmp.getId(),domainTmp.getReference() ,productDtoTmp, brandDtoTmp,
                domainTmp.getMeasure(), productSizeDtoTmp, unitSalesDtoTmp, domainTmp.getPrice(),
                domainTmp.isAgeRestriction());
    }

    @Override
    public ProductBrandDomain toDomain(final ProductBrandDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ProductBrandDTO());
        var productDomainTmp = ProductDTOAssembler.getProductDTOAssembler().toDomain(dtoTmp.getProduct());
        var brandDomainTmp = BrandDTOAssembler.getBrandDTOAssembler().toDomain(dtoTmp.getBrand());
        var productSizeDomainTmp = UnitMeasurementDTOAssembler.getProductSizeDTOAssembler().toDomain(dtoTmp.getProductSize());
        var unitSalesDomainTmp = UnitSalesDTOAssembler.getUnitSalesDTOAssembler().toDomain(dtoTmp.getUnitSales());

        return new ProductBrandDomain(dtoTmp.getId(),dtoTmp.getReference() , productDomainTmp, brandDomainTmp,
                dtoTmp.getMeasure(), productSizeDomainTmp, unitSalesDomainTmp, dtoTmp.getPrice(),
                dtoTmp.isAgeRestriction());
    }

    @Override
    public List<ProductBrandDTO> toDTO(final List<ProductBrandDomain> domainList) {

        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var productBrandDTOList = new ArrayList<ProductBrandDTO>();

        for (var productBrandDomain : domainList){
            productBrandDTOList.add(toDTO(productBrandDomain));
        }

        return productBrandDTOList;
    }
}
