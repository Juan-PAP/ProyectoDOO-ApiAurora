package co.edu.uco.aurora.crosscuting.helper;

public class IntegerHelper {
    private static final Integer EMPTY = 0;

    private IntegerHelper() {
    }

    public static Integer getDefault() {
        return EMPTY;
    }

    public static Integer getDefault(final Integer value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

}