package com.springeetravel.domain;

/*
 */
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author peter
 */
@ManagedBean(name = "sharedAirSearchCriteria")
@SessionScoped
public class AirSearchCriteria implements Serializable {

    private static final long serialVersionUID = -6344389805672777303L;
    private String departureAirportCode;
    private Date departureDate;
    private String arrivalAirportCode;
    private Date arrivalDate;
    private String ticketType;
    private String classType;
    private Date returnDate;
    private Integer adultSeats;
    private Integer childSeats;
    private Long selectedDepartingFlightId;
    private Long selectedReturnFlightId;
    private Long universalRecordId;

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void clear() {
        arrivalDate = null;
        arrivalAirportCode = null;
        departureAirportCode = null;
        departureDate = null;
        ticketType = null;
        classType = null;
        returnDate = null;
        adultSeats = null;
        childSeats = null;
        universalRecordId = null;
    }

    public Integer getAdultSeats() {
        return adultSeats;
    }

    public void setAdultSeats(Integer adultSeats) {
        this.adultSeats = adultSeats;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public Integer getChildSeats() {
        return childSeats;
    }

    public void setChildSeats(Integer childSeats) {
        this.childSeats = childSeats;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Long getSelectedDepartingFlightId() {
        return selectedDepartingFlightId;
    }

    public void setSelectedDepartingFlightId(Long selectedDepartingFlightId) {
        this.selectedDepartingFlightId = selectedDepartingFlightId;
    }

    public Long getSelectedReturnFlightId() {
        return selectedReturnFlightId;
    }

    public void setSelectedReturnFlightId(Long selectedReturnFlightId) {
        this.selectedReturnFlightId = selectedReturnFlightId;
    }

    public Long getUniversalRecordId() {
        return universalRecordId;
    }

    public void setUniversalRecordId(Long universalRecordId) {
        this.universalRecordId = universalRecordId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AirSearchCriteria other = (AirSearchCriteria) obj;
        if ((this.departureAirportCode == null) ? (other.departureAirportCode != null) : !this.departureAirportCode.equals(other.departureAirportCode)) {
            return false;
        }
        if (this.departureDate != other.departureDate && (this.departureDate == null || !this.departureDate.equals(other.departureDate))) {
            return false;
        }
        if ((this.arrivalAirportCode == null) ? (other.arrivalAirportCode != null) : !this.arrivalAirportCode.equals(other.arrivalAirportCode)) {
            return false;
        }
        if (this.arrivalDate != other.arrivalDate && (this.arrivalDate == null || !this.arrivalDate.equals(other.arrivalDate))) {
            return false;
        }
        if ((this.ticketType == null) ? (other.ticketType != null) : !this.ticketType.equals(other.ticketType)) {
            return false;
        }
        if ((this.classType == null) ? (other.classType != null) : !this.classType.equals(other.classType)) {
            return false;
        }
        if (this.returnDate != other.returnDate && (this.returnDate == null || !this.returnDate.equals(other.returnDate))) {
            return false;
        }
        if (this.adultSeats != other.adultSeats && (this.adultSeats == null || !this.adultSeats.equals(other.adultSeats))) {
            return false;
        }
        if (this.childSeats != other.childSeats && (this.childSeats == null || !this.childSeats.equals(other.childSeats))) {
            return false;
        }
        if (this.selectedDepartingFlightId != other.selectedDepartingFlightId && (this.selectedDepartingFlightId == null || !this.selectedDepartingFlightId.equals(other.selectedDepartingFlightId))) {
            return false;
        }
        if (this.selectedReturnFlightId != other.selectedReturnFlightId && (this.selectedReturnFlightId == null || !this.selectedReturnFlightId.equals(other.selectedReturnFlightId))) {
            return false;
        }
        if (this.universalRecordId != other.universalRecordId && (this.universalRecordId == null || !this.universalRecordId.equals(other.universalRecordId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (this.departureAirportCode != null ? this.departureAirportCode.hashCode() : 0);
        hash = 73 * hash + (this.departureDate != null ? this.departureDate.hashCode() : 0);
        hash = 73 * hash + (this.arrivalAirportCode != null ? this.arrivalAirportCode.hashCode() : 0);
        hash = 73 * hash + (this.arrivalDate != null ? this.arrivalDate.hashCode() : 0);
        hash = 73 * hash + (this.ticketType != null ? this.ticketType.hashCode() : 0);
        hash = 73 * hash + (this.classType != null ? this.classType.hashCode() : 0);
        hash = 73 * hash + (this.returnDate != null ? this.returnDate.hashCode() : 0);
        hash = 73 * hash + (this.adultSeats != null ? this.adultSeats.hashCode() : 0);
        hash = 73 * hash + (this.childSeats != null ? this.childSeats.hashCode() : 0);
        hash = 73 * hash + (this.selectedDepartingFlightId != null ? this.selectedDepartingFlightId.hashCode() : 0);
        hash = 73 * hash + (this.selectedReturnFlightId != null ? this.selectedReturnFlightId.hashCode() : 0);
        hash = 73 * hash + (this.universalRecordId != null ? this.universalRecordId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "AirSearchCriteria{" + "departureAirportCode=" + departureAirportCode + ", departureDate=" + departureDate + ", arrivalAirportCode=" + arrivalAirportCode + ", arrivalDate=" + arrivalDate + ", ticketType=" + ticketType + ", classType=" + classType + ", returnDate=" + returnDate + ", adultSeats=" + adultSeats + ", childSeats=" + childSeats + ", selectedDepartingFlightId=" + selectedDepartingFlightId + ", selectedReturnFlightId=" + selectedReturnFlightId + '}';
    }
}
