/*
 */
package com.springeetravel.domain;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
@Entity
public class UniversalRecord implements Serializable {

    private static final long serialVersionUID = 6434506583201369712L;
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
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "UniversalRecord{" + "id=" + id + ", createDate=" + createDate + ", airSegmentList=" + airSegmentList + '}';
    }
}
