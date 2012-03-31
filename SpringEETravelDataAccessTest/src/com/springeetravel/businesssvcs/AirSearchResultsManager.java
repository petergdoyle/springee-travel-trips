/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.dao.AvailableFlightDao;
import com.springeetravel.dataaccess.springdata.generic.AvailableFlightRepository;
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
@Named("airSearchResultsManager")
public class AirSearchResultsManager {

    @Named("availableFlightDao")
    @Inject
    private AvailableFlightDao dao;
    @Inject
    private AvailableFlightRepository repo;

    public AvailableFlight retrieveAvailableFlight(Long availableFlightId) {
        return repo.findOne(availableFlightId);
    }

    public List<AvailableFlight> searchDepartureFlights(AirSearchCriteria airSearchCriteria) {
//        return repo.findByAirportCodes(airSearchCriteria.getDepartureAirportCode(), airSearchCriteria.getArrivalAirportCode());
        return repo.findByDepartureAirportCode(airSearchCriteria.getDepartureAirportCode());
//        return dao.find(airSearchCriteria.getDepartureAirportCode(), airSearchCriteria.getDepartureDate(), airSearchCriteria.getArrivalAirportCode(), airSearchCriteria.getDepartureDate());
    }

    public List<AvailableFlight> searchReturnFlights(AirSearchCriteria airSearchCriteria) {
//        return repo.findAll();
        return repo.findByDepartureAirportCode(airSearchCriteria.getDepartureAirportCode());
//        return repo.findByAirportCodes(airSearchCriteria.getArrivalAirportCode(), airSearchCriteria.getDepartureAirportCode());
//        return dao.find(airSearchCriteria.getArrivalAirportCode(), airSearchCriteria.getDepartureDate(), airSearchCriteria.getDepartureAirportCode(), airSearchCriteria.getDepartureDate());
    }
}
