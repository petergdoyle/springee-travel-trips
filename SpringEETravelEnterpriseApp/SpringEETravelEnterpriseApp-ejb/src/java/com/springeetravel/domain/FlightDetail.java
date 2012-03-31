/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "FLIGHT_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlightDetail.findAll", query = "SELECT f FROM FlightDetail f"),
    @NamedQuery(name = "FlightDetail.findById", query = "SELECT f FROM FlightDetail f WHERE f.id = :id"),
    @NamedQuery(name = "FlightDetail.findByDepartureAirportCode", query = "SELECT f FROM FlightDetail f WHERE f.departureAirportCode = :departureAirportCode"),
    @NamedQuery(name = "FlightDetail.findByDepartureTime", query = "SELECT f FROM FlightDetail f WHERE f.departureTime = :departureTime"),
    @NamedQuery(name = "FlightDetail.findByArrivalAirportCode", query = "SELECT f FROM FlightDetail f WHERE f.arrivalAirportCode = :arrivalAirportCode"),
    @NamedQuery(name = "FlightDetail.findByArrivalTime", query = "SELECT f FROM FlightDetail f WHERE f.arrivalTime = :arrivalTime"),
    @NamedQuery(name = "FlightDetail.findByAirline", query = "SELECT f FROM FlightDetail f WHERE f.airline = :airline"),
    @NamedQuery(name = "FlightDetail.findByAirlineCode", query = "SELECT f FROM FlightDetail f WHERE f.airlineCode = :airlineCode"),
    @NamedQuery(name = "FlightDetail.findByAirlineFlightNumber", query = "SELECT f FROM FlightDetail f WHERE f.airlineFlightNumber = :airlineFlightNumber"),
    @NamedQuery(name = "FlightDetail.findByClassOfService", query = "SELECT f FROM FlightDetail f WHERE f.classOfService = :classOfService"),
    @NamedQuery(name = "FlightDetail.findByPrice", query = "SELECT f FROM FlightDetail f WHERE f.price = :price")})
public class FlightDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEPARTURE_AIRPORT_CODE")
    private String departureAirportCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPARTURE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ARRIVAL_AIRPORT_CODE")
    private String arrivalAirportCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARRIVAL_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AIRLINE")
    private String airline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AIRLINE_CODE")
    private String airlineCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AIRLINE_FLIGHT_NUMBER")
    private String airlineFlightNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLASS_OF_SERVICE")
    private String classOfService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @OneToOne
    @JoinColumn(name = "AIR_SEGMENT_ID", referencedColumnName = "ID")
    private AirSegment airSegmentId;

    public FlightDetail() {
    }

    public FlightDetail(Long id) {
        this.id = id;
    }

    public FlightDetail(Long id, String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price) {
        this.id = id;
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
        return "com.travelport.domain.FlightDetail[ id=" + id + " ]";
    }
    
}
