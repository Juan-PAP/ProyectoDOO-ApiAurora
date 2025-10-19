package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.CustomerDAO;
import co.edu.uco.aurora.entity.CustomerEntity;

import java.sql.Connection;
import java.util.List;

public class CustomerPostgresqlDAO extends SqlConnection implements CustomerDAO {

    protected CustomerPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(CustomerEntity entity) {

    }

    @Override
    public List<CustomerEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CustomerEntity> findByFilter(CustomerEntity filterEntity) {
        return List.of();
    }

    @Override
    public void update(CustomerEntity entity) {

    }
}
