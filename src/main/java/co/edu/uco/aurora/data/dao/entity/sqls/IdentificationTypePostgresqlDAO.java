package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumIdentificationTypeDAO;
import co.edu.uco.aurora.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class IdentificationTypePostgresqlDAO extends SqlConnection implements IdentificationTypeDAO {

    public IdentificationTypePostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IdentificationTypeEntity> findAll() {
        return findByFilter(new IdentificationTypeEntity());
    }

    @Override
    public List<IdentificationTypeEntity> findByFilter(IdentificationTypeEntity filterEntity) {
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
            var userMessage = MessagesEnumIdentificationTypeDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_IDENTIFICATION_TYPE.getContent();
            var technicalMessage = MessagesEnumIdentificationTypeDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_IDENTIFICATION_TYPE.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        }catch (final Exception exception) {
            var userMessage = MessagesEnumIdentificationTypeDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_IDENTIFICATION_TYPE.getContent(); // Crear este mensaje
            var technicalMessage = MessagesEnumIdentificationTypeDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_IDENTIFICATION_TYPE.getContent(); // Crear este mensaje
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter (final IdentificationTypeEntity filterEntity, final List<Object> parameterList) {

        final var sql = new StringBuilder("SELECT T.id, T.tipoDocumento FROM TipoDocumento T");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final IdentificationTypeEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new IdentificationTypeEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "T.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getIdentificationType()),
                "T.tipoDocumento = ?", filterEntityValidated.getIdentificationType());

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

    private List<IdentificationTypeEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listIdType = new ArrayList<IdentificationTypeEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var idType = new IdentificationTypeEntity();

                idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                idType.setIdentificationType(resultSet.getString("tipoDocumento"));

                listIdType.add(idType);
            }

        }  catch (SQLException exception) {
            var userMessage = MessagesEnumIdentificationTypeDAO.USER_ERROR_SQL_MAPPING_IDENTIFICATION_TYPE.getContent();
            var technicalMessage = MessagesEnumIdentificationTypeDAO.TECHNICAL_ERROR_SQL_MAPPING_IDENTIFICATION_TYPE.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception){
            var userMessage = MessagesEnumIdentificationTypeDAO.USER_ERROR_SQL_UNEXPECTED_MAPPING_IDENTIFICATION_TYPE.getContent();
            var technicalMessage = MessagesEnumIdentificationTypeDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_IDENTIFICATION_TYPE.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listIdType;
    }
}