package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.CategoryDAO;
import co.edu.uco.aurora.entity.CategoryEntity;

import java.sql.Connection;
import java.util.List;

public class CategoryPostgresqlDAO extends SqlConnection implements CategoryDAO {

    protected CategoryPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void crate(CategoryEntity entity) {

    }

    @Override
    public List<CategoryEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CategoryEntity> findByFilter(CategoryEntity filterEntity) {
        return List.of();
    }

    @Override
    public void update(CategoryEntity entity) {

    }
}
