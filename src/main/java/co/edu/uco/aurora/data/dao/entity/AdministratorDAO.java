package co.edu.uco.aurora.data.dao.entity;

import co.edu.uco.aurora.data.dao.CreateDAO;
import co.edu.uco.aurora.data.dao.LoginDAO;
import co.edu.uco.aurora.data.dao.RetrieveDAO;
import co.edu.uco.aurora.data.dao.UpdateDAO;
import co.edu.uco.aurora.entity.AdministratorEntity;

import java.util.UUID;

public interface AdministratorDAO extends CreateDAO <AdministratorEntity>, UpdateDAO <AdministratorEntity>,
        RetrieveDAO <AdministratorEntity, UUID>, LoginDAO<String> {

}