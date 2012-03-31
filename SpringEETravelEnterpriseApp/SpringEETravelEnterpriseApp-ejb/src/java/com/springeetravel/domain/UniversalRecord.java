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
@Table(name = "UNIVERSAL_RECORDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalRecords.findAll", query = "SELECT u FROM UniversalRecords u"),
    @NamedQuery(name = "UniversalRecords.findById", query = "SELECT u FROM UniversalRecords u WHERE u.id = :id"),
    @NamedQuery(name = "UniversalRecords.findByCreateDate", query = "SELECT u FROM UniversalRecords u WHERE u.createDate = :createDate")})
public class UniversalRecord implements Serializable {
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
    @OneToMany(mappedBy = "universalRecordId")
    private List<AirSegment> airSegmentList;

    public UniversalRecord() {
    }

    public UniversalRecord(Long id) {
        this.id = id;
    }

    public UniversalRecord(Long id, Date createDate) {
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

    @XmlTransient
    public List<AirSegment> getAirSegmentList() {
        return airSegmentList;
    }

    public void setAirSegmentList(List<AirSegment> airSegmentList) {
        this.airSegmentList = airSegmentList;
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
        if (!(object instanceof UniversalRecord)) {
            return false;
        }
        UniversalRecord other = (UniversalRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.travelport.domain.UniversalRecords[ id=" + id + " ]";
    }
    
}
