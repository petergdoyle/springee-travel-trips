/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author peter
 */
public class FlightDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String departureAirportCode;
    private Date departureTime;
    private String arrivalAirportCode;
    private Date arrivalTime;
    private String airline;
    private String airlineCode;
    private String airlineFlightNumber;
    private String classOfService;
    private double price;
    private AirSegment airSegmentId;

    public FlightDetail() {
    }

    public FlightDetail(Long id) {
        this.id = id;
    }

    public FlightDetail(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price) {
        this.departureAirportCode = departureAirportCode;
        this.departureTime = departureTime;
        this.arrivalAirportCode = arrivalAirportCode;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.airlineCode = airlineCode;
        this.airlineFlightNumber = airlineFlightNumber;
        this.classOfService = classOfService;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineFlightNumber() {
        return airlineFlightNumber;
    }

    public void setAirlineFlightNumber(String airlineFlightNumber) {
        this.airlineFlightNumber = airlineFlightNumber;
    }

    public String getClassOfService() {
        return classOfService;
    }

    public void setClassOfService(String classOfService) {
        this.classOfService = classOfService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        if (!(object instanceof FlightDetail)) {
            return false;
        }
        FlightDetail other = (FlightDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springee.domain.FlightDetail[ id=" + id + " ]";
    }
}
