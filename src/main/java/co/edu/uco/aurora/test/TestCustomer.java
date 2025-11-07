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

        String uniqueSuffix = String.valueOf(System.currentTimeMillis() % 100000000);

        final String uniqueIdNumber = "10" + uniqueSuffix;
        final String uniquePhoneNumber = "300" + uniqueSuffix.substring(1);

        var facade = new CustomerFacadeImpl();

        try {
            System.out.println("Iniciando prueba de REGISTRO...");

            var idType = IdentificationTypeDTO.createDefault();

            idType.setId(UUID.fromString("a1a1a1a1-0001-0001-0001-000000000002"));
            idType.setName("Cedula de Ciudadania");

            var customerDTO = CustomerDTO.getDefault();
            customerDTO.setIdentificationType(idType);
            customerDTO.setIdentificationNumber(uniqueIdNumber);
            customerDTO.setFullName("Juan Pablo Alzate Pulgarin");
            customerDTO.setPhoneNumber(uniquePhoneNumber);
            customerDTO.setBirthDate(LocalDate.of(1995, 10, 20));

            facade.registerNewCustomer(customerDTO);

            System.out.println("✅ ¡REGISTRO EXITOSO! (Cliente: " + uniqueIdNumber + ")");
            System.out.println("-------------------------------------------------");

            System.out.println("Iniciando prueba de CONSULTA...");

            List<CustomerDTO> customers = facade.getAllCustomer();

            if (customers.isEmpty()) {
                throw new Exception("Error en el flujo: La lista de clientes está vacía después de registrar.");
            }

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
            System.err.println("❌ ERROR DE NEGOCIO:");
            System.err.println("   Mensaje Usuario: " + exception.getUserMessage());
            System.err.println("   Mensaje Técnico: " + exception.getTechnicalMessage());
            exception.printStackTrace();

        } catch (final Exception exception) {
            System.err.println("❌ ERROR INESPERADO:");
            exception.printStackTrace();
        }
    }
}
