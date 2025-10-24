package co.edu.uco.aurora.test;

import co.edu.uco.aurora.business.facade.impl.CustomerFacadeImpl;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.dto.CustomerDTO;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TestCustomer {

    public static void main(String[] args) {

        // --- Genera datos únicos para que el test se pueda repetir ---
        // (Usamos los últimos 8 dígitos del tiempo para crear números únicos)
        String uniqueSuffix = String.valueOf(System.currentTimeMillis() % 100000000);

        // Regla: 6-25 dígitos
        final String uniqueIdNumber = "10" + uniqueSuffix;
        // Regla: 8-15 dígitos
        final String uniquePhoneNumber = "300" + uniqueSuffix.substring(1);

        var facade = new CustomerFacadeImpl();

        try {
            // ==========================================================
            // 1. PRUEBA DE REGISTRO (REGISTER)
            // ==========================================================
            System.out.println("Iniciando prueba de REGISTRO...");

            // --- Preparamos el DTO de Tipo de Identificación ---
            // (Usamos los UUIDs que insertamos en la BBDD)
            var idType = IdentificationTypeDTO.createDefault();
            // ID de "Cedula de Ciudadania"
            idType.setId(UUID.fromString("a1a1a1a1-0001-0001-0001-000000000002"));
            // IMPORTANTE: El nombre debe coincidir con tu constante para la regla de edad
            idType.setName("Cedula de Ciudadania");

            // --- Preparamos el DTO del Cliente (con datos válidos) ---
            var customerDTO = CustomerDTO.getDefault();
            customerDTO.setIdentificationType(idType);
            customerDTO.setIdentificationNumber(uniqueIdNumber);
            customerDTO.setFullName("Juan Pablo Alzate Pulgarin");
            customerDTO.setPhoneNumber(uniquePhoneNumber);
            // Fecha que lo hace mayor de 18 (para que coincida con la "Cedula de Ciudadania")
            customerDTO.setBirthDate(LocalDate.of(1995, 10, 20));

            // --- Ejecutamos el registro ---
            facade.registerNewCustomer(customerDTO);

            System.out.println("✅ ¡REGISTRO EXITOSO! (Cliente: " + uniqueIdNumber + ")");
            System.out.println("-------------------------------------------------");

            // ==========================================================
            // 2. PRUEBA DE CONSULTA (GET ALL)
            // ==========================================================
            System.out.println("Iniciando prueba de CONSULTA...");

            List<CustomerDTO> customers = facade.getAllCustomer();

            if (customers.isEmpty()) {
                throw new Exception("Error en el flujo: La lista de clientes está vacía después de registrar.");
            }

            // --- Buscamos al cliente que acabamos de crear ---
            boolean found = false;
            for (CustomerDTO customer : customers) {
                if (uniqueIdNumber.equals(customer.getIdentificationNumber())) {
                    found = true;
                    System.out.println("Cliente encontrado en la consulta:");
                    System.out.println("   ID: " + customer.getId());
                    System.out.println("   Nombre: " + customer.getFullName());
                    System.out.println("   Teléfono: " + customer.getPhoneNumber());
                    System.out.println("   Confirmado: " + customer.isPhoneNumberConfirmed()); // Debería ser 'false'
                    break;
                }
            }

            if (!found) {
                throw new Exception("Error en el flujo: El cliente " + uniqueIdNumber + " se registró pero no se encontró en la consulta.");
            }

            System.out.println("✅ ¡CONSULTA EXITOSA!");
            System.out.println("-------------------------------------------------");
            System.out.println("🎉 ¡TODO EL FLUJO DE CLIENTE FUNCIONA CORRECTAMENTE!");


        } catch (final AuroraException exception) {
            // Errores de negocio (ej. "El formato del nombre no es válido")
            System.err.println("❌ ERROR DE NEGOCIO:");
            System.err.println("   Mensaje Usuario: " + exception.getUserMessage());
            System.err.println("   Mensaje Técnico: " + exception.getTechnicalMessage());
            exception.printStackTrace();

        } catch (final Exception exception) {
            // Errores inesperados (ej. NullPointerException, Error de Conexión)
            System.err.println("❌ ERROR INESPERADO:");
            exception.printStackTrace();
        }
    }
}
