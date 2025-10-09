package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.BrandDAO;
import co.edu.uco.aurora.entity.BrandEntity;

import java.util.List;
import java.util.UUID;

public class BrandSqlServerDAO implements BrandDAO {
    @Override
    public void crate(BrandEntity entity) {

    }

    @Override
    public List<BrandEntity> findALL() {
        return List.of();
    }

    @Override
    public List<BrandEntity> findByFilter(BrandEntity filterEntity) {
        return List.of();
    }

    @Override
    public BrandEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(BrandEntity entity) {

    }
}
