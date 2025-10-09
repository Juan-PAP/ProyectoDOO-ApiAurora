package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.entity.SaleEntity;

import java.util.UUID;

public interface SaleDAO extends CreateDAO<SaleEntity>, RetrieveDAO<SaleEntity, UUID> {

}
