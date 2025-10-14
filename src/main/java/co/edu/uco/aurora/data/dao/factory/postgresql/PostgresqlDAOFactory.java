package co.edu.uco.aurora.data.dao.factory.postgresql;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
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
        try {
            this.connection = DriverManager.getConnection("");
        } catch (SQLException exception) {
            var userMessage ="";
            var technicalMessage="";
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw AuroraException.create(exception,userMessage, technicalMessage);
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
    public ProductoSizeDAO getProductSizeDAO() {
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
