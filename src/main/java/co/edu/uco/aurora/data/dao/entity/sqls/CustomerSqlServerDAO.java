package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.CustomerDAO;
import co.edu.uco.aurora.entity.CustomerEntity;

import java.util.List;
import java.util.UUID;

public class CustomerSqlServerDAO implements CustomerDAO {
    @Override
    public void crate(CustomerEntity entity) {

    }

    @Override
    public List<CustomerEntity> findALL() {
        return List.of();
    }

    @Override
    public List<CustomerEntity> findByFilter(CustomerEntity filterEntity) {
        return List.of();
    }

    @Override
    public CustomerEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(CustomerEntity entity) {

    }
}
