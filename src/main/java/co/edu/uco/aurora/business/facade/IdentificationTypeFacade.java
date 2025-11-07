package co.edu.uco.aurora.business.facade;

import co.edu.uco.aurora.dto.IdentificationTypeDTO;

import java.util.List;

public interface IdentificationTypeFacade {

    List<IdentificationTypeDTO> getIdentificationTypeByFilter(IdentificationTypeDTO identificationType);

    List<IdentificationTypeDTO> getAllIdentificationType();

    IdentificationTypeDTO getIdentificationTypeById(IdentificationTypeDTO identificationType);


}
