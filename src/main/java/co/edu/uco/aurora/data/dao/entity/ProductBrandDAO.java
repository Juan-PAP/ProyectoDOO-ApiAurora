package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.ProductBrandEntity;

import java.util.UUID;

public interface ProductBrandDAO extends CreateDAO<ProductBrandEntity>, UpdateDAO<ProductBrandEntity>,
        RetrieveDAO<ProductBrandEntity, UUID> {

}
