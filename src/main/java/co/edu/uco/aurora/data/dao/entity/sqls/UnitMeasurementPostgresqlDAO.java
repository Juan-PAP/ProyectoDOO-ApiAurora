package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumUnitMeasurementDAO;
import co.edu.uco.aurora.data.dao.entity.UnitMeasurementDAO;
import co.edu.uco.aurora.entity.UnitMeasurementEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class UnitMeasurementPostgresqlDAO extends SqlConnection implements UnitMeasurementDAO {

    public UnitMeasurementPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<UnitMeasurementEntity> findAll() {
        return findByFilter(new UnitMeasurementEntity());
    }

    @Override
    public List<UnitMeasurementEntity> findByFilter(final UnitMeasurementEntity filterEntity) {
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
            var userMessage = MessagesEnumUnitMeasurementDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNITMEASUREMENT.getContent();
            var technicalMessage = MessagesEnumUnitMeasurementDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNITMEASUREMENT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnumUnitMeasurementDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNITMEASUREMENT.getContent();
            var technicalMessage = MessagesEnumUnitMeasurementDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNITMEASUREMENT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final UnitMeasurementEntity filterEntity, final List<Object> parameterList) {

        final var sql = new StringBuilder("SELECT UM.id, UM.nombre FROM UnidadMedida UM ");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        sql.append(" ORDER BY UM.nombre ASC");

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final UnitMeasurementEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UnitMeasurementEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "UM.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "UM.nombre = ?", filterEntityValidated.getName());

        if (!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parameterList, final boolean condition,
                              final String clause, final Object value) {
        if (condition) {
            conditions.add(clause);
            parameterList.add(value);
        }
    }

    private List<UnitMeasurementEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listUnitMeasurement = new ArrayList<UnitMeasurementEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var unitMeasurement = new UnitMeasurementEntity();

                unitMeasurement.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                unitMeasurement.setName(resultSet.getString("nombre"));

                listUnitMeasurement.add(unitMeasurement);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumUnitMeasurementDAO.USER_ERROR_SQL_MAPPING_UNITMEASUREMENT.getContent();
            var technicalMessage = MessagesEnumUnitMeasurementDAO.TECHNICAL_ERROR_SQL_MAPPING_UNITMEASUREMENT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (Exception exception) {
            var userMessage = MessagesEnumUnitMeasurementDAO.USER_ERROR_SQL_UNEXPECTED_MAPPING_UNITMEASUREMENT.getContent();
            var technicalMessage = MessagesEnumUnitMeasurementDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_UNITMEASUREMENT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
        return listUnitMeasurement;
    }
}