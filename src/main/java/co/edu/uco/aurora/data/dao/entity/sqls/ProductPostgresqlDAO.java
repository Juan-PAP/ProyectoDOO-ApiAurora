package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.ProductDAO;
import co.edu.uco.aurora.entity.ProductEntity;

import java.sql.Connection;
import java.util.List;

public class ProductPostgresqlDAO extends SqlConnection implements ProductDAO {

    protected ProductPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void crate(ProductEntity entity) {

    }

    @Override
    public List<ProductEntity> findAll() {
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
