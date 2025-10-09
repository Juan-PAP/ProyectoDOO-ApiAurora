package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.IdentificationTypeDAO;

import java.util.List;
import java.util.UUID;

public class IdentificationTypeSqlServerDAO implements IdentificationTypeDAO {
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
