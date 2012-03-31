/*
 */
package com.springeetravel.domain;

import java.io.Serializable;

/**
 *
 * @author peter
 */
public class FormOfPayment implements Serializable {

    private static final long serialVersionUID = -8476051062250765909L;
    private Long id;
    private String formOfPaymentType;
    private String creditCardNumber;
    private String creditCardName;
    private String creditExpiry;
    private String creditCcid;
    private AirSegment airSegmentId;

    public FormOfPayment() {
    }

    public FormOfPayment(Long id) {
        this.id = id;
    }

    public FormOfPayment(String formOfPaymentType, String creditCardNumber, String creditCardName, String creditExpiry, String creditCcid) {
        this.formOfPaymentType = formOfPaymentType;
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.creditExpiry = creditExpiry;
        this.creditCcid = creditCcid;
    }

    public FormOfPayment(Long id, String formOfPaymentType) {
        this.id = id;
        this.formOfPaymentType = formOfPaymentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public void setCreditExpiry(String creditExpiry) {
        this.creditExpiry = creditExpiry;
    }

    public String getCreditCcid() {
        return creditCcid;
    }

    public void setCreditCcid(String creditCcid) {
        this.creditCcid = creditCcid;
    }

    public AirSegment getAirSegmentId() {
        return airSegmentId;
    }

    public void setAirSegmentId(AirSegment airSegmentId) {
        this.airSegmentId = airSegmentId;
    }

    public String getFormOfPaymentType() {
        return formOfPaymentType;
    }

    public void setFormOfPaymentType(String formOfPaymentType) {
        this.formOfPaymentType = formOfPaymentType;
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
        if (!(object instanceof FormOfPayment)) {
            return false;
        }
        FormOfPayment other = (FormOfPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.travelport.domain.FormOfPayment[ id=" + id + " ]";
    }
}
