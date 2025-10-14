package co.edu.uco.aurora.crosscuting.exception;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public final class AuroraException extends RuntimeException {

    private static final long serialVersionUID = -7034897190745766939L;
    private Throwable rootException;
    private String userMessage;
    private String technicalMessage;

    private AuroraException(final Throwable rootException, final String userMessage, final String technicalMessage) {
      setRootException(rootException);
      setUserMessage(userMessage);
      setTechnicalMessage(technicalMessage);
    }

    public static AuroraException create(final String userMessage) {
        return new AuroraException(new Exception(), userMessage, userMessage);
    }

    public static AuroraException create(final String userMessage, final String technicalMessage) {
        return new AuroraException(new Exception(), userMessage, technicalMessage);
    }

    public static AuroraException create(final Throwable rootException, final String userMessage, final String technicalMessage) {
        return new AuroraException(rootException, userMessage, technicalMessage);
    }

    public Throwable getRootException() {
        return rootException;
    }

    public void setRootException(Throwable rootException) {
        this.rootException = ObjectHelper.getDefault(rootException, new Exception());
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
    }

    public static long getSerialVersionUID () {
        return serialVersionUID;
    }
}
