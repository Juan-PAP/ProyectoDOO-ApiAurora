package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumSaleProductBrandDAO {


    USER_ERROR_SQL_INSERT_SALEPRODUCTBRAND(
            "Error al registrar el detalle del producto en la venta",
            "Se ha presentado un problema tratando de registrar el detalle del producto en la venta. " +
                    "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_SALEPRODUCTBRAND(
            "Error técnico al registrar el detalle de la venta",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de un registro en VentaProductoMarca. " +
                    "Por favor valide que la base de datos esté funcionando correctamente."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALEPRODUCTBRAND(
            "Error inesperado al registrar el detalle de la venta",
            "Se ha presentado un problema inesperado tratando de registrar el detalle del producto en la venta. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALEPRODUCTBRAND(
            "Error técnico inesperado al registrar el detalle de la venta",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación del detalle de la venta. " +
                    "Revise los registros."),



    USER_ERROR_SQL_UPDATE_SALEPRODUCTBRAND(
            "Error al actualizar el detalle de la venta",
            "No fue posible actualizar los datos del detalle de la venta. Por favor, verifique los datos ingresados e intente de nuevo."),

    TECHNICAL_ERROR_SQL_UPDATE_SALEPRODUCTBRAND(
            "Error técnico al actualizar el detalle de la venta",
            "Se ha presentado un error de tipo SQLException al intentar actualizar el registro en VentaProductoMarca."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_SALEPRODUCTBRAND(
            "Error inesperado al actualizar el detalle de la venta",
            "Ha ocurrido un error inesperado al intentar actualizar el registro del detalle de la venta. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_SALEPRODUCTBRAND(
            "Error técnico inesperado al actualizar el detalle de la venta",
            "Se ha presentado un error inesperado (no-SQL) al actualizar el registro del detalle de la venta. Revise la traza completa de la excepción."),



    USER_ERROR_SQL_DELETE_SALEPRODUCTBRAND(
            "Error al eliminar el detalle de la venta",
            "No fue posible eliminar el registro del detalle de la venta. Por favor, intente de nuevo."),

    TECHNICAL_ERROR_SQL_DELETE_SALEPRODUCTBRAND(
            "Error técnico al eliminar el detalle de la venta",
            "Se ha presentado un error de tipo SQLException al intentar eliminar el registro en VentaProductoMarca."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_DELETE_SALEPRODUCTBRAND(
            "Error inesperado al eliminar el detalle de la venta",
            "Ha ocurrido un error inesperado al intentar eliminar el registro del detalle de la venta. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_DELETE_SALEPRODUCTBRAND(
            "Error técnico inesperado al eliminar el detalle de la venta",
            "Se ha presentado un error inesperado (no-SQL) al eliminar el registro del detalle de la venta. Revise la traza completa de la excepción.");


    private String title;
    private String content;

    MessagesEnumSaleProductBrandDAO (final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}