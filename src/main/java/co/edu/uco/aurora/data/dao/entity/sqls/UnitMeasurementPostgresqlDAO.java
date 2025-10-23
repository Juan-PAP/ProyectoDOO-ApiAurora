package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.UnitMeasurementDAO;

import java.sql.Connection;
import java.util.List;

public final class UnitMeasurementPostgresqlDAO extends SqlConnection implements UnitMeasurementDAO {

    public UnitMeasurementPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<UnitMeasurementDAO> findAll() {
        return List.of();
    }

    @Override
    public List<UnitMeasurementDAO> findByFilter(UnitMeasurementDAO filterEntity) {
        return List.of();
    }
}
