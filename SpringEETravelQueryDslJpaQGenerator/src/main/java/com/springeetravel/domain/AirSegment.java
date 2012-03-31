/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author peter
 */
public class AirSegment implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Date createDate;
    private FlightDetail flightDetail;
    private List<FormOfPayment> formOfPaymentList;
    private List<PassengerDetail> passengerDetailList;
    private UniversalRecord universalRecordId;

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

    public List<FormOfPayment> getFormOfPaymentList() {
        return formOfPaymentList;
    }

    public void setFormOfPaymentList(List<FormOfPayment> formOfPaymentList) {
        this.formOfPaymentList = formOfPaymentList;
    }

    public List<PassengerDetail> getPassengerDetailList() {
        return passengerDetailList;
    }

    public void setPassengerDetailList(List<PassengerDetail> passengerDetailList) {
        this.passengerDetailList = passengerDetailList;
    }

    public FlightDetail getFlightDetail() {
        return flightDetail;
    }

    public void setFlightDetail(FlightDetail flightDetail) {
        this.flightDetail = flightDetail;
    }

    public UniversalRecord getUniversalRecordId() {
        return universalRecordId;
    }

    public void setUniversalRecordId(UniversalRecord universalRecordId) {
        this.universalRecordId = universalRecordId;
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
        return "com.springee.domain.AirSegment[ id=" + id + " ]";
    }
}
