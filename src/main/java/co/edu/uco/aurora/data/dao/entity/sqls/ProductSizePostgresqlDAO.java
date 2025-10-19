package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.ProductoSizeDAO;

import java.sql.Connection;
import java.util.List;

public class ProductSizePostgresqlDAO extends SqlConnection implements ProductoSizeDAO {

    protected ProductSizePostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<ProductoSizeDAO> findAll() {
        return List.of();
    }

    @Override
    public List<ProductoSizeDAO> findByFilter(ProductoSizeDAO filterEntity) {
        return List.of();
    }
}
