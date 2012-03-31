/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelport.business;

import com.travelport.dataaccess.FlightDao;
import com.travelport.domain.AirSegment;
import com.travelport.domain.Flight;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("flightManager")
@Transactional
public class FlightManager {

    private static final long serialVersionUID = 286057240842159679L;
    @Named("flightDao")
    @Inject
    private FlightDao flightDao;

    public Flight createFlight(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price, AirSegment airSegmentId) {
        Flight flight = new Flight(departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price, airSegmentId);
        flightDao.create(flight);
        return flight;
    }
}
