/*
 */
package com.springeetravel.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "FORM_OF_PAYMENTS")
@XStreamAlias("FormOfPayment")
@NamedQueries({
    @NamedQuery(name = "FormOfPayment.findAll", query = "SELECT f FROM FormOfPayment f"),
    @NamedQuery(name = "FormOfPayment.findById", query = "SELECT f FROM FormOfPayment f WHERE f.id = :id"),
    @NamedQuery(name = "FormOfPayment.findByFormOfPaymentType", query = "SELECT f FROM FormOfPayment f WHERE f.formOfPaymentType = :formOfPaymentType"),
    @NamedQuery(name = "FormOfPayment.findByCreditCardNumber", query = "SELECT f FROM FormOfPayment f WHERE f.creditCardNumber = :creditCardNumber"),
    @NamedQuery(name = "FormOfPayment.findByCreditCardName", query = "SELECT f FROM FormOfPayment f WHERE f.creditCardName = :creditCardName"),
    @NamedQuery(name = "FormOfPayment.findByCreditExpiry", query = "SELECT f FROM FormOfPayment f WHERE f.creditExpiry = :creditExpiry"),
    @NamedQuery(name = "FormOfPayment.findByCreditCcid", query = "SELECT f FROM FormOfPayment f WHERE f.creditCcid = :creditCcid")})
public class FormOfPayment implements Serializable {

    private static final long serialVersionUID = -8476051062250765909L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "FORM_OF_PAYMENT_TYPE")
    private String formOfPaymentType;
    @Column(name = "CREDIT_CARD_NUMBER")
    private String creditCardNumber;
    @Column(name = "CREDIT_CARD_NAME")
    private String creditCardName;
    @Column(name = "CREDIT_EXPIRY")
    private String creditExpiry;
    @Column(name = "CREDIT_CCID")
    private String creditCcid;
    @JoinColumn(name = "AIR_SEGMENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
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

    public String getFormOfPaymentType() {
        return formOfPaymentType;
    }

    public void setFormOfPaymentType(String formOfPaymentType) {
        this.formOfPaymentType = formOfPaymentType;
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
        return "FormOfPayment{" + "id=" + id + ", formOfPaymentType=" + formOfPaymentType + ", creditCardNumber=" + creditCardNumber + ", creditCardName=" + creditCardName + ", creditExpiry=" + creditExpiry + ", creditCcid=" + creditCcid + '}';
    }
}
