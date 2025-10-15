package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.UnitSalesDAO;
import co.edu.uco.aurora.entity.UnitSalesEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class UnitSalesSqlServerDAO extends SqlConnection implements UnitSalesDAO {

    protected UnitSalesSqlServerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<UnitSalesEntity> findALL() {
        return List.of();
    }

    @Override
    public List<UnitSalesEntity> findByFilter(UnitSalesEntity filterEntity) {
        return List.of();
    }
}