package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumBatchDAO;
import co.edu.uco.aurora.data.dao.entity.BatchDAO;
import co.edu.uco.aurora.entity.BatchEntity;
import co.edu.uco.aurora.entity.BrandEntity;
import co.edu.uco.aurora.entity.ProductBrandEntity;
import co.edu.uco.aurora.entity.ProductEntity;
import co.edu.uco.aurora.entity.UnitMeasurementEntity;
import co.edu.uco.aurora.entity.UnitSalesEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class BatchPostgresqlDAO extends SqlConnection implements BatchDAO {

    public BatchPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final BatchEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Lote (id, idProductoMarca, esPecedecero, fechaVencimiento, cantidad) ");
        sql.append("VALUES (?, ?, ?, ?, ?)");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getProductBrand().getId());
            preparedStatement.setBoolean(3, entity.isPerishable());
            preparedStatement.setObject(4, entity.getExpirationDate());
            preparedStatement.setFloat(5, entity.getAmount());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_INSERT_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_INSERT_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(final BatchEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE Lote SET esPecedecero = ?, fechaVencimiento = ?, cantidad = ? ");
        sql.append("WHERE id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setBoolean(1, entity.isPerishable());
            preparedStatement.setObject(2, entity.getExpirationDate());
            preparedStatement.setFloat(3, entity.getAmount());
            preparedStatement.setObject(4, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_UPDATE_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_UPDATE_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<BatchEntity> findAll() {
        return findByFilter(new BatchEntity());
    }

    @Override
    public List<BatchEntity> findByFilter(final BatchEntity filterEntity) {

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
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public BatchEntity findById(UUID id) {
        return findByFilter(new BatchEntity(id))
                .stream()
                .findFirst()
                .orElse(new BatchEntity());
    }

    private String createSentenceFindByFilter(final BatchEntity filterEntity, final List<Object> parameterList) {

        final var sql = new StringBuilder();

        sql.append("SELECT L.id, L.esPecedecero, L.fechaVencimiento, L.cantidad, ");
        sql.append("PM.id AS idProductoMarca, PM.referencia, PM.medida, PM.precio, PM.restriccionEdad, ");
        sql.append("P.id AS idProducto, P.nombre AS nombreProducto, ");
        sql.append("M.id AS idMarca, M.nombre AS nombreMarca, ");
        sql.append("UM.id AS idUnidadMedida, UM.nombre AS nombreUnidadMedida, ");
        sql.append("UV.id AS idUnidadVenta, UV.nombre AS nombreUnidadVenta ");
        sql.append("FROM Lote L ");
        sql.append("INNER JOIN ProductoMarca PM ON L.idProductoMarca = PM.id ");
        sql.append("INNER JOIN Producto P ON PM.idProducto = P.id ");
        sql.append("INNER JOIN Marca M ON PM.idMarca = M.id ");
        sql.append("INNER JOIN UnidadMedida UM ON PM.idUnidadMedida = UM.id ");
        sql.append("INNER JOIN UnidadVenta UV ON PM.idUnidadVenta = UV.id ");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        sql.append(" ORDER BY L.fechaVencimiento ASC");

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final BatchEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new BatchEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "L.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                filterEntityValidated.isPerishable(),
                "L.esPecedecero = ?", filterEntityValidated.isPerishable());

        addCondition(conditions, parameterList,
                filterEntityValidated.getExpirationDate() != null,
                "L.fechaVencimiento = ?", filterEntityValidated.getExpirationDate());

        var pbFilter = ObjectHelper.getDefault(filterEntityValidated.getProductBrand(), new ProductBrandEntity());

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(pbFilter.getId()),
                "PM.id = ?", pbFilter.getId());

        var pFilter = ObjectHelper.getDefault(pbFilter.getProduct(), new ProductEntity());
        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(pFilter.getId()),
                "P.id = ?", pFilter.getId());

        var mFilter = ObjectHelper.getDefault(pbFilter.getBrand(), new BrandEntity());
        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(mFilter.getId()),
                "M.id = ?", mFilter.getId());

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

    private List<BatchEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listBatch = new ArrayList<BatchEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                var product = new ProductEntity();
                product.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idProducto")));
                product.setName(resultSet.getString("nombreProducto"));

                var brand = new BrandEntity();
                brand.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idMarca")));
                brand.setName(resultSet.getString("nombreMarca"));

                var measurementUnit = new UnitMeasurementEntity();
                measurementUnit.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idUnidadMedida")));
                measurementUnit.setName(resultSet.getString("nombreUnidadMedida"));

                var saleUnit = new UnitSalesEntity();
                saleUnit.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idUnidadVenta")));
                saleUnit.setName(resultSet.getString("nombreUnidadVenta"));

                var productBrand = new ProductBrandEntity();
                productBrand.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idProductoMarca")));
                productBrand.setReference(resultSet.getString("referencia"));
                productBrand.setMeasure(resultSet.getString("medida"));
                productBrand.setPrice(resultSet.getFloat("precio"));
                productBrand.setHasAgeRestriction(resultSet.getBoolean("restriccionEdad"));
                productBrand.setProduct(product);
                productBrand.setBrand(brand);
                productBrand.setUnitMeasurement(measurementUnit);
                productBrand.setUnitSales(saleUnit);

                var batch = new BatchEntity();
                batch.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));

                batch.setPerishable(resultSet.getBoolean("esPecedecero"));
                batch.setExpirationDate(resultSet.getObject("fechaVencimiento", java.time.LocalDate.class));
                batch.setAmount(resultSet.getFloat("cantidad"));

                batch.setProductBrand(productBrand);

                listBatch.add(batch);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_MAPPING_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_MAPPING_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (Exception exception) {
            var userMessage = MessagesEnumBatchDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BATCH.getContent();
            var technicalMessage = MessagesEnumBatchDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BATCH.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
        return listBatch;
    }
}