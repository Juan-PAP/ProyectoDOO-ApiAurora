package co.edu.uco.aurora.business.facade;

import co.edu.uco.aurora.dto.AdministratorDTO;

import java.util.List;
import java.util.UUID;

public interface AdministratorFacade {

    void registerNewAdministrator (AdministratorDTO administrator);

    void updateAdministratorInformation (UUID id, AdministratorDTO administrator);

    void login (AdministratorDTO administrator);

    List<AdministratorDTO> getAdministratorByFilter(AdministratorDTO administrator);

    List<AdministratorDTO> getAllAdministrator();

}
