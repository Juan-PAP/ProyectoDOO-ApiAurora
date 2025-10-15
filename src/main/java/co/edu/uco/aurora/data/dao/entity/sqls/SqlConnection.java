package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;


import java.sql.Connection;

public class SqlConnection {

    private Connection connection;

    protected SqlConnection (final Connection connection) {
        setConnection(connection);
    }

    protected Connection getConnection () {
        return connection;
    }

    public void setConnection (final Connection connection) {

        SqlConnectionHelper.ensureConnectionIsOpen(connection);

        this.connection = connection;

    }
}
