package co.edu.uco.aurora.business.business.impl;

import co.edu.uco.aurora.business.business.AdministratorBusiness;
import co.edu.uco.aurora.business.business.rule.validator.administrator.ValidateAdministratorLogin;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public final class AdministratorBusinessImpl implements AdministratorBusiness {

    private final DAOFactory daoFactory;

    public AdministratorBusinessImpl(final DAOFactory factory) {
        this.daoFactory = factory;
    }

    @Override
    public void registerNewAdministrator(final AdministratorDomain administrator) {

    }

    @Override
    public void updateAdministratorInformation(final UUID id, final AdministratorDomain administrator) {

    }

    @Override
    public void login(final AdministratorDomain administratorDomain) {
        // Orquestador único de login
        ValidateAdministratorLogin.executeValidation(administratorDomain, daoFactory);
    }

    @Override
    public List<AdministratorDomain> getAdministratorByFilter(final AdministratorDomain administrator) {
        return List.of();
    }

    @Override
    public List<AdministratorDomain> getAllAdministrator() {
        return List.of();
    }
}