package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.SaleProductBrandDAO;
import co.edu.uco.aurora.entity.SaleProductBrandEntity;

import java.sql.Connection;
import java.util.UUID;

public class SaleProductBrandPostgresqlDAO extends SqlConnection implements SaleProductBrandDAO {

    protected SaleProductBrandPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(SaleProductBrandEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public void update(SaleProductBrandEntity entity) {

    }
}
