package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumCustomerDAO;
import co.edu.uco.aurora.data.dao.entity.CustomerDAO;
import co.edu.uco.aurora.entity.CustomerEntity;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class CustomerPostgresqlDAO extends SqlConnection implements CustomerDAO {

    public CustomerPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final CustomerEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Cliente (id, idTipoIdentificacion, numeroIdentificacion, nombreCompleto, ");
        sql.append("numeroTelefono, numeroTelefonoConfirmado, fechaNacimiento) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdentificationType().getId());
            preparedStatement.setString(3, entity.getIdentificationNumber());
            preparedStatement.setString(4, entity.getFullName());
            preparedStatement.setString(5, entity.getPhoneNumber());
            preparedStatement.setBoolean(6, entity.isPhoneNumberConfirmed());
            preparedStatement.setObject(7, entity.getBirthDate());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_INSERT_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_INSERT_CUSTOMER.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CUSTOMER.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<CustomerEntity> findAll() {

        return findByFilter(new CustomerEntity());
    }


    @Override
    public List<CustomerEntity> findByFilter(final CustomerEntity filterEntity) {
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
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CUSTOMER.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_CUSTOMER.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter (final CustomerEntity filterEntity, final List<Object> parameterList) {
        final var sql = new StringBuilder();

        sql.append("SELECT C.id, C.numeroIdentificacion, C.nombreCompleto, C.numeroTelefono, C.numeroTelefonoConfirmado, C.fechaNacimiento, ");
        sql.append("TI.id AS idTipoIdentificacion, TI.nombre AS nombreTipoIdentificacion ");
        sql.append("FROM Cliente C ");
        sql.append("INNER JOIN TipoIdentificacion TI ON C.idTipoIdentificacion = TI.id");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        sql.append(" ORDER BY C.nombreCompleto ASC");

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final CustomerEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CustomerEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "C.id = ?", filterEntityValidated.getId());

        var identificationTypeFilter = ObjectHelper.getDefault(
                filterEntityValidated.getIdentificationType(),
                IdentificationTypeEntity.createDefault()
        );

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(identificationTypeFilter.getId()),
                "C.idTipoIdentificacion = ?", identificationTypeFilter.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getIdentificationNumber()),
                "C.numeroIdentificacion = ?", filterEntityValidated.getIdentificationNumber());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getFullName()),
                "C.nombreCompleto = ?", filterEntityValidated.getFullName());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getPhoneNumber()),
                "C.numeroTelefono = ?", filterEntityValidated.getPhoneNumber());

        addCondition(conditions, parameterList,
                !filterEntityValidated.isPhoneNumberIsConfirmedDefualtValue(),
                "C.numeroTelefonoConfirmado = ?", filterEntityValidated.isPhoneNumberConfirmed());

        var defaultBirthDate = LocalDateHelper.getDefault();
        addCondition(conditions, parameterList,
                !ObjectHelper.getDefault(filterEntityValidated.getBirthDate(), defaultBirthDate).equals(defaultBirthDate),
                "C.fechaNacimiento = ?", filterEntityValidated.getBirthDate());

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

    private List<CustomerEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listCustomers = new ArrayList<CustomerEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                var identificationType = new IdentificationTypeEntity();
                identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
                identificationType.setName(resultSet.getString("nombreTipoIdentificacion"));

                var customer = new CustomerEntity();

                customer.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                customer.setIdentificationType(identificationType);
                customer.setIdentificationNumber(resultSet.getString("numeroIdentificacion"));
                customer.setFullName(resultSet.getString("nombreCompleto"));
                customer.setPhoneNumber(resultSet.getString("numeroTelefono"));
                customer.setPhoneNumberConfirmed(resultSet.getBoolean("numeroTelefonoConfirmado"));
                customer.setBirthDate(resultSet.getObject("fechaNacimiento", java.time.LocalDate.class));

                listCustomers.add(customer);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_MAPPING_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_MAPPING_CUSTOMER.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_CUSTOMER.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listCustomers;
    }


    @Override
    public void update(final CustomerEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE Cliente SET idTipoIdentificacion = ?, numeroIdentificacion = ?, nombreCompleto = ?, ");
        sql.append("numeroTelefono = ?, numeroTelefonoConfirmado = ?, fechaNacimiento = ? ");
        sql.append("WHERE id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getIdentificationType().getId());
            preparedStatement.setString(2, entity.getIdentificationNumber());
            preparedStatement.setString(3, entity.getFullName());
            preparedStatement.setString(4, entity.getPhoneNumber());
            preparedStatement.setBoolean(5, entity.isPhoneNumberConfirmed());
            preparedStatement.setObject(6, entity.getBirthDate());
            preparedStatement.setObject(7, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_UPDATE_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_UPDATE_CUSTOMER.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumCustomerDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CUSTOMER.getContent();
            var technicalMessage = MessagesEnumCustomerDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CUSTOMER.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }
}