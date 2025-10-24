package co.edu.uco.aurora.data.dao.factory.postgresql;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.aurora.data.dao.entity.*;
import co.edu.uco.aurora.data.dao.entity.sqls.AdministratorPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.BatchPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.BrandPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.CategoryPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.CustomerPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.IdentificationTypePostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.ProductBrandPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.ProductPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.SalePostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.SaleProductBrandPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.UnitMeasurementPostgresqlDAO;
import co.edu.uco.aurora.data.dao.entity.sqls.UnitSalesPostgresqlDAO;
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
    public AdministratorDAO getAdministratorDao() {
        return new AdministratorPostgresqlDAO(connection);
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return new CustomerPostgresqlDAO(connection);
    }

    @Override
    public BatchDAO getBatchDAO() {
        return new BatchPostgresqlDAO(connection);
    }

    @Override
    public BrandDAO getBrandDAO() {
        return new BrandPostgresqlDAO(connection);
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryPostgresqlDAO(connection);
    }

    @Override
    public IdentificationTypeDAO getIdentificationTypeDAO() {
        return new IdentificationTypePostgresqlDAO(connection);
    }

    @Override
    public ProductBrandDAO getProductBrandDAO() {
        return new ProductBrandPostgresqlDAO(connection);
    }

    @Override
    public ProductDAO getProductDAO() {
        return new ProductPostgresqlDAO(connection);
    }

    @Override
    public UnitMeasurementDAO getUnitMeasurementDAO() {
        return new UnitMeasurementPostgresqlDAO(connection);
    }

    @Override
    public SaleDAO getSaleDAO() {
        return new SalePostgresqlDAO(connection);
    }

    @Override
    public SaleProductBrandDAO getSaleProductBrandDAO() {
        return new SaleProductBrandPostgresqlDAO(connection);
    }

    @Override
    public UnitSalesDAO getUnitSalesDAO() {
        return new UnitSalesPostgresqlDAO(connection);
    }

}
