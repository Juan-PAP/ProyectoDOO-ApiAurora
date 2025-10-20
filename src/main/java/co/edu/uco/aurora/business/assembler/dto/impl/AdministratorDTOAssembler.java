package co.edu.uco.aurora.business.assembler.dto.impl;

import co.edu.uco.aurora.business.assembler.dto.DTOAssembler;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.dto.AdministratorDTO;

import java.util.ArrayList;
import java.util.List;

public final class AdministratorDTOAssembler implements DTOAssembler<AdministratorDTO, AdministratorDomain> {

    private static final DTOAssembler<AdministratorDTO, AdministratorDomain> instance =
            new AdministratorDTOAssembler();

    private AdministratorDTOAssembler() {

    }

    public static DTOAssembler<AdministratorDTO, AdministratorDomain> getAdministratorDTOAssembler() {
        return instance;
    }

    @Override
    public AdministratorDTO toDTO(final AdministratorDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new AdministratorDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new AdministratorDTO(domainTmp.getId(), domainTmp.getUser(), domainTmp.getPassword());
    }

    @Override
    public AdministratorDomain toDomain(final AdministratorDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new AdministratorDTO());
        return new AdministratorDomain(dtoTmp.getId(), dtoTmp.getUser(),dtoTmp.getPassword());
    }

    @Override
    public List<AdministratorDTO> toDTO(final List<AdministratorDomain> domainList) {

        if (ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var administradorDtoList = new ArrayList<AdministratorDTO>();

        for (var administratorDomain : domainList) {
            administradorDtoList.add(toDTO(administratorDomain));
        }

        return administradorDtoList;
    }
}
