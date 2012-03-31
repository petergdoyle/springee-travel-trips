/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.springdata.mongo.AvailableFlightRepository;
import com.springeetravel.domain.AirSearchCriteria;
import com.springeetravel.domain.AvailableFlight;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Transactional
@Named("airSearchManager")
public class AirSearchManager {

    @Inject
    private AvailableFlightRepository repo;

    public void addAvailableFlight(AvailableFlight availableFlight) {
        repo.save(availableFlight);
    }

    public List<AvailableFlight> searchDepartureFlights(AirSearchCriteria airSearchCriteria) {
        return repo.findByDepartureAirportCode(airSearchCriteria.getDepartureAirportCode());
    }

    public List<AvailableFlight> searchReturnFlights(AirSearchCriteria airSearchCriteria) {
        return repo.findByArrivalAirportCode(airSearchCriteria.getArrivalAirportCode());
    }
}
