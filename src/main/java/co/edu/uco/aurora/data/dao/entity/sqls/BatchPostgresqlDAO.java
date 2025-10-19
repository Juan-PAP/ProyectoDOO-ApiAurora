package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.BatchDAO;
import co.edu.uco.aurora.entity.BatchEntity;

import java.sql.Connection;
import java.util.List;

public class BatchPostgresqlDAO extends SqlConnection implements BatchDAO {

    protected BatchPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void crate(BatchEntity entity) {

    }

    @Override
    public List<BatchEntity> findAll() {
        return List.of();
    }

    @Override
    public List<BatchEntity> findByFilter(BatchEntity filterEntity) {
        return List.of();
    }

    @Override
    public void update(BatchEntity entity) {

    }
}
