package co.edu.uco.aurora.data.dao.factory;

import co.edu.uco.aurora.data.dao.entity.AdministratorDAO;
import co.edu.uco.aurora.data.dao.entity.BatchDAO;
import co.edu.uco.aurora.data.dao.entity.BrandDAO;
import co.edu.uco.aurora.data.dao.entity.CategoryDAO;
import co.edu.uco.aurora.data.dao.entity.CustomerDAO;
import co.edu.uco.aurora.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.aurora.data.dao.entity.ProductBrandDAO;
import co.edu.uco.aurora.data.dao.entity.ProductDAO;
import co.edu.uco.aurora.data.dao.entity.ProductoSizeDAO;
import co.edu.uco.aurora.data.dao.entity.SaleDAO;
import co.edu.uco.aurora.data.dao.entity.SaleProductBrandDAO;
import co.edu.uco.aurora.data.dao.entity.UnitSalesDAO;

import java.sql.Connection;

public abstract class DAOFactory {

    protected Connection connetion;
    protected FactoryEnum factory = FactoryEnum.POSTGRESQL;

    public static DAOFactory getFactory () {
        return null;
    }

    public abstract AdministratorDAO getAdmistratorDao();

    public abstract CustomerDAO getCustomerDAO();

    public abstract BatchDAO getBatchDAO();

    public abstract BrandDAO getBrandDAO();

    public abstract CategoryDAO getCategoryDAO();

    public abstract IdentificationTypeDAO getIdentificationTypeDAO();

    public abstract ProductBrandDAO getProductBrandDAO();

    public abstract ProductDAO getProductDAO();

    public abstract ProductoSizeDAO getProductSizeDAO();

    public abstract SaleDAO getSaleDAO();

    public abstract SaleProductBrandDAO getSaleProductBrandDAO();

    public abstract UnitSalesDAO getUnitSalesDAO();


    protected abstract void openConnetion ();

    protected final void initTransaction () {

    }

    protected final void commitTransaction () {

    }

    protected final void rollbackTransction () {

    }

    protected final void closeTransaction () {

    }
}
