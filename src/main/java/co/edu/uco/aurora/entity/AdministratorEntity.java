package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class AdministratorEntity extends Entity {

    private String user;
    private String password;

    public AdministratorEntity() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUser(TextHelper.getDefault());
        setPassword(TextHelper.getDefault());
    }

    public AdministratorEntity(final UUID id) {
        super(id);
        setUser(TextHelper.getDefault());
        setPassword(TextHelper.getDefault());
    }


    public AdministratorEntity(final UUID id, final String user, final String password) {
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

    public static AdministratorEntity createDefault() { return new AdministratorEntity();}

}
