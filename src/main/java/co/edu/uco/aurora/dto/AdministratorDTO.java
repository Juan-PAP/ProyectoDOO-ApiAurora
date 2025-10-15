package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class AdministratorDTO extends DTO{

    private String user;
    private String password;

    public AdministratorDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUser(TextHelper.getDefault());
        setPassword(TextHelper.getDefault());
    }

    public AdministratorDTO(final UUID id) {
        super(id);
        setUser(TextHelper.getDefault());
        setPassword(TextHelper.getDefault());
    }

    public AdministratorDTO(final UUID id, final String user, final String password) {
        super(id);
        setUser(user);
        setPassword(password);
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = TextHelper.getDefaultWithTrim(user);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = TextHelper.getDefault(password);
    }
}
