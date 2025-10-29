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

        // Se obtiene la lista de entidades desde la capa de datos por una consulta
        final List<IdentificationTypeEntity> entityList = daoFactory.getIdentificationTypeDAO().findAll();

        // Se convierte la lista de entidades a una lista de dominios
        final List<IdentificationTypeDomain> domainList = new ArrayList<>();

        // Se itera sobre cada entidad y convertirla a dominio
        for (final IdentificationTypeEntity entity : entityList) {
            domainList.add(IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler().toDomain(entity));
        }

        // Se retorna la lista de dominios
        return domainList;
    }

    @Override
    public IdentificationTypeDomain getIdentificationTypeById(IdentificationTypeDomain identificationType) {
        return null;
    }
}
