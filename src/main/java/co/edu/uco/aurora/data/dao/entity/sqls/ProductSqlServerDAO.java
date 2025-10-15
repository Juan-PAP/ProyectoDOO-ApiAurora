package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.ProductDAO;
import co.edu.uco.aurora.entity.ProductEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ProductSqlServerDAO extends SqlConnection implements ProductDAO {

    protected ProductSqlServerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void crate(ProductEntity entity) {

    }

    @Override
    public List<ProductEntity> findALL() {
        return List.of();
    }

    @Override
    public List<ProductEntity> findByFilter(ProductEntity filterEntity) {
        return List.of();
    }

    @Override
    public void update(ProductEntity entity) {

    }
}
