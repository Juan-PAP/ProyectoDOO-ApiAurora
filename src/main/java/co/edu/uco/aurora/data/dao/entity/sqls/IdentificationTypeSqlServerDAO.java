package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.IdentificationTypeDAO;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class IdentificationTypeSqlServerDAO extends SqlConnection implements IdentificationTypeDAO {

    protected IdentificationTypeSqlServerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IdentificationTypeDAO> findALL() {
        return List.of();
    }

    @Override
    public List<IdentificationTypeDAO> findByFilter(IdentificationTypeDAO filterEntity) {
        return List.of();
    }

    @Override
    public IdentificationTypeDAO findById(UUID uuid) {
        return null;
    }
}
