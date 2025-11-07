package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumUnitSalesDAO;
import co.edu.uco.aurora.data.dao.entity.UnitSalesDAO;
import co.edu.uco.aurora.entity.UnitSalesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class UnitSalesPostgresqlDAO extends SqlConnection implements UnitSalesDAO {

    public UnitSalesPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<UnitSalesEntity> findAll() {
        return findByFilter(new UnitSalesEntity());
    }

    @Override
    public List<UnitSalesEntity> findByFilter(final UnitSalesEntity filterEntity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        var parameterList = new ArrayList<>();
        var sql = createSentenceFindByFilter(filterEntity, parameterList);

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            for (int i = 0; i < parameterList.size(); i++) {
                preparedStatement.setObject(i + 1, parameterList.get(i));
            }

            return executeSentenceFindByFilter(preparedStatement);
        } catch (final AuroraException exception) {
            throw exception;

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumUnitSalesDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNIT_SALES.getContent();
            var technicalMessage = MessagesEnumUnitSalesDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNIT_SALES.getContent() + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumUnitSalesDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNIT_SALES.getContent();
            var technicalMessage = MessagesEnumUnitSalesDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNIT_SALES.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public UnitSalesEntity findById(UUID id) {
        return findByFilter(new UnitSalesEntity(id))
                .stream()
                .findFirst()
                .orElse(new UnitSalesEntity());
    }

    private String createSentenceFindByFilter (final UnitSalesEntity filterEntity, final List<Object> parameterList) {
        // Asumiendo que la tabla se llama 'UnidadMedida' basado en el nombre de la columna.
        final var sql = new StringBuilder("SELECT U.idUnitSale, U.unidadMedida FROM UnidadMedida U");
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final UnitSalesEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UnitSalesEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "U.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "U.unidadMedida = ?", filterEntityValidated.getName());

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

    private List<UnitSalesEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listUnits = new ArrayList<UnitSalesEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var unitEntity = new UnitSalesEntity();

                unitEntity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                unitEntity.setName(resultSet.getString("unidadMedida"));

                listUnits.add(unitEntity);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumUnitSalesDAO.USER_ERROR_SQL_MAPPING_UNIT_SALES.getContent();
            var technicalMessage = MessagesEnumUnitSalesDAO.TECHNICAL_ERROR_SQL_MAPPING_UNIT_SALES.getContent() + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnumUnitSalesDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_UNIT_SALES.getContent();
            var technicalMessage = MessagesEnumUnitSalesDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_UNIT_SALES.getContent() + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listUnits;
    }

}