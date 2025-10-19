package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class CustomerDomain extends Domain{

    private IdentificationTypeDomain identificationType;
    private String identificationNumber;
    private String fullName;
    private String phoneNumber;
    private LocalDate birthDate;
    private boolean confirmedPhoneNumber;
    private boolean confirmedPhoneNumberDefualtValue;

    public CustomerDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeDomain.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
        setConfirmedPhoneNumber(false);
        setConfirmedPhoneNumberDefualtValue(true);
    }

    public CustomerDomain (final UUID id) {
        super(id);
        setIdentificationType(IdentificationTypeDomain.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
        setConfirmedPhoneNumber(false);
        setConfirmedPhoneNumberDefualtValue(true);
    }
    public CustomerDomain (final UUID id, final IdentificationTypeDomain identificationType, final String identificationNumber,
                           final String fullName, final String phoneNumber, final boolean confirmedPhoneNumber, final LocalDate birthDate) {
        super(id);
        setIdentificationType(identificationType);
        setIdentificationNumber(identificationNumber);
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        setBirthDate(birthDate);
        setConfirmedPhoneNumber(confirmedPhoneNumber);
        setConfirmedPhoneNumberDefualtValue(false);
    }

    public IdentificationTypeDomain getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final IdentificationTypeDomain identificationType) {
        this.identificationType =
                ObjectHelper.getDefault(identificationType, IdentificationTypeDomain.createDefault());
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

    public boolean isConfirmedPhoneNumber() {
        return confirmedPhoneNumber;
    }

    public void setConfirmedPhoneNumber(final boolean confirmedPhoneNumber) {
        this.confirmedPhoneNumber = confirmedPhoneNumber;
        setConfirmedPhoneNumberDefualtValue(false);
    }

    public boolean isConfirmedPhoneNumberDefualtValue() {
        return confirmedPhoneNumberDefualtValue;
    }

    public void setConfirmedPhoneNumberDefualtValue(final boolean confirmedPhoneNumberDefualtValue) {
        this.confirmedPhoneNumberDefualtValue = confirmedPhoneNumberDefualtValue;
    }

    public static CustomerDomain getDefault() {
        return new CustomerDomain();
    }
}
