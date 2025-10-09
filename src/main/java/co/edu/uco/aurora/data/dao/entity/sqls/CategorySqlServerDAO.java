package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.data.dao.entity.CategoryDAO;
import co.edu.uco.aurora.entity.CategoryEntity;

import java.util.List;
import java.util.UUID;

public class CategorySqlServerDAO implements CategoryDAO {
    @Override
    public void crate(CategoryEntity entity) {

    }

    @Override
    public List<CategoryEntity> findALL() {
        return List.of();
    }

    @Override
    public List<CategoryEntity> findByFilter(CategoryEntity filterEntity) {
        return List.of();
    }

    @Override
    public CategoryEntity findById(UUID uuid) {
        return null;
    }

    @Override
    public void update(CategoryEntity entity) {

    }
}
