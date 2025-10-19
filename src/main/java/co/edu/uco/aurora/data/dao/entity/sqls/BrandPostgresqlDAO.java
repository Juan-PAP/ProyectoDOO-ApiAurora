package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.BrandDAO;
import co.edu.uco.aurora.entity.BrandEntity;

import java.sql.Connection;
import java.util.List;

public class BrandPostgresqlDAO extends SqlConnection implements BrandDAO {

    protected BrandPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(BrandEntity entity) {

    }

    @Override
    public List<BrandEntity> findAll() {
        return List.of();
    }

    @Override
    public List<BrandEntity> findByFilter(BrandEntity filterEntity) {
        return List.of();
    }

    @Override
    public void update(BrandEntity entity) {

    }
}
