package co.edu.uco.aurora.business.assembler.entity.impl;

import co.edu.uco.aurora.business.assembler.entity.EntityAssembler;
import co.edu.uco.aurora.business.domain.ProductBrandDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.entity.ProductBrandEntity;

import java.util.ArrayList;
import java.util.List;

public final class ProductBrandEntityAssembler implements EntityAssembler<ProductBrandEntity, ProductBrandDomain> {

    private static final EntityAssembler<ProductBrandEntity,ProductBrandDomain> instance =
            new ProductBrandEntityAssembler();

    private ProductBrandEntityAssembler() {

    }
    public static EntityAssembler<ProductBrandEntity,ProductBrandDomain> getProductBrandEntityAssembler (){
        return instance;
    }


    @Override
    public ProductBrandEntity toEntity(final ProductBrandDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProductBrandDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var productEntityTmp = ProductEntityAssembler.getProductEntityAssembler().toEntity(domainTmp.getProduct());
        var brandEntityTmp = BrandEntityAssembler.getBrandEntityAssembler().toEntity(domainTmp.getBrand());
        var productSizeEntityTmp = UnitMeasurementAssembler.getProductSizeEntityAssembler().toEntity(domainTmp.getUnitMeasurement());
        var unitSalesEntityTmp = UnitSalesEntityAssembler.getUnitSalesEntityAssembler().toEntity(domainTmp.getUnitSales());

        return new ProductBrandEntity(domainTmp.getId(),domainTmp.getReference() , productEntityTmp, brandEntityTmp,
                domainTmp.getMeasure(), productSizeEntityTmp, unitSalesEntityTmp, domainTmp.getPrice(),
                domainTmp.isHasAgeRestriction());
    }

    @Override
    public ProductBrandDomain toDomain(final ProductBrandEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new ProductBrandEntity());
        var productDomainTmp = ProductEntityAssembler.getProductEntityAssembler().toDomain(entityTmp.getProduct());
        var brandDomainTmp = BrandEntityAssembler.getBrandEntityAssembler().toDomain(entityTmp.getBrand());
        var productSizeDomainTmp = UnitMeasurementAssembler.getProductSizeEntityAssembler().toDomain(entityTmp.getUnitMeasurement());
        var unitSalesDomainTmp = UnitSalesEntityAssembler.getUnitSalesEntityAssembler().toDomain(entityTmp.getUnitSales());

        return new ProductBrandDomain(entityTmp.getId(), entityTmp.getReference() , productDomainTmp, brandDomainTmp,
                entityTmp.getMeasure(), productSizeDomainTmp, unitSalesDomainTmp, entityTmp.getPrice(),
                entityTmp.isHasAgeRestriction());
    }

    @Override
    public List<ProductBrandEntity> toEntity(final List<ProductBrandDomain> domainList) {
        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var productBrandEntityList = new ArrayList<ProductBrandEntity>();

        for (var productBrandDomain : domainList){
            productBrandEntityList.add(toEntity(productBrandDomain));
        }

        return productBrandEntityList;
    }

    @Override
    public List<ProductBrandDomain> toDomain(List<ProductBrandEntity> entityList) {
        var entityListTmp = ObjectHelper.getDefault(entityList, new ArrayList<ProductBrandEntity>());
        var domainList = new ArrayList<ProductBrandDomain>();

        for (var entity : entityListTmp) {
            domainList.add(toDomain(entity));
        }

        return domainList;
    }


}
