package co.edu.uco.aurora.crosscuting.helper;

public class FloatHelper {

    private static final Float DEFAULT = 0.0f;

    private FloatHelper () {
    }

    public static Float getDefault() {
        return DEFAULT;
    }

    public static Float getDefault(final Float value) {
        return ObjectHelper.getDefault(value, getDefault());
    }
}