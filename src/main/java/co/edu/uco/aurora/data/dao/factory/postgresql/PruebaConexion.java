package co.edu.uco.aurora.data.dao.factory.postgresql;

import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.data.dao.factory.postgresql.PostgresqlDAOFactory;

public class PruebaConexion {

    public static void main(String[] args) {
        DAOFactory factory = null;

        try {
            System.out.println("Intentando obtener conexión a través de la Factoría...");

            // Esta línea es la clave: al crear la instancia, se ejecuta el constructor
            // y el constructor llama a openConnection().
            factory = new PostgresqlDAOFactory();

            // Si la línea anterior no lanzó una excepción, la conexión fue exitosa.
            System.out.println("\n✅ ¡CONEXIÓN EXITOSA a través de la Factoría!");
            System.out.println("La clase PostgresqlDAOFactory funciona correctamente.");

        } catch (final AuroraException e) {
            System.out.println("\n❌ ¡FALLÓ LA CONEXIÓN a través de la Factoría!");
            System.out.println("--- Causa del Error ---");
            e.printStackTrace();
            System.out.println("-----------------------");
            System.out.println("Revisa las credenciales dentro de tu clase PostgresqlDAOFactory.");

        } finally {
            // Nos aseguramos de cerrar la conexión si se logró abrir
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