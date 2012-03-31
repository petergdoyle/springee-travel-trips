/*
 */
package com.travelport.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "FLIGHTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findById", query = "SELECT f FROM Flight f WHERE f.id = :id"),
    @NamedQuery(name = "Flight.findByDepartureAirportCode", query = "SELECT f FROM Flight f WHERE f.departureAirportCode = :departureAirportCode"),
    @NamedQuery(name = "Flight.findByDepartureTime", query = "SELECT f FROM Flight f WHERE f.departureTime = :departureTime"),
    @NamedQuery(name = "Flight.findByArrivalAirportCode", query = "SELECT f FROM Flight f WHERE f.arrivalAirportCode = :arrivalAirportCode"),
    @NamedQuery(name = "Flight.findByArrivalTime", query = "SELECT f FROM Flight f WHERE f.arrivalTime = :arrivalTime"),
    @NamedQuery(name = "Flight.findByAirline", query = "SELECT f FROM Flight f WHERE f.airline = :airline"),
    @NamedQuery(name = "Flight.findByAirlineCode", query = "SELECT f FROM Flight f WHERE f.airlineCode = :airlineCode"),
    @NamedQuery(name = "Flight.findByAirlineFlightNumber", query = "SELECT f FROM Flight f WHERE f.airlineFlightNumber = :airlineFlightNumber"),
    @NamedQuery(name = "Flight.findByClassOfService", query = "SELECT f FROM Flight f WHERE f.classOfService = :classOfService"),
    @NamedQuery(name = "Flight.findByPrice", query = "SELECT f FROM Flight f WHERE f.price = :price")})
public class Flight implements Serializable {

    private static final long serialVersionUID = -5745149528643946322L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DEPARTURE_AIRPORT_CODE")
    private String departureAirportCode;
    @Basic(optional = false)
    @Column(name = "DEPARTURE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Basic(optional = false)
    @Column(name = "ARRIVAL_AIRPORT_CODE")
    private String arrivalAirportCode;
    @Basic(optional = false)
    @Column(name = "ARRIVAL_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;
    @Basic(optional = false)
    @Column(name = "AIRLINE")
    private String airline;
    @Basic(optional = false)
    @Column(name = "AIRLINE_CODE")
    private String airlineCode;
    @Basic(optional = false)
    @Column(name = "AIRLINE_FLIGHT_NUMBER")
    private String airlineFlightNumber;
    @Basic(optional = false)
    @Column(name = "CLASS_OF_SERVICE")
    private String classOfService;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;
    @JoinColumn(name = "AIR_SEGMENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AirSegment airSegmentId;

    public Flight() {
    }

    public Flight(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price, AirSegment airSegmentId) {
        this.departureAirportCode = departureAirportCode;
        this.departureTime = departureTime;
        this.arrivalAirportCode = arrivalAirportCode;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.airlineCode = airlineCode;
        this.airlineFlightNumber = airlineFlightNumber;
        this.classOfService = classOfService;
        this.price = price;
        this.airSegmentId = airSegmentId;
    }

    public Flight(Long id) {
        this.id = id;
    }

    public Flight(Long id, String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price) {
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.travelport.domain.Flight[ id=" + id + " ]";
    }
}
