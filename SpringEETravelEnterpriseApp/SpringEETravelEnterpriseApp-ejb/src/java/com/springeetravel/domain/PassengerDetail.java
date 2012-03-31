/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "PASSENGER_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PassengerDetail.findAll", query = "SELECT p FROM PassengerDetail p"),
    @NamedQuery(name = "PassengerDetail.findById", query = "SELECT p FROM PassengerDetail p WHERE p.id = :id"),
    @NamedQuery(name = "PassengerDetail.findByFirstName", query = "SELECT p FROM PassengerDetail p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PassengerDetail.findByLastName", query = "SELECT p FROM PassengerDetail p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PassengerDetail.findByInitials", query = "SELECT p FROM PassengerDetail p WHERE p.initials = :initials"),
    @NamedQuery(name = "PassengerDetail.findByContactPhone", query = "SELECT p FROM PassengerDetail p WHERE p.contactPhone = :contactPhone"),
    @NamedQuery(name = "PassengerDetail.findByContactEmail", query = "SELECT p FROM PassengerDetail p WHERE p.contactEmail = :contactEmail"),
    @NamedQuery(name = "PassengerDetail.findByCountryOfResidenceCode", query = "SELECT p FROM PassengerDetail p WHERE p.countryOfResidenceCode = :countryOfResidenceCode"),
    @NamedQuery(name = "PassengerDetail.findByCountryOfNationalityCode", query = "SELECT p FROM PassengerDetail p WHERE p.countryOfNationalityCode = :countryOfNationalityCode"),
    @NamedQuery(name = "PassengerDetail.findByPassportId", query = "SELECT p FROM PassengerDetail p WHERE p.passportId = :passportId"),
    @NamedQuery(name = "PassengerDetail.findByDateOfBirth", query = "SELECT p FROM PassengerDetail p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "PassengerDetail.findByValuedCustomer", query = "SELECT p FROM PassengerDetail p WHERE p.valuedCustomer = :valuedCustomer")})
public class PassengerDetail implements Serializable {

    private static final long serialVersionUID = -6284947754074622302L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Size(min = 2, max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Size(min = 2, max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "INITIALS")
    private String initials;
    @Basic(optional = false)
    @Column(name = "CONTACT_PHONE")
    @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}")
    private String contactPhone;
    @Basic(optional = false)
    @Column(name = "CONTACT_EMAIL")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
    + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
    + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    private String contactEmail;
    @Basic(optional = false)
    @Column(name = "COUNTRY_OF_RESIDENCE_CODE")
    private String countryOfResidenceCode;
    @Basic(optional = false)
    @Column(name = "COUNTRY_OF_NATIONALITY_CODE")
    private String countryOfNationalityCode;
    @Basic(optional = false)
    @Column(name = "PASSPORT_ID")
    private String passportId;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    @Past
    private Date dateOfBirth;
    @Column(name = "VALUED_CUSTOMER")
    private Boolean valuedCustomer;
    @JoinColumn(name = "AIR_SEGMENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
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
        return "PassengerDetail{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", initials=" + initials + ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail + ", countryOfResidenceCode=" + countryOfResidenceCode + ", countryOfNationalityCode=" + countryOfNationalityCode + ", passportId=" + passportId + ", dateOfBirth=" + dateOfBirth + ", valuedCustomer=" + valuedCustomer + ", airSegmentId=" + airSegmentId + '}';
    }
}
