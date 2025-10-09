package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.AdministratorDAO;
import co.edu.uco.aurora.entity.AdministratorEntity;

import java.util.List;
import java.util.UUID;

public class AdministratorSqlServerDAO implements AdministratorDAO {
    @Override
    public void crate(AdministratorEntity entity) {
        
    }

    @Override
    public List<AdministratorEntity> findALL() {
        return List.of();
    }

    @Override
    public List<AdministratorEntity> findByFilter(AdministratorEntity filterEntity) {
        return List.of();
    }

    @Override
    public AdministratorEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(AdministratorEntity entity) {

    }
}
