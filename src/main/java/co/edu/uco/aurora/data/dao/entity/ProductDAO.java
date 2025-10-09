package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.ProductEntity;

import java.util.UUID;

public interface ProductDAO extends CreateDAO<ProductEntity>, UpdateDAO<ProductEntity>, RetrieveDAO<ProductEntity, UUID> {

}
