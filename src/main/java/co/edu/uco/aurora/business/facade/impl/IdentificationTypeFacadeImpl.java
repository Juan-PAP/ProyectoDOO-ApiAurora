package co.edu.uco.aurora.business.facade.impl;

import co.edu.uco.aurora.business.facade.IdentificationTypeFacade;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;

import java.util.List;

public class IdentificationTypeFacadeImpl implements IdentificationTypeFacade {
    @Override
    public List<IdentificationTypeDTO> getIdentificationTypeByFilter(IdentificationTypeDTO identificationType) {
        return List.of();
    }

    @Override
    public List<IdentificationTypeDTO> getAllIdentificationType() {
        return List.of();
    }

    @Override
    public IdentificationTypeDTO getIdentificationTypeById(IdentificationTypeDTO identificationType) {
        return null;
    }
}
