package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.util.UUID;

public interface IdentificationTypeDAO extends CreateDAO<IdentificationTypeEntity>, UpdateDAO<IdentificationTypeEntity>, RetrieveDAO<IdentificationTypeDAO, UUID> {

}
