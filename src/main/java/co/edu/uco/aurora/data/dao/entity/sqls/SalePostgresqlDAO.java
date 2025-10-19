package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.SaleDAO;
import co.edu.uco.aurora.entity.SaleEntity;

import java.sql.Connection;
import java.util.List;

public class SalePostgresqlDAO extends SqlConnection implements SaleDAO {

    protected SalePostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(SaleEntity entity) {

    }

    @Override
    public List<SaleEntity> findAll() {
        return List.of();
    }

    @Override
    public List<SaleEntity> findByFilter(SaleEntity filterEntity) {
        return List.of();
    }
}
