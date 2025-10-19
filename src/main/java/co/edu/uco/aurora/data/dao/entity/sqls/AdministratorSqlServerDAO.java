package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.aurora.data.dao.entity.AdministratorDAO;
import co.edu.uco.aurora.entity.AdministratorEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public final class AdministratorSqlServerDAO extends SqlConnection implements AdministratorDAO {

    public AdministratorSqlServerDAO(Connection connection) {
        super(connection);
    }

    private void mapResultSetToAdministrator(final java.sql.ResultSet resultSet, final AdministratorEntity entity) {
        try {
            entity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            entity.setUser(resultSet.getString("nombre"));
            entity.setPassword(resultSet.getString("contraseña"));
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_MAPPING_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_MAPPING_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void crate(final AdministratorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Administrador (id, usuario, contraseña");
        sql.append("SELECT ?, ?, ?");
        try(var preparedStatement = this.getConnection().prepareStatement(sql.toString())){
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getUser());
            preparedStatement.setString(3, entity.getPassword());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_INSERT_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_INSERT_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {

            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }
    @Override
    public List<AdministratorEntity> findALL() {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<AdministratorEntity> administrators = new java.util.ArrayList<>();
        final var sql = new StringBuilder();

        sql.append("SELECT      a.id, ");
        sql.append("            a.usuario ");
        sql.append("            a.contrasenia");
        sql.append("FROM        Administrador AS a");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString());
             var resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                var administrator = new AdministratorEntity();
                mapResultSetToAdministrator(resultSet, administrator);
                administrators.add(administrator);
            }

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_ALL_ADMINISTRATOR.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_ALL_ADMINISTRATOR.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_ADMINISTRATOR.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_ADMINISTRATOR.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
        return administrators;
    }

    @Override
    public List<AdministratorEntity> findByFilter(AdministratorEntity filterEntity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<AdministratorEntity> administrators = new java.util.ArrayList<>();

        final var sql = new StringBuilder();
        final var parameters = new java.util.ArrayList<Object>();

        sql.append("SELECT     a.id, ");
        sql.append("           a.usuario, ");
        sql.append("           a.contrasenia, ");
        sql.append("           u.numeroIdentificacion, ");
        sql.append("FROM       Administrador AS a ");
        sql.append("WHERE 1=1 ");

        if (filterEntity.getId() != null && !UUIDHelper.getUUIDHelper().getDefault().equals(filterEntity.getId())) { // <-- CORRECCIÓN AQUÍ
            sql.append("AND a.id = ? ");
            parameters.add(filterEntity.getId());
        }
        if (filterEntity.getUser() != null && !filterEntity.getUser().trim().isEmpty()) {
            sql.append("AND a.usuario LIKE ? ");
            parameters.add("%" + filterEntity.getUser().trim() + "%");
        }
        if (filterEntity.getPassword() != null && !filterEntity.getPassword().trim().isEmpty()) {
            sql.append("AND u.segundoNombre LIKE ? ");
            parameters.add("%" + filterEntity.getPassword().trim() + "%");
        }

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            try (var resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var administrator = new AdministratorEntity();
                    mapResultSetToAdministrator(resultSet, administrator);
                    administrators.add(administrator);
                }
            }

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_USER.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return administrators;
    }

    @Override
    public void update(AdministratorEntity entity) {

    }
}