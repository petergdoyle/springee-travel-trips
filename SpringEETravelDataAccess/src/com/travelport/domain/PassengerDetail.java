/*
 */
package com.travelport.domain;

import java.io.Serializable;
import javax.persistence.*;
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
    @NamedQuery(name = "PassengerDetail.findByCountryOfResidencecode", query = "SELECT p FROM PassengerDetail p WHERE p.countryOfResidencecode = :countryOfResidencecode"),
    @NamedQuery(name = "PassengerDetail.findByCountryOfNationality", query = "SELECT p FROM PassengerDetail p WHERE p.countryOfNationality = :countryOfNationality"),
    @NamedQuery(name = "PassengerDetail.findByPassportId", query = "SELECT p FROM PassengerDetail p WHERE p.passportId = :passportId")})
public class PassengerDetail implements Serializable {

    private static final long serialVersionUID = 1193527229764160345L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "INITIALS")
    private String initials;
    @Basic(optional = false)
    @Column(name = "CONTACT_PHONE")
    private String contactPhone;
    @Basic(optional = false)
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    @Basic(optional = false)
    @Column(name = "COUNTRY_OF_RESIDENCECODE")
    private String countryOfResidencecode;
    @Basic(optional = false)
    @Column(name = "COUNTRY_OF_NATIONALITY")
    private String countryOfNationality;
    @Basic(optional = false)
    @Column(name = "PASSPORT_ID")
    private String passportId;
    @JoinColumn(name = "AIR_SEGMENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AirSegment airSegmentId;

    public PassengerDetail() {
    }

    public PassengerDetail(Long id) {
        this.id = id;
    }

    public PassengerDetail(Long id, String firstName, String lastName, String initials, String contactPhone, String contactEmail, String countryOfResidencecode, String countryOfNationality, String passportId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.countryOfResidencecode = countryOfResidencecode;
        this.countryOfNationality = countryOfNationality;
        this.passportId = passportId;
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

    public String getCountryOfResidencecode() {
        return countryOfResidencecode;
    }

    public void setCountryOfResidencecode(String countryOfResidencecode) {
        this.countryOfResidencecode = countryOfResidencecode;
    }

    public String getCountryOfNationality() {
        return countryOfNationality;
    }

    public void setCountryOfNationality(String countryOfNationality) {
        this.countryOfNationality = countryOfNationality;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
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
        return "com.travelport.domain.PassengerDetail[ id=" + id + " ]";
    }
}
