package co.edu.uco.aurora.crosscuting.helper;

import java.util.regex.Pattern;

public final class TextHelper {

    private static final String EMPTY = "";
    /**
     * <p>
     * ^                  # Inicio de la cadena
     * [\\p{L}]+          # Una o más letras Unicode (incluye a-z, A-Z, á, é, í, ó, ú, ü, ñ)
     * (                  # Inicio de grupo (opcional)
     * [ ]              # Un solo espacio en blanco
     * [\\p{L}]+        # Seguido de una o más letras Unicode
     * )* # Fin de grupo, y puede repetirse 0 o más veces
     * $                  # Fin de la cadena
     * <p>
     */
    private static final String PERSON_NAME_PATTERN_STRING = "^[\\p{L}]+( [\\p{L}]+)*$";
    private static final String NUMERIC_ONLY_PATTERN_STRING = "^\\d+$";

    private static final Pattern VALID_PERSON_NAME_PATTERN = Pattern.compile(PERSON_NAME_PATTERN_STRING);
    private static final Pattern VALID_NUMERIC_ONLY_PATTERN = Pattern.compile(NUMERIC_ONLY_PATTERN_STRING);

    private TextHelper() {
    }

    public static String getDefault() {
        return EMPTY;
    }

    public static String getDefault(final String value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static String getDefaultWithTrim(final String value) {
        return getDefault(value).trim();
    }

    public static boolean isEmpty (final String value) {
        return EMPTY.equals(getDefault(value));
    }

    public static boolean isEmptyWithTrim(final String value) {
        return isEmpty(getDefaultWithTrim(value));
    }

    public static boolean hasValidPersonNameFormat(final String value) {

        if (isEmptyWithTrim(value)) {
            return false;
        }

        final String trimmedValue = getDefaultWithTrim(value);

        return VALID_PERSON_NAME_PATTERN.matcher(trimmedValue).matches();
    }

    public static boolean hasValidNumericOnlyFormat(final String value) {

        if (isEmpty(value)) {
            return false;
        }

        return VALID_NUMERIC_ONLY_PATTERN.matcher(value).matches();
    }

}

