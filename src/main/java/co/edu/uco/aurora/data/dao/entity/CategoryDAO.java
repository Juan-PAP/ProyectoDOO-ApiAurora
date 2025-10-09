package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.CategoryEntity;

import java.util.UUID;

public interface CategoryDAO extends CreateDAO<CategoryEntity>, UpdateDAO<CategoryEntity>, RetrieveDAO<CategoryEntity, UUID> {

}
