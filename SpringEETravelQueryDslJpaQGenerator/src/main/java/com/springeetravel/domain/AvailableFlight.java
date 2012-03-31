/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author peter
 */
public class AvailableFlight implements Serializable {

    private static final long serialVersionUID = -4803591318658711268L;
    private String id;
    private String departureAirportCode;
    private Date departureTime;
    private String arrivalAirportCode;
    private Date arrivalTime;
    private String airline;
    private String airlineCode;
    private String airlineFlightNumber;
    private String classOfService;
    private double price;

    public AvailableFlight() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AvailableFlight)) {
            return false;
        }
        AvailableFlight other = (AvailableFlight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AvailableFlight{" + "id=" + id + ", departureAirportCode=" + departureAirportCode + ", departureTime=" + departureTime + ", arrivalAirportCode=" + arrivalAirportCode + ", arrivalTime=" + arrivalTime + ", airline=" + airline + ", airlineCode=" + airlineCode + ", airlineFlightNumber=" + airlineFlightNumber + ", classOfService=" + classOfService + ", price=" + price + '}';
    }
}
