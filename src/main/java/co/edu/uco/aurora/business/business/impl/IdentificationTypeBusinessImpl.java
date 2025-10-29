package co.edu.uco.aurora.business.business.impl;

import co.edu.uco.aurora.business.assembler.entity.impl.IdentificationTypeEntityAssembler;
import co.edu.uco.aurora.business.business.IdentificationTypeBusiness;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.util.ArrayList;
import java.util.List;

public class IdentificationTypeBusinessImpl implements IdentificationTypeBusiness {

    private final DAOFactory daoFactory;

    public IdentificationTypeBusinessImpl(final DAOFactory factory) {
        this.daoFactory = factory;
    }
    @Override
    public List<IdentificationTypeDomain> getIdentificationTypeByFilter(IdentificationTypeDomain identificationType) {
        return List.of();
    }

    @Override
    public List<IdentificationTypeDomain> getAllIdentificationType() {

        final List<IdentificationTypeEntity> entityList = daoFactory.getIdentificationTypeDAO().findAll();

        final List<IdentificationTypeDomain> domainList = new ArrayList<>();

        for (final IdentificationTypeEntity entity : entityList) {
            domainList.add(IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler().toDomain(entity));
        }

        return domainList;
    }

    @Override
    public IdentificationTypeDomain getIdentificationTypeById(IdentificationTypeDomain identificationType) {
        return null;
    }
}
