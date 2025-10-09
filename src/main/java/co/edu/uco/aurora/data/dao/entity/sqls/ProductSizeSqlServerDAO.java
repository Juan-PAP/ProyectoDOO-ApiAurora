package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.ProductoSizeDAO;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ProductSizeSqlServerDAO extends SqlConnection implements ProductoSizeDAO {

    protected ProductSizeSqlServerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<ProductoSizeDAO> findALL() {
        return List.of();
    }

    @Override
    public List<ProductoSizeDAO> findByFilter(ProductoSizeDAO filterEntity) {
        return List.of();
    }

    @Override
    public ProductoSizeDAO findById(UUID uuid) {
        return null;
    }
}
