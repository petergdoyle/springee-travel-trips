/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "UNIVERSAL_RECORDS_XML")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalRecordXml.findAll", query = "SELECT u FROM UniversalRecordXml u"),
    @NamedQuery(name = "UniversalRecordXml.findById", query = "SELECT u FROM UniversalRecordXml u WHERE u.id = :id"),
    @NamedQuery(name = "UniversalRecordXml.findByCreateDate", query = "SELECT u FROM UniversalRecordXml u WHERE u.createDate = :createDate")})
public class UniversalRecordXml implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
//    @Lob
//    @Column(name = "XML")
//    private byte[] xml;    
    @Column(name = "XML")
    private String xml;
    @Transient
    private UniversalRecord universalRecord;

    public UniversalRecordXml() {
    }

    public UniversalRecordXml(Long id) {
        this.id = id;
    }

    public UniversalRecordXml(Long id, Date createDate) {
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

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public UniversalRecord getUniversalRecord() {
        return universalRecord;
    }

    public void setUniversalRecord(UniversalRecord universalRecord) {
        this.universalRecord = universalRecord;
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
        if (!(object instanceof UniversalRecordXml)) {
            return false;
        }
        UniversalRecordXml other = (UniversalRecordXml) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.travelport.domain.UniversalRecordXml[ id=" + id + " ]";
    }
}
