/*
 */
package com.springeetravel.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "UNIVERSAL_RECORDS")
@XStreamAlias("UniversalRecord")
@NamedQueries({
    @NamedQuery(name = "UniversalRecord.findAll", query = "SELECT u FROM UniversalRecord u"),
    @NamedQuery(name = "UniversalRecord.findById", query = "SELECT u FROM UniversalRecord u WHERE u.id = :id"),
    @NamedQuery(name = "UniversalRecord.findLocatorCode", query = "SELECT u FROM UniversalRecord u WHERE u.locatorCode = :locatorCode"),
    @NamedQuery(name = "UniversalRecord.findByCreateDate", query = "SELECT u FROM UniversalRecord u WHERE u.createDate = :createDate")})
public class UniversalRecord implements Serializable {

    private static final long serialVersionUID = -6895084357843205386L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "locatorCode")
    private String locatorCode;
    @Basic(optional = false)
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalRecordId")
    private List<AirSegment> airSegmentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocatorCode() {
        return locatorCode;
    }

    public void setLocatorCode(String locatorCode) {
        this.locatorCode = locatorCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlTransient
    public List<AirSegment> getAirSegmentList() {
        return airSegmentList;
    }

    public void setAirSegmentList(List<AirSegment> airSegmentList) {
        this.airSegmentList = airSegmentList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UniversalRecord other = (UniversalRecord) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "UniversalRecord{" + "id=" + id + ", locatorCode=" + locatorCode + ", createDate=" + createDate + ", airSegmentList=" + airSegmentList + '}';
    }
}
