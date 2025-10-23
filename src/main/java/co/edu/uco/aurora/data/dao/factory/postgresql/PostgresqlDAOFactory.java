package co.edu.uco.aurora.data.dao.factory.postgresql;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.aurora.data.dao.entity.*;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgresqlDAOFactory extends DAOFactory {

    public PostgresqlDAOFactory() {
        openConnection();
    }

    @Override
    protected void openConnection() {
        String url = "jdbc:postgresql://localhost:5432/aurora";
        String user = "postgres";
        String password = "root";

        try {

            Class.forName("org.postgresql.Driver");

            this.connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException exception) {

            var userMassage = MessagesEnum.USER_ERROR_SQL_CANNOT_OPEN_CONNECTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CANNOT_OPEN_CONNECTION.getContent();
            throw AuroraException.create(exception, userMassage, technicalMessage);

        } catch (Exception exception) {

            var userMassage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
            throw AuroraException.create(exception, userMassage, technicalMessage);
        }
    }

    @Override
    public AdministratorDAO getAdmistratorDao() {
        return null;
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return null;
    }

    @Override
    public BatchDAO getBatchDAO() {
        return null;
    }

    @Override
    public BrandDAO getBrandDAO() {
        return null;
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return null;
    }

    @Override
    public IdentificationTypeDAO getIdentificationTypeDAO() {
        return null;
    }

    @Override
    public ProductBrandDAO getProductBrandDAO() {
        return null;
    }

    @Override
    public ProductDAO getProductDAO() {
        return null;
    }

    @Override
    public UnitMeasurementDAO getProductSizeDAO() {
        return null;
    }

    @Override
    public SaleDAO getSaleDAO() {
        return null;
    }

    @Override
    public SaleProductBrandDAO getSaleProductBrandDAO() {
        return null;
    }

    @Override
    public UnitSalesDAO getUnitSalesDAO() {
        return null;
    }

}
