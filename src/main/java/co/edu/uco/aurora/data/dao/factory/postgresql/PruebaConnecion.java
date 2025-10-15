package co.edu.uco.aurora.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConnecion {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/aurora";
        String user = "postgres";
        String password = "root";

        try {
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, user, password)) {

                if (connection != null && !connection.isClosed()) {
                    System.out.println("✅ Conexión establecida correctamente con PostgreSQL");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC de PostgreSQL no encontrado.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

