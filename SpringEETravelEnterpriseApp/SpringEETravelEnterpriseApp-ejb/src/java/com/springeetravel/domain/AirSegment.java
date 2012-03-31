/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "AIR_SEGMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AirSegment.findAll", query = "SELECT a FROM AirSegment a"),
    @NamedQuery(name = "AirSegment.findById", query = "SELECT a FROM AirSegment a WHERE a.id = :id"),
    @NamedQuery(name = "AirSegment.findByCreateDate", query = "SELECT a FROM AirSegment a WHERE a.createDate = :createDate")})
public class AirSegment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "UNIVERSAL_RECORD_ID", referencedColumnName = "ID")
    @ManyToOne
    private UniversalRecord universalRecordId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "airSegmentId")
    private List<FormOfPayment> formOfPaymentList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "airSegmentId")
    private FlightDetail flightDetail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "airSegmentId")
    private List<PassengerDetail> passengerDetailList;

    public AirSegment() {
    }

    public AirSegment(Long id) {
        this.id = id;
    }

    public AirSegment(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UniversalRecord getUniversalRecordId() {
        return universalRecordId;
    }

    public void setUniversalRecordId(UniversalRecord universalRecordId) {
        this.universalRecordId = universalRecordId;
    }

    @XmlTransient
    public List<FormOfPayment> getFormOfPaymentList() {
        return formOfPaymentList;
    }

    public void setFormOfPaymentList(List<FormOfPayment> formOfPaymentList) {
        this.formOfPaymentList = formOfPaymentList;
    }

    public FlightDetail getFlightDetail() {
        return flightDetail;
    }

    public void setFlightDetail(FlightDetail flightDetail) {
        this.flightDetail = flightDetail;
    }

    @XmlTransient
    public List<PassengerDetail> getPassengerDetailList() {
        return passengerDetailList;
    }

    public void setPassengerDetailList(List<PassengerDetail> passengerDetailList) {
        this.passengerDetailList = passengerDetailList;
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
        if (!(object instanceof AirSegment)) {
            return false;
        }
        AirSegment other = (AirSegment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.travelport.domain.AirSegment[ id=" + id + " ]";
    }
}
