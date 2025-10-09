package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.SaleDAO;
import co.edu.uco.aurora.entity.SaleEntity;

import java.util.List;
import java.util.UUID;

public class SaleSqlServerDAO implements SaleDAO {
    @Override
    public void crate(SaleEntity entity) {

    }

    @Override
    public List<SaleEntity> findALL() {
        return List.of();
    }

    @Override
    public List<SaleEntity> findByFilter(SaleEntity filterEntity) {
        return List.of();
    }

    @Override
    public SaleEntity findById(UUID uuid) {
        return null;
    }
}
