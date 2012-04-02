/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author peter
 */
@Entity
public class UniversalRecord implements Serializable {

    private static final long serialVersionUID = -2474789049095205331L;
    @Id
    private String id;
    private Date createDate;
    private List<AirSegment> airSegmentList;

    public UniversalRecord() {
    }

    public UniversalRecord(String id) {
        this.id = id;
    }

    public List<AirSegment> getAirSegmentList() {
        return airSegmentList;
    }

    public void setAirSegmentList(List<AirSegment> airSegmentList) {
        this.airSegmentList = airSegmentList;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "UniversalRecord{" + "id=" + id + ", createDate=" + createDate + ", airSegmentList=" + airSegmentList + '}';
    }
}
