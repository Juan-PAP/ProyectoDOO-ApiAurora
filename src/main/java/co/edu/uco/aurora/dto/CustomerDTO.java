package co.edu.uco.aurora.dto;

import co.edu.uco.aurora.crosscuting.helper.BooleanHelper;
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
    private Boolean confirmedPhoneNumber;
    private LocalDate birthDate;

    public CustomerDTO() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationType(IdentificationTypeDTO.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setConfirmedPhoneNumber(BooleanHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
    }

    public CustomerDTO(final UUID id) {
        super(id);
        setIdentificationType(IdentificationTypeDTO.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setConfirmedPhoneNumber(BooleanHelper.getDefault());
        setBirthDate(LocalDateHelper.getDefault());
    }

    public CustomerDTO(final UUID id, final IdentificationTypeDTO identificationType, final String identificationNumber,
                          final String fullName, final String phoneNumber, final boolean confirmedPhoneNumber,
                          final LocalDate birthDate) {
        super(id);
        setIdentificationType(identificationType);
        setIdentificationNumber(identificationNumber);
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        setConfirmedPhoneNumber(confirmedPhoneNumber);
        setBirthDate(birthDate);
    }

    public IdentificationTypeDTO getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationTypeDTO identificationType) {
        this.identificationType =
                ObjectHelper.getDefault(identificationType, IdentificationTypeDTO.createDefault());
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = TextHelper.getDefaultWithTrim(fullName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = TextHelper.getDefaultWithTrim(phoneNumber);
    }

    public boolean getConfirmedPhoneNumber() {
        return confirmedPhoneNumber;
    }

    public void setConfirmedPhoneNumber(Boolean confirmedPhoneNumber) {
        this.confirmedPhoneNumber = BooleanHelper.getDefault(confirmedPhoneNumber);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = LocalDateHelper.getDefault(birthDate);
    }

    public static CustomerDTO getDefault() {
        return new CustomerDTO();
    }
}
