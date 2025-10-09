package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.DeleteDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.SaleProductBrandEntity;

import java.util.UUID;

public interface SaleProductBrandDAO extends CreateDAO<SaleProductBrandEntity>, UpdateDAO<SaleProductBrandEntity>
        , DeleteDAO<UUID> {

}
