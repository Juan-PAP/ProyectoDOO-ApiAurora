package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class AdministratorDomain extends Domain{

    private String user;
    private String password;

    public AdministratorDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUser(TextHelper.getDefault());
        setPassword(TextHelper.getDefault());
    }

    public AdministratorDomain (final UUID id) {
        super(id);
        setUser(TextHelper.getDefault());
        setPassword(TextHelper.getDefault());
    }

    public AdministratorDomain (final UUID id, final String user, final String password) {
        super(id);
        setUser(user);
        setPassword(password);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = TextHelper.getDefaultWithTrim(user);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = TextHelper.getDefault(password);
    }
}
