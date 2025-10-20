package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumAdministratorDAO;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumIdentificationTypeDAO;
import co.edu.uco.aurora.data.dao.entity.AdministratorDAO;
import co.edu.uco.aurora.entity.AdministratorEntity;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class AdministratorPostgresqlDAO extends SqlConnection implements AdministratorDAO {

    public AdministratorPostgresqlDAO(Connection connection) {
        super(connection);
    }

    /*private void mapResultSetToAdministrator(final java.sql.ResultSet resultSet, final AdministratorEntity entity) {
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
    }*/

    @Override
    public void create(final AdministratorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Administrador (id, usuario, contraseña) ");
        sql.append("SELECT ?, ?, ?");
        try(var preparedStatement = this.getConnection().prepareStatement(sql.toString())){
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getUser());
            preparedStatement.setString(3, entity.getPassword());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_INSERT_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_INSERT_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {

            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }
    @Override
    public List<AdministratorEntity> findAll() { return findByFilter(new AdministratorEntity());
    }

    @Override
    public List<AdministratorEntity> findByFilter(AdministratorEntity filterEntity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        var parameterList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (int i = 0; i < parameterList.size(); i++) {
                preparedStatement.setObject(i + 1, parameterList.get(i));
            }

            return executeSentenceFindByFilter(preparedStatement);
        } catch (final AuroraException exception) {
            throw exception;

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_ADMINISTRATOR.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        }catch (final Exception exception) {
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter (final AdministratorEntity filterEntity, final List<Object> parameterList) {

        final var sql = new StringBuilder("SELECT A.idAdministrador, A.usuario, A.contrasenia FROM Administrador A");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final AdministratorEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new AdministratorEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "A.idAdministrador = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getUser()),
                "A.usuario = ?", filterEntityValidated.getUser());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getPassword()),
                "A.contrasenia = ?", filterEntityValidated.getPassword());


        if (!conditions.isEmpty()){
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parameterList, final boolean codition,
                              final String clause, final Object value) {
        if (codition) {
            conditions.add(clause);
            parameterList.add(value);
        }
    }

    private List<AdministratorEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listAdmin = new ArrayList<AdministratorEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var idAdmin = new AdministratorEntity();

                idAdmin.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idAdministrador")));
                idAdmin.setUser(resultSet.getString("usuario"));
                idAdmin.setPassword(resultSet.getString("contrasenia"));

                listAdmin.add(idAdmin);
            }

        }  catch (SQLException exception) {
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_MAPPING_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_MAPPING_ADMINISTRATOR.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception){
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_ADMINISTRATOR.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listAdmin;
    }

    @Override
    public void update(AdministratorEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE Administrador SET usuario = ?, contrasenia = ? ");
        sql.append("WHERE idAdministrador = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setString(1, entity.getUser());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setObject(3, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_UPDATE_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_UPDATE_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumAdministratorDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_ADMINISTRATOR.getContent();
            var technicalMessage = MessagesEnumAdministratorDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_ADMINISTRATOR.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }
}