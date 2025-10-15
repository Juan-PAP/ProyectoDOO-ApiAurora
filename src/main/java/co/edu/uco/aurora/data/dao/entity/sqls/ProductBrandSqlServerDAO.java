package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.ProductBrandDAO;
import co.edu.uco.aurora.entity.ProductBrandEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ProductBrandSqlServerDAO extends SqlConnection implements ProductBrandDAO {

    protected ProductBrandSqlServerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void crate(ProductBrandEntity entity) {

    }

    @Override
    public List<ProductBrandEntity> findALL() {
        return List.of();
    }

    @Override
    public List<ProductBrandEntity> findByFilter(ProductBrandEntity filterEntity) {
        return List.of();
    }

    @Override
    public void update(ProductBrandEntity entity) {

    }
}
