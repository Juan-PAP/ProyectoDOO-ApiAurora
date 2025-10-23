package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class CustomerDTO extends DTO {

    private IdentificationTypeDTO identificationType;
    private String identificationNumber;
    private String fullName;
    private String phoneNumber;
    private LocalDate birthDate;
    private boolean phoneNumberConfirmed;
    private boolean phoneNumberIsConfirmedDefualtValue;

    public CustomerDTO () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeDTO.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
        setPhoneNumberConfirmed(false);
        setPhoneNumberIsConfirmedDefualtValue(true);
    }

    public CustomerDTO(final UUID id) {
        super(id);
        setIdentificationType(IdentificationTypeDTO.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
        setPhoneNumberConfirmed(false);
        setPhoneNumberIsConfirmedDefualtValue(true);
    }
    public CustomerDTO (final UUID id, final IdentificationTypeDTO identificationType, final String identificationNumber,
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

    public IdentificationTypeDTO getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(final IdentificationTypeDTO identificationType) {
        this.identificationType =
                ObjectHelper.getDefault(identificationType, IdentificationTypeDTO.createDefault());
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

    public static CustomerDTO getDefault() {
        return new CustomerDTO();
    }
}
