package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.BatchDAO;
import co.edu.uco.aurora.entity.BatchEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class BatchSqlServerDAO extends SqlConnection implements BatchDAO {

    protected BatchSqlServerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void crate(BatchEntity entity) {

    }

    @Override
    public List<BatchEntity> findALL() {
        return List.of();
    }

    @Override
    public List<BatchEntity> findByFilter(BatchEntity filterEntity) {
        return List.of();
    }

    @Override
    public BatchEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(BatchEntity entity) {

    }
}
