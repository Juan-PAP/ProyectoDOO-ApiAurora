package co.edu.uco.aurora.data.dao;

import co.edu.uco.aurora.entity.AdministratorEntity;

import java.util.List;

public interface LoginDAO <Username> {

    List<AdministratorEntity> findByUsername(Username username);
}
