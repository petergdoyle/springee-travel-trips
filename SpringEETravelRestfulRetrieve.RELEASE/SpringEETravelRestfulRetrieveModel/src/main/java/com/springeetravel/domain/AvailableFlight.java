/*
 */
package com.springeetravel.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author peter
 */
@Entity
@Table(name = "AVAILABLE_FLIGHTS")
@XStreamAlias("AvailableFlight")
@NamedQueries({
    @NamedQuery(name = "AvailableFlight.findAll", query = "SELECT a FROM AvailableFlight a"),
    @NamedQuery(name = "AvailableFlight.findById", query = "SELECT a FROM AvailableFlight a WHERE a.id = :id"),
    @NamedQuery(name = "AvailableFlight.findBySearchCriteria", query = "SELECT a FROM AvailableFlight a WHERE a.departureAirportCode = :departureAirportCode"),
    @NamedQuery(name = "AvailableFlight.findByDepartureAirportCode", query = "SELECT a FROM AvailableFlight a WHERE a.departureAirportCode = :departureAirportCode"),
    @NamedQuery(name = "AvailableFlight.findByDepartureTime", query = "SELECT a FROM AvailableFlight a WHERE a.departureTime = :departureTime"),
    @NamedQuery(name = "AvailableFlight.findByArrivalAirportCode", query = "SELECT a FROM AvailableFlight a WHERE a.arrivalAirportCode = :arrivalAirportCode"),
    @NamedQuery(name = "AvailableFlight.findByArrivalTime", query = "SELECT a FROM AvailableFlight a WHERE a.arrivalTime = :arrivalTime"),
    @NamedQuery(name = "AvailableFlight.findByAirline", query = "SELECT a FROM AvailableFlight a WHERE a.airline = :airline"),
    @NamedQuery(name = "AvailableFlight.findByAirlineCode", query = "SELECT a FROM AvailableFlight a WHERE a.airlineCode = :airlineCode"),
    @NamedQuery(name = "AvailableFlight.findByAirlineFlightNumber", query = "SELECT a FROM AvailableFlight a WHERE a.airlineFlightNumber = :airlineFlightNumber"),
    @NamedQuery(name = "AvailableFlight.findByClassOfService", query = "SELECT a FROM AvailableFlight a WHERE a.classOfService = :classOfService"),
    @NamedQuery(name = "AvailableFlight.findByPrice", query = "SELECT a FROM AvailableFlight a WHERE a.price = :price")})
public class AvailableFlight implements Serializable {

    private static final long serialVersionUID = -4803591318658711268L;
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
    @Transient
    private boolean selected;

    public AvailableFlight() {
    }

    public AvailableFlight(Long id) {
        this.id = id;
    }

    public AvailableFlight(Long id, String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price) {
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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
        return "com.travelport.domain.AvailableFlight[ id=" + id + " ]";
    }
}
