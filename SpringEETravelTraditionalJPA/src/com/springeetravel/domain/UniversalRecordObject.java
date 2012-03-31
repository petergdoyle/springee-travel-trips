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
@Table(name = "UNIVERSAL_RECORDS_OBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalRecordObject.findAll", query = "SELECT u FROM UniversalRecordObject u"),
    @NamedQuery(name = "UniversalRecordObject.findById", query = "SELECT u FROM UniversalRecordObject u WHERE u.id = :id"),
    @NamedQuery(name = "UniversalRecordObject.findByCreateDate", query = "SELECT u FROM UniversalRecordObject u WHERE u.createDate = :createDate")})
public class UniversalRecordObject implements Serializable {

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
    @Lob
    @Column(name = "OBJECT_VALUE")
    private byte[] objectValue;
    @Transient
    private UniversalRecord universalRecord;

    public UniversalRecordObject() {
    }

    public UniversalRecordObject(Long id) {
        this.id = id;
    }

    public UniversalRecordObject(Long id, Date createDate, UniversalRecord universalRecord) {
        this.id = id;
        this.createDate = createDate;
        this.universalRecord = universalRecord;
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

    public byte[] getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(byte[] objectValue) {
        this.objectValue = objectValue;
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
        if (!(object instanceof UniversalRecordObject)) {
            return false;
        }
        UniversalRecordObject other = (UniversalRecordObject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.travelport.domain.UniversalRecordObject[ id=" + id + " ]";
    }
}
