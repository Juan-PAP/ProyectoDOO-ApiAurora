package co.edu.uco.aurora.business.business;

import co.edu.uco.aurora.business.domain.AdministratorDomain;

import java.util.List;
import java.util.UUID;

public interface AdministratorBusiness {

    void registerNewAdministrator (AdministratorDomain administrator);

    void updateAdministratorInformation (UUID id, AdministratorDomain administrator);

    void login (AdministratorDomain administrator);

    List<AdministratorDomain> getAdministratorByFilter(AdministratorDomain administrator);

    List<AdministratorDomain> getAllAdministrator();

}
