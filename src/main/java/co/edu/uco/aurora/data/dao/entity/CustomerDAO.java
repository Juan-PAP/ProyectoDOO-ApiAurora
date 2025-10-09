package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.CustomerEntity;

import java.util.UUID;

public interface CustomerDAO extends CreateDAO<CustomerEntity>, UpdateDAO<CustomerEntity>, RetrieveDAO<CustomerEntity, UUID> {

}
