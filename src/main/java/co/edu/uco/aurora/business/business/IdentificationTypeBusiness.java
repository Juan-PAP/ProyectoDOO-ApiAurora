package co.edu.uco.aurora.business.business;

import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;

import java.util.List;

public interface IdentificationTypeBusiness {

    List<IdentificationTypeDomain> getIdentificationTypeByFilter(IdentificationTypeDomain identificationType);

    List<IdentificationTypeDomain> getAllIdentificationType();

    IdentificationTypeDomain getIdentificationTypeById(IdentificationTypeDomain identificationType);

}
