package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.aurora.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.aurora.entity.AdministratorEntity;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class IdentificationTypeSqlServerDAO extends SqlConnection implements IdentificationTypeDAO {

    public IdentificationTypeSqlServerDAO(Connection connection) {
        super(connection);
    }

    private void mapResultSetToIdentificationType(final java.sql.ResultSet resultSet, final IdentificationTypeEntity entity) {

        try {
            entity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            entity.setName(resultSet.getString("tipoIdentificacion"));

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_MAPPING_A_IDENTIFICATION_TYPE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_MAPPING_IDENTIFICATION_TYPE.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_IDENTIFICATION_TYPE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_IDENTIFICATION_TYPE.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<IdentificationTypeEntity> findALL() {

        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<IdentificationTypeEntity> identificationTypes = new java.util.ArrayList<>();
        final var sql = new StringBuilder();

        sql.append("SELECT	   i.id, ");
        sql.append("           i.name, ");
        sql.append("FROM       TipoIdentificacion AS i ");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString());
             var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var identificationType = new  IdentificationTypeEntity();
                mapResultSetToIdentificationType(resultSet, identificationType);
                identificationTypes.add(identificationType);
            }

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_ALL_IDENTIFICATION_TYPE.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_ALL_IDENTIFICATION_TYPE.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_IDENTIFICATION_TYPE.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_IDENTIFICATION_TYPE.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
        return identificationTypes;

    }

    @Override
    public List<IdentificationTypeDAO> findByFilter(IdentificationTypeDAO filterEntity) {
        public List<UserEntity> findByFilter(UserEntity filterEntity) {
            SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

            final List<UserEntity> users = new java.util.ArrayList<>();

            final var sql = new StringBuilder();
            final var parameters = new java.util.ArrayList<Object>();

            sql.append("SELECT     u.id, ");
            sql.append("           ti.id AS idTipoIdentificacion, ");
            sql.append("           ti.nombre AS nombreTipoIdentificacion, ");
            sql.append("           u.numeroIdentificacion, ");
            sql.append("           u.primerNombre, ");
            sql.append("           u.segundoNombre, ");
            sql.append("           u.primerApellido, ");
            sql.append("           u.segundoApellido, ");
            sql.append("           c.id AS idCiudadResidencia, ");
            sql.append("           c.nombre AS nombreCiudadResidencia, ");
            sql.append("           d.id AS idDepartamentoCiudadResidencia, ");
            sql.append("           d.nombre AS nombreDepartamentoCiudadResidencia, ");
            sql.append("           p.id AS idPaisDepartamentoCiudadResidencia, ");
            sql.append("           p.nombre AS nombrePaisDepartamentoCiudadResidencia, ");
            sql.append("           u.correoElectronico, ");
            sql.append("           u.numeroTelefonoMovil, ");
            sql.append("           u.correoElectronicoConfirmado, ");
            sql.append("           u.numeroTelefonoMovilConfirmado ");
            sql.append("FROM       Usuario AS u ");
            sql.append("INNER JOIN TipoIdentificacion AS ti ");
            sql.append("ON         u.tipoIdentificacion = ti.id ");
            sql.append("INNER JOIN Ciudad AS c ");
            sql.append("ON         u.ciudadResidencia = c.id ");
            sql.append("INNER JOIN Departamento AS d ");
            sql.append("ON         c.departamento = d.id ");
            sql.append("INNER JOIN Pais AS p ");
            sql.append("ON         d.pais = p.id ");
            sql.append("WHERE 1=1 ");

            if (filterEntity.getId() != null && !UUIDHelper.getUUIDHelper().getDefault().equals(filterEntity.getId())) { // <-- CORRECCIÓN AQUÍ
                sql.append("AND u.id = ? ");
                parameters.add(filterEntity.getId());
            }
            if (filterEntity.getIdType() != null && filterEntity.getIdType().getId() != null && !UUIDHelper.getUUIDHelper().getDefault().equals(filterEntity.getIdType().getId())) { // <-- CORRECCIÓN AQUÍ
                sql.append("AND u.tipoIdentificacion = ? ");
                parameters.add(filterEntity.getIdType().getId());
            }
            if (filterEntity.getIdNumber() != null && !filterEntity.getIdNumber().trim().isEmpty()) {
                sql.append("AND u.numeroIdentificacion = ? ");
                parameters.add(filterEntity.getIdNumber());
            }
            if (filterEntity.getFirstName() != null && !filterEntity.getFirstName().trim().isEmpty()) {
                sql.append("AND u.primerNombre LIKE ? ");
                parameters.add("%" + filterEntity.getFirstName().trim() + "%");
            }
            if (filterEntity.getSecondName() != null && !filterEntity.getSecondName().trim().isEmpty()) {
                sql.append("AND u.segundoNombre LIKE ? ");
                parameters.add("%" + filterEntity.getSecondName().trim() + "%");
            }
            if (filterEntity.getFirstSurname() != null && !filterEntity.getFirstSurname().trim().isEmpty()) {
                sql.append("AND u.primerApellido LIKE ? ");
                parameters.add("%" + filterEntity.getFirstSurname().trim() + "%");
            }
            if (filterEntity.getSecondSurname() != null && !filterEntity.getSecondSurname().trim().isEmpty()) {
                sql.append("AND u.segundoApellido LIKE ? ");
                parameters.add("%" + filterEntity.getSecondSurname().trim() + "%");
            }
            if (filterEntity.getHomeCity() != null && filterEntity.getHomeCity().getId() != null && !UUIDHelper.getUUIDHelper().getDefault().equals(filterEntity.getHomeCity().getId())) { // <-- CORRECCIÓN AQUÍ
                sql.append("AND u.ciudadResidencia = ? ");
                parameters.add(filterEntity.getHomeCity().getId());
            }
            if (filterEntity.getEmail() != null && !filterEntity.getEmail().trim().isEmpty()) {
                sql.append("AND u.correoElectronico = ? ");
                parameters.add(filterEntity.getEmail());
            }
            if (filterEntity.getMobileNumber() != null && !filterEntity.getMobileNumber().trim().isEmpty()) {
                sql.append("AND u.numeroTelefonoMovil = ? ");
                parameters.add(filterEntity.getMobileNumber());
            }
            if (!filterEntity.isEmailConfirmedIsDefaultValue()) {
                sql.append("AND u.correoElectronicoConfirmado = ? ");
                parameters.add(filterEntity.isEmailConfirmed());
            }
            if (!filterEntity.isMobileNumberConfirmedIsDefualtValue()) {
                sql.append("AND u.numeroTelefonoMovilConfirmado = ? ");
                parameters.add(filterEntity.isMobileNumberConfirmed());
            }

            try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

                for (int i = 0; i < parameters.size(); i++) {
                    preparedStatement.setObject(i + 1, parameters.get(i));
                }

                try (var resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        var user = new UserEntity();
                        mapResultSetToUser(resultSet, user);
                        users.add(user);
                    }
                }

            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
                throw NoseException.create(exception, userMessage, technicalMessage);

            } catch (final Exception exception) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
                throw NoseException.create(exception, userMessage, technicalMessage);
            }

            return users;
        }

        return List.of();
    }

    @Override
    public IdentificationTypeDAO findById(UUID uuid) {
        return null;
    }
}