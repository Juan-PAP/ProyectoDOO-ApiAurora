package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumProductDAO;
import co.edu.uco.aurora.data.dao.entity.ProductDAO;
import co.edu.uco.aurora.entity.CategoryEntity;
import co.edu.uco.aurora.entity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ProductPostgresqlDAO extends SqlConnection implements ProductDAO {

    public ProductPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final ProductEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Producto (id, nombre, idCategoria) ");
        sql.append("VALUES (?, ?, ?)");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setObject(3, entity.getCategory().getId()); // Asume que ProductEntity tiene getCategory()

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_INSERT_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_INSERT_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(final ProductEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = "UPDATE Producto SET nombre = ?, idCategoria = ? WHERE id = ?";

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setObject(2, entity.getCategory().getId());
            preparedStatement.setObject(3, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_UPDATE_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_UPDATE_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<ProductEntity> findAll() {
        return findByFilter(new ProductEntity());
    }

    @Override
    public List<ProductEntity> findByFilter(final ProductEntity filterEntity) {
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
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter (final ProductEntity filterEntity, final List<Object> parameterList) {
        final var sql = new StringBuilder();

        sql.append("SELECT P.id, P.nombre, ");
        sql.append("C.id AS idCategoria, C.nombre AS nombreCategoria ");
        sql.append("FROM Producto P ");
        sql.append("INNER JOIN Categoria C ON P.idCategoria = C.id ");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        sql.append(" ORDER BY P.nombre ASC");

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final ProductEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProductEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "P.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "P.nombre = ?", filterEntityValidated.getName());

        var categoryFilter = ObjectHelper.getDefault(
                filterEntityValidated.getCategory(),
                new CategoryEntity()
        );

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(categoryFilter.getId()),
                "C.id = ?", categoryFilter.getId());


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

    private List<ProductEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listProducts = new ArrayList<ProductEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                var category = new CategoryEntity();
                category.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCategoria")));
                category.setName(resultSet.getString("nombreCategoria"));

                var product = new ProductEntity();
                product.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                product.setName(resultSet.getString("nombre"));

                product.setCategory(category);

                listProducts.add(product);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_MAPPING_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_MAPPING_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnumProductDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_PRODUCT.getContent();
            var technicalMessage = MessagesEnumProductDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_PRODUCT.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listProducts;
    }
}