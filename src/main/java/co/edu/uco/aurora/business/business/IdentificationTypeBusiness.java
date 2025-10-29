package co.edu.uco.aurora.business.business;

import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.util.List;

public interface IdentificationTypeBusiness {

    List<IdentificationTypeDomain> getIdentificationTypeByFilter(IdentificationTypeDomain identificationType);

    List<IdentificationTypeDomain> getAllIdentificationType();

    IdentificationTypeDomain getIdentificationTypeById(IdentificationTypeEntity identificationType);

}
