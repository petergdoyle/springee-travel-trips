/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author peter
 */
public class PassengerDetail implements Serializable {

    private static final long serialVersionUID = -4886433855009176095L;
    private Long id;
    private String firstName;
    private String lastName;
    private String initials;
    private String contactPhone;
    private String contactEmail;
    private String countryOfResidenceCode;
    private String countryOfNationalityCode;
    private String passportId;
    private Date dateOfBirth;
    private Boolean valuedCustomer;
    private AirSegment airSegmentId;

    public PassengerDetail() {
    }

    public PassengerDetail(Long id) {
        this.id = id;
    }

    public PassengerDetail(String firstName, String lastName, String initials, String contactPhone, String contactEmail, String countryOfResidenceCode, String countryOfNationalityCode, String passportId, Date dateOfBirth, Boolean valuedCustomer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.countryOfResidenceCode = countryOfResidenceCode;
        this.countryOfNationalityCode = countryOfNationalityCode;
        this.passportId = passportId;
        this.dateOfBirth = dateOfBirth;
        this.valuedCustomer = valuedCustomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getCountryOfResidenceCode() {
        return countryOfResidenceCode;
    }

    public void setCountryOfResidenceCode(String countryOfResidenceCode) {
        this.countryOfResidenceCode = countryOfResidenceCode;
    }

    public String getCountryOfNationalityCode() {
        return countryOfNationalityCode;
    }

    public void setCountryOfNationalityCode(String countryOfNationalityCode) {
        this.countryOfNationalityCode = countryOfNationalityCode;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getValuedCustomer() {
        return valuedCustomer;
    }

    public void setValuedCustomer(Boolean valuedCustomer) {
        this.valuedCustomer = valuedCustomer;
    }

    public AirSegment getAirSegmentId() {
        return airSegmentId;
    }

    public void setAirSegmentId(AirSegment airSegmentId) {
        this.airSegmentId = airSegmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassengerDetail)) {
            return false;
        }
        PassengerDetail other = (PassengerDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PassengerDetail{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", initials=" + initials + ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail + ", countryOfResidenceCode=" + countryOfResidenceCode + ", countryOfNationalityCode=" + countryOfNationalityCode + ", passportId=" + passportId + ", dateOfBirth=" + dateOfBirth + ", valuedCustomer=" + valuedCustomer + '}';
    }
}
