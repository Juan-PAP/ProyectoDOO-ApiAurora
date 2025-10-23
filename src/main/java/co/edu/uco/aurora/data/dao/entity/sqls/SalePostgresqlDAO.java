package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumSaleDAO;
import co.edu.uco.aurora.data.dao.entity.SaleDAO;
import co.edu.uco.aurora.entity.CustomerEntity;
import co.edu.uco.aurora.entity.SaleEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class SalePostgresqlDAO extends SqlConnection implements SaleDAO {

    public SalePostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final SaleEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Venta (id, codigoVenta, idCliente, fecha) ");
        sql.append("VALUES (?, ?, ?, ?)");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getSaleCode());
            preparedStatement.setObject(3, entity.getCustomer().getId());
            preparedStatement.setObject(4, entity.getDate());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnumSaleDAO.USER_ERROR_SQL_INSERT_SALE.getContent();
            var technicalMessage = MessagesEnumSaleDAO.TECHNICAL_ERROR_SQL_INSERT_SALE.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumSaleDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALE.getContent();
            var technicalMessage = MessagesEnumSaleDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALE.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<SaleEntity> findAll() {
        return findByFilter(new SaleEntity());
    }

    @Override
    public List<SaleEntity> findByFilter(final SaleEntity filterEntity) {
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
            var userMessage = MessagesEnumSaleDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_SALE.getContent();
            var technicalMessage = MessagesEnumSaleDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_SALE.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumSaleDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_SALE.getContent();
            var technicalMessage = MessagesEnumSaleDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_SALE.getContent()
                    + ": " + exception.getMessage();;
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter (final SaleEntity filterEntity, final List<Object> parameterList) {
        final var sql = new StringBuilder();

        sql.append("SELECT V.id, V.codigoVenta, V.fecha, ");
        sql.append("C.id AS idCliente, C.nombreCompleto AS nombreCliente ");
        sql.append("FROM Venta V ");
        sql.append("INNER JOIN Cliente C ON V.idCliente = C.id ");

        createWhereClauseFindByFilter(sql, parameterList, filterEntity);

        sql.append(" ORDER BY V.fecha DESC");

        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final SaleEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new SaleEntity());
        final var conditions = new ArrayList<String>();

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "V.id = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getSaleCode()),
                "V.codigoVenta = ?", filterEntityValidated.getSaleCode());

        addCondition(conditions, parameterList,
                filterEntityValidated.getDate() != null,
                "V.fecha = ?", filterEntityValidated.getDate());

        var customerFilter = ObjectHelper.getDefault(
                filterEntityValidated.getCustomer(),
                new CustomerEntity()
        );

        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(customerFilter.getId()),
                "C.id = ?", customerFilter.getId());

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

    private List<SaleEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listSales = new ArrayList<SaleEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                var customer = new CustomerEntity();
                customer.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCliente")));
                customer.setFullName(resultSet.getString("nombreCliente"));

                var sale = new SaleEntity();
                sale.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
                sale.setSaleCode(resultSet.getString("codigoVenta"));
                sale.setCustomer(customer);
                sale.setDate(resultSet.getObject("fecha", java.time.LocalDate.class));

                listSales.add(sale);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumSaleDAO.USER_ERROR_SQL_MAPPING_SALE.getContent();
            var technicalMessage = MessagesEnumSaleDAO.TECHNICAL_ERROR_SQL_MAPPING_SALE.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnumSaleDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_SALE.getContent();
            var technicalMessage = MessagesEnumSaleDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_SALE.getContent()
                    + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listSales;
    }
}