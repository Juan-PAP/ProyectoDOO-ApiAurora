package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumSaleProductBrandDAO;
import co.edu.uco.aurora.data.dao.entity.SaleProductBrandDAO;
import co.edu.uco.aurora.entity.SaleProductBrandEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public final class SaleProductBrandPostgresqlDAO extends SqlConnection implements SaleProductBrandDAO {

    public SaleProductBrandPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final SaleProductBrandEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO VentaProductoMarca (id, idVenta, idProductoMarca, precioUnitario, cantidad) ");
        sql.append("VALUES (?, ?, ?, ?, ?)");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());

            preparedStatement.setObject(2, entity.getSale().getId());
            preparedStatement.setObject(3, entity.getProductBrand().getId());
            preparedStatement.setFloat(4, entity.getUnitPrice());
            preparedStatement.setFloat(5, entity.getAmount());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumSaleProductBrandDAO.USER_ERROR_SQL_INSERT_SALEPRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumSaleProductBrandDAO.TECHNICAL_ERROR_SQL_INSERT_SALEPRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumSaleProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALEPRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumSaleProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALEPRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(final SaleProductBrandEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();

        sql.append("UPDATE VentaProductoMarca SET precioUnitario = ?, cantidad = ? ");
        sql.append("WHERE id = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setFloat(1, entity.getUnitPrice());
            preparedStatement.setFloat(2, entity.getAmount());
            preparedStatement.setObject(3, entity.getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumSaleProductBrandDAO.USER_ERROR_SQL_UPDATE_SALEPRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumSaleProductBrandDAO.TECHNICAL_ERROR_SQL_UPDATE_SALEPRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumSaleProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_SALEPRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumSaleProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_SALEPRODUCTBRAND.getContent()
                     + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(final UUID uuid) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = "DELETE FROM VentaProductoMarca WHERE id = ?";

        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {

            preparedStatement.setObject(1, uuid);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumSaleProductBrandDAO.USER_ERROR_SQL_DELETE_SALEPRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumSaleProductBrandDAO.TECHNICAL_ERROR_SQL_DELETE_SALEPRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumSaleProductBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_DELETE_SALEPRODUCTBRAND.getContent();
            var technicalMessage = MessagesEnumSaleProductBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_DELETE_SALEPRODUCTBRAND.getContent()
                    + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }
}