package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.MessagesEnum;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlConnection {

    private Connection connection;

    protected SqlConnection (final Connection connection) {
        setConnection(connection);
    }

    protected Connection getConnection () {
        return connection;
    }

    public void setConnection (final Connection connection) {
        if (ObjectHelper.isNull(connection)) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        try {
            if (connection.isClosed()) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                throw AuroraException.create(userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONECTION_STATUS.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        this.connection = connection;

    }
}
