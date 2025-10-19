package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumCategoryDAO;
import co.edu.uco.aurora.data.dao.entity.CategoryDAO;
import co.edu.uco.aurora.entity.CategoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryPostgresqlDAO extends SqlConnection implements CategoryDAO {

    public CategoryPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(CategoryEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Categoria (idCategoria, nombre) ");
        sql.append("SELECT ?, ? ");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_INSERT_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_INSERT_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(CategoryEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = "UPDATE Categoria SET nombre = ? WHERE idCategoria = ?";

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setObject(2, entity.getId());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_UPDATE_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_UPDATE_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

    }

    @Override
    public List<CategoryEntity> findAll() {
        return findByFilter(new CategoryEntity());
    }

    @Override
    public List<CategoryEntity> findByFilter(CategoryEntity filterEntity) {
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
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(final CategoryEntity filterEntity, final List<Object> parameterList) {
        final var sql = new StringBuilder("SELECT C.idCategoria, C.nombre FROM Categoria C ");
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final CategoryEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CategoryEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "C.idCategoria = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "C.nombre = ?", filterEntityValidated.getName());

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

    private List<CategoryEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listCategory = new ArrayList<CategoryEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var category = new CategoryEntity();

                category.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCategoria")));
                category.setName(resultSet.getString("nombre"));

                listCategory.add(category);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_MAPPING_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_MAPPING_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (Exception exception) {
            var userMessage = MessagesEnumCategoryDAO.USER_ERROR_SQL_UNEXPECTED_MAPPING_CATEGORY.getContent();
            var technicalMessage = MessagesEnumCategoryDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_CATEGORY.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
        return listCategory;
    }


}
