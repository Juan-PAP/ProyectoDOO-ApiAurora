package co.edu.uco.aurora.business.domain;

import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;

public class CustomerDomain extends Domain{

    private IdentificationTypeDomain identificationTypeDomain;
    private String identificationNumber;
    private String fullName;
    private String phoneNumber;
    private boolean confirmedPhoneNumber;
    private LocalDate birthDate;

    public CustomerDomain () {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdentificationTypeDomain(IdentificationTypeDomain.createDefault());
        setIdentificationNumber(TextHelper.getDefault());
        setFullName(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setConfirmedPhoneNumber(false);
        setBirthDate(LocalDate.now());
    }

    public IdentificationTypeDomain getIdentificationTypeDomain() {
        return identificationTypeDomain;
    }

    public void setIdentificationTypeDomain(IdentificationTypeDomain identificationTypeDomain) {
        this.identificationTypeDomain =
                ObjectHelper.getDefault(identificationTypeDomain, IdentificationTypeDomain.createDefault());
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

    public void setConfirmedPhoneNumber( boolean confirmedPhoneNumber) {
        this.confirmedPhoneNumber = false;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
