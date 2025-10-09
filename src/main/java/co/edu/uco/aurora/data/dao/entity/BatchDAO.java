package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.BatchEntity;

import java.util.UUID;

public interface BatchDAO extends CreateDAO<BatchEntity>, UpdateDAO<BatchEntity>, RetrieveDAO<BatchEntity, UUID> {

}
