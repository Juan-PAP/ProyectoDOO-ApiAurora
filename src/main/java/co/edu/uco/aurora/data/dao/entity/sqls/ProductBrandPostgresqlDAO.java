package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumProductBrandDAO;
import co.edu.uco.aurora.data.dao.entity.ProductBrandDAO;
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

public final class ProductBrandPostgresqlDAO extends SqlConnection implements ProductBrandDAO {

    public ProductBrandPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final ProductBrandEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO ProductoMarca (id, referencia, idProducto, idMarca, medida, ");
        sql.append("idUnidadMedida, idUnidadVenta, precio, restriccionEdad) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getReference());
            preparedStatement.setObject(3, entity.getProduct().getId());
            preparedStatement.setObject(4, entity.getBrand().getId());
            preparedStatement.setString(5, entity.getMeasure());

            // Tus nombres de variable:
            preparedStatement.setObject(6, entity.getUnitMeasurement().getId());
            preparedStatement.setObject(7, entity.getUnitSales().getId());
            preparedStatement.setFloat(8, entity.getPrice());
            preparedStatement.setBoolean(9, entity.isHasAgeRestriction());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_INSERT_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_INSERT_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(final ProductBrandEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE ProductoMarca SET referencia = ?, medida = ?, idUnidadMedida = ?, ");
        sql.append("idUnidadVenta = ?, precio = ?, restriccionEdad = ? ");
        sql.append("WHERE id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setString(1, entity.getReference());
            preparedStatement.setString(2, entity.getMeasure());
            preparedStatement.setObject(3, entity.getUnitMeasurement().getId());
            preparedStatement.setObject(4, entity.getUnitSales().getId());
            preparedStatement.setFloat(5, entity.getPrice());
            preparedStatement.setBoolean(6, entity.isHasAgeRestriction());
            preparedStatement.setObject(7, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_UPDATE_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_UPDATE_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<ProductBrandEntity> findAll() {
        return findByFilter(new ProductBrandEntity());
    }

    @Override
    public List<ProductBrandEntity> findByFilter(final ProductBrandEntity filterEntity) {
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
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public ProductBrandEntity findById(UUID uuid) {
        return findByFilter(new ProductBrandEntity(uuid))
                .stream()
                .findFirst()
                .orElse(new ProductBrandEntity());
    }

    private String createSentenceFindByFilter(final ProductBrandEntity filterEntity, final List<Object> parameterList) {
        final var sql = new StringBuilder();

        sql.append("SELECT PM.id, PM.referencia, PM.medida, PM.precio, PM.restriccionEdad, ");
        sql.append("P.id AS idProducto, P.nombre AS nombreProducto, ");
        sql.append("M.id AS idMarca, M.nombre AS nombreMarca, ");
        sql.append("UM.id AS idUnidadMedida, UM.nombre AS nombreUnidadMedida, ");
        sql.append("UV.id AS idUnidadVenta, UV.nombre AS nombreUnidadVenta ");
        sql.append("FROM ProductoMarca PM ");
        sql.append("INNER JOIN Producto P ON PM.idProducto = P.id ");
        sql.append("INNER JOIN Marca M ON PM.idMarca = M.id ");
        sql.append("INNER JOIN UnidadMedida UM ON PM.idUnidadMedida = UM.id ");
        sql.append("INNER JOIN UnidadVenta UV ON PM.idUnidadVenta = UV.id ");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        sql.append(" ORDER BY P.nombre ASC, M.nombre ASC");

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final ProductBrandEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ProductBrandEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "PM.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getReference()),
                "PM.referencia = ?", filterEntityValidated.getReference());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getMeasure()),
                "PM.medida = ?", filterEntityValidated.getMeasure());

        addCondition(conditions, parameterList,
                filterEntityValidated.isHasAgeRestriction(),
                "PM.restriccionEdad = ?", filterEntityValidated.isHasAgeRestriction());

        var productFilter = ObjectHelper.getDefault(filterEntityValidated.getProduct(), new ProductEntity());
        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(productFilter.getId()),
                "P.id = ?", productFilter.getId());

        var brandFilter = ObjectHelper.getDefault(filterEntityValidated.getBrand(), new BrandEntity());
        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(brandFilter.getId()),
                "M.id = ?", brandFilter.getId());

        var measurementUnitFilter = ObjectHelper.getDefault(filterEntityValidated.getUnitMeasurement(), new UnitMeasurementEntity());
        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(measurementUnitFilter.getId()),
                "UM.id = ?", measurementUnitFilter.getId());

        var saleUnitFilter = ObjectHelper.getDefault(filterEntityValidated.getUnitSales(), new UnitSalesEntity()); // <-- Corregido
        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(saleUnitFilter.getId()),
                "UV.id = ?", saleUnitFilter.getId());

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

    private List<ProductBrandEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listProductBrand = new ArrayList<ProductBrandEntity>();

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
                productBrand.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                productBrand.setReference(resultSet.getString("referencia"));
                productBrand.setMeasure(resultSet.getString("medida"));
                productBrand.setPrice(resultSet.getFloat("precio"));

                productBrand.setHasAgeRestriction(resultSet.getBoolean("restriccionEdad"));

                productBrand.setProduct(product);
                productBrand.setBrand(brand);
                productBrand.setUnitMeasurement(measurementUnit);
                productBrand.setUnitSales(saleUnit);

                listProductBrand.add(productBrand);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_MAPPING_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_MAPPING_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (Exception exception) {
            var userMessage = MessagesEnumProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_MAPPING_PRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_PRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
        return listProductBrand;
    }
}