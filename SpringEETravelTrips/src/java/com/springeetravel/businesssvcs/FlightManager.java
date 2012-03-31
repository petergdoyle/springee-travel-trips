/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.dao.FlightDetailDao;
import com.springeetravel.dataaccess.springdata.generic.FlightRepository;
import com.springeetravel.domain.FlightDetail;
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

    @Named("flightDetailDao")
    @Inject
    private FlightDetailDao dao;
    @Inject
    private FlightRepository repo;

    public FlightDetail createFlight(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime, String airline, String airlineCode, String airlineFlightNumber, String classOfService, double price) {
        FlightDetail flightDetail = new FlightDetail(departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price);
//        dao.create(flightDetail);
        repo.save(flightDetail);
        return flightDetail;
    }

}
