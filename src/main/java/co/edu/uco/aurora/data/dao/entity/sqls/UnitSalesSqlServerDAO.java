package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.UnitSalesDAO;
import co.edu.uco.aurora.entity.UnitSalesEntity;

import java.util.List;
import java.util.UUID;

public class UnitSalesSqlServerDAO implements UnitSalesDAO {
    @Override
    public List<UnitSalesEntity> findALL() {
        return List.of();
    }

    @Override
    public List<UnitSalesEntity> findByFilter(UnitSalesEntity filterEntity) {
        return List.of();
    }

    @Override
    public UnitSalesEntity findById(UUID uuid) {
        return null;
    }
}
