package co.edu.uco.aurora.crosscuting.helper;

import java.time.LocalDate;
import java.util.Date;

public final class LocalDateHelper {
    private static final LocalDate DEFAULT_LEGACY_DATE = LocalDate.of(1900, 1, 1);

    private LocalDateHelper (){
    }

    public static LocalDate getDefault() {
        return DEFAULT_LEGACY_DATE;
    }

    public static LocalDate getDefault(final LocalDate value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static LocalDate getDateToday (){
        return LocalDate.now();
    }
}
