package co.edu.uco.aurora.data.dao.factory.postgresql;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

public class PruebaConexion {

    public static void main(String[] args) {
        DAOFactory factory = null;

        try {
            System.out.println("Intentando obtener conexión a través de la Factoría...");

             factory = new PostgresqlDAOFactory();

            System.out.println("\n✅ ¡CONEXIÓN EXITOSA a través de la Factoría!");
            System.out.println("La clase PostgresqlDAOFactory funciona correctamente.");

        } catch (final AuroraException e) {
            System.out.println("\n❌ ¡FALLÓ LA CONEXIÓN a través de la Factoría!");
            System.out.println("--- Causa del Error ---");
            e.printStackTrace();
            System.out.println("-----------------------");
            System.out.println("Revisa las credenciales dentro de tu clase PostgresqlDAOFactory.");

        } finally {
            if (factory != null) {
                try {
                    factory.closeConnection();
                    System.out.println("🔌 Conexión cerrada correctamente.");
                } catch (final AuroraException e) {
                    System.out.println("\n❌ Ocurrió un error al intentar CERRAR la conexión.");
                    e.printStackTrace();
                }
            }
        }
    }
}