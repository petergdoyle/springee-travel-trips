/*
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author peter
 */
public class AvailableFlightSearchCriteria implements Serializable {

    private static final long serialVersionUID = -8718587866150134217L;
    private String departureAirportCode;
    private Date departureTime;
    private String arrivalAirportCode;
    private Date arrivalTime;
    private String airline;
    private String airlineCode;
    private String airlineFlightNumber;
    private String classOfService;
    private double price;

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

    public String getClassOfService() {
        return classOfService;
    }

    public void setClassOfService(String classOfService) {
        this.classOfService = classOfService;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AvailableFlightSearchCriteria{" + "departureAirportCode=" + departureAirportCode + ", departureTime=" + departureTime + ", arrivalAirportCode=" + arrivalAirportCode + ", arrivalTime=" + arrivalTime + ", airline=" + airline + ", airlineCode=" + airlineCode + ", airlineFlightNumber=" + airlineFlightNumber + ", classOfService=" + classOfService + ", price=" + price + '}';
    }
}