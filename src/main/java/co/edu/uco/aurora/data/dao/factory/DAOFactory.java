package co.edu.uco.aurora.data.dao.factory;
import java.sql.Connection;
import java.sql.SQLException;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.aurora.data.dao.entity.AdministratorDAO;
import co.edu.uco.aurora.data.dao.entity.BatchDAO;
import co.edu.uco.aurora.data.dao.entity.BrandDAO;
import co.edu.uco.aurora.data.dao.entity.CategoryDAO;
import co.edu.uco.aurora.data.dao.entity.CustomerDAO;
import co.edu.uco.aurora.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.aurora.data.dao.entity.ProductBrandDAO;
import co.edu.uco.aurora.data.dao.entity.ProductDAO;
import co.edu.uco.aurora.data.dao.entity.UnitMeasurementDAO;
import co.edu.uco.aurora.data.dao.entity.SaleDAO;
import co.edu.uco.aurora.data.dao.entity.SaleProductBrandDAO;
import co.edu.uco.aurora.data.dao.entity.UnitSalesDAO;
import co.edu.uco.aurora.data.dao.factory.postgresql.PostgresqlDAOFactory;

public abstract class DAOFactory {

    protected Connection connection;
    protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;

    public static DAOFactory getFactory () {
        if(FactoryEnum.POSTGRESQL.equals(factory)) {
            return new PostgresqlDAOFactory();
        } else {
            var userMessage = MessagesEnum.USER_ERROR_SQL_DATASOURCE_NOT_AVAILABLE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_DATASOURCE_NOT_AVAILABLE.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }

    public abstract AdministratorDAO getAdmistratorDao();

    public abstract CustomerDAO getCustomerDAO();

    public abstract BatchDAO getBatchDAO();

    public abstract BrandDAO getBrandDAO();

    public abstract CategoryDAO getCategoryDAO();

    public abstract IdentificationTypeDAO getIdentificationTypeDAO();

    public abstract ProductBrandDAO getProductBrandDAO();

    public abstract ProductDAO getProductDAO();

    public abstract UnitMeasurementDAO getProductSizeDAO();

    public abstract SaleDAO getSaleDAO();

    public abstract SaleProductBrandDAO getSaleProductBrandDAO();

    public abstract UnitSalesDAO getUnitSalesDAO();


    protected abstract void openConnection();

    public final void initTransaction () {

        openConnection();

        SqlConnectionHelper.ensureTransactionIsNotStarted(connection);

        try {
            connection.setAutoCommit(false);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CANNOT_INIT_TRANSACTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CANNOT_INIT_TRANSACTION.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_INIT_TRANSACTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INIT_TRANSACTION.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    public final void commitTransaction () {
        SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try {
            connection.commit();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CANNOT_COMMIT_TRANSACTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CANNOT_COMMIT_TRANSACTION.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_COMMIT_TRANSACTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_COMMIT_TRANSACTION.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

    }

    public final void rollbackTransaction () {
        SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try {
            connection.rollback();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CANNOT_ROLLBACK_TRANSACTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CANNOT_ROLLBACK_TRANSACTION.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_ROLLBACK_TRANSACTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_ROLLBACK_TRANSACTION.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

//    protected final void closeTransaction () {
//        SqlConnectionHelper.ensureTransactionIsNotStarted(connection);
//
//        try {
//            connection.close();
//
//        } catch (final SQLException exception) {
//            var userMassage = MessagesEnum.USER_ERROR_SQL_CANNOT_CLOSE_CONNECTION.getContent();
//            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CANNOT_CLOSE_CONNECTION.getContent();
//            throw AuroraException.create(exception, userMassage, technicalMessage);
//
//        }catch (Exception exception) {
//            var userMassage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
//            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
//            throw AuroraException.create(exception, userMassage, technicalMessage);
//        }
//
//    }

    public final void closeConnection() {
        SqlConnectionHelper.ensureConnectionIsOpen(connection);

        try {
            connection.close();
        } catch (final SQLException exception) {
            var userMassage = MessagesEnum.USER_ERROR_SQL_CANNOT_CLOSE_CONNECTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CANNOT_CLOSE_CONNECTION.getContent();
            throw AuroraException.create(exception, userMassage, technicalMessage);

        }catch (Exception exception) {
            var userMassage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
            throw AuroraException.create(exception, userMassage, technicalMessage);
        }
    }
}
