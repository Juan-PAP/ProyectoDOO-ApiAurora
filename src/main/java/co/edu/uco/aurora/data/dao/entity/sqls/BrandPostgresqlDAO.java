package co.edu.uco.aurora.data.dao.entity.sqls;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls.MessagesEnumBrandDAO;
import co.edu.uco.aurora.data.dao.entity.BrandDAO;
import co.edu.uco.aurora.entity.BrandEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class BrandPostgresqlDAO extends SqlConnection implements BrandDAO {

    public BrandPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final BrandEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO Marca (idMarca, nombre) ");
        sql.append("VALUES (?, ?)");
        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getName());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_INSERT_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_INSERT_BRAND.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BRAND.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<BrandEntity> findAll() {
        return findByFilter(new BrandEntity());
    }

    @Override
    public List<BrandEntity> findByFilter(final BrandEntity filterEntity) {
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
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BRAND.getContent() + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BRAND.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public BrandEntity findById(UUID id) {
        return findByFilter(new BrandEntity(id))
                .stream()
                .findFirst()
                .orElse(new BrandEntity());
    }

    private String createSentenceFindByFilter (final BrandEntity filterEntity, final List<Object> parameterList) {
        final var sql = new StringBuilder("SELECT M.idMarca, M.nombre FROM Marca M");
        createWhereClauseFindByFilter(sql, parameterList, filterEntity);
        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList,
                                               final BrandEntity filterEntity) {

        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new BrandEntity());
        final var conditions = new ArrayList<String>();


        addCondition(conditions, parameterList,
                !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "M.idMarca = ?", filterEntityValidated.getId());

        addCondition(conditions, parameterList,
                !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "M.nombre = ?", filterEntityValidated.getName());

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

    private List<BrandEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listBrands = new ArrayList<BrandEntity>();

        try (var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                var brandEntity = new BrandEntity();

                brandEntity.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idMarca")));
                brandEntity.setName(resultSet.getString("nombre"));

                listBrands.add(brandEntity);
            }

        } catch (SQLException exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_MAPPING_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_MAPPING_BRAND.getContent() + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        } catch (Exception exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BRAND.getContent() + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }

        return listBrands;
    }

    @Override
    public void update(final BrandEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("UPDATE Marca SET nombre = ? ");
        sql.append("WHERE idMarca = ?");

        try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getName());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_UPDATE_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_UPDATE_BRAND.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnumBrandDAO.USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BRAND.getContent();
            var technicalMessage = MessagesEnumBrandDAO.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BRAND.getContent();
            throw AuroraException.create(exception, userMessage, technicalMessage);
        }
    }
}