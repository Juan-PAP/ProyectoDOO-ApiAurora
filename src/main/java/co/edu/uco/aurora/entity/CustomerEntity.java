package co.edu.uco.aurora.entity;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class CustomerEntity extends Entity{

    private IdentificationTypeEntity identificationType;
    private String identificationNumber;
    private String fullName;
    private String phoneNumber;
    private LocalDate birthDate;
    private boolean phoneNumberConfirmed;
    private boolean phoneNumberIsConfirmedDefualtValue;

    public CustomerEntity () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeEntity.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
        setPhoneNumberConfirmed(false);
        setPhoneNumberIsConfirmedDefualtValue(true);
    }

    public CustomerEntity(final UUID id) {
        super(id);
        setIdentificationType(IdentificationTypeEntity.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
        setPhoneNumberConfirmed(false);
        setPhoneNumberIsConfirmedDefualtValue(true);
    }
    public CustomerEntity (final UUID id, final IdentificationTypeEntity identificationType, final String identificationNumber,
                        final String fullName, final String phoneNumber, final boolean confirmedPhoneNumber, final LocalDate birthDate) {
        super(id);
        setIdentificationType(identificationType);
        setIdentificationNumber(identificationNumber);
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        setBirthDate(birthDate);
        setPhoneNumberConfirmed(confirmedPhoneNumber);
        setPhoneNumberIsConfirmedDefualtValue(false);
    }

    public IdentificationTypeEntity getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final IdentificationTypeEntity identificationType) {
        this.identificationType =
                ObjectHelper.getDefault(identificationType, IdentificationTypeEntity.createDefault());
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(final String identificationNumber) {
        this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = TextHelper.getDefaultWithTrim(fullName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = TextHelper.getDefaultWithTrim(phoneNumber);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = LocalDateHelper.getDefault(birthDate);
    }

    public boolean isPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(final boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
        setPhoneNumberIsConfirmedDefualtValue(false);
    }

    public boolean isPhoneNumberIsConfirmedDefualtValue() {
        return phoneNumberIsConfirmedDefualtValue;
    }

    public void setPhoneNumberIsConfirmedDefualtValue(final boolean phoneNumberIsConfirmedDefualtValue) {
        this.phoneNumberIsConfirmedDefualtValue = phoneNumberIsConfirmedDefualtValue;
    }

    public static CustomerEntity getDefault() {
        return new CustomerEntity();
    }
}
