/*
 */
package com.springeetravel.manager;

import com.springeetravel.dataaccess.AvailableFlightDAO;
import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.AvailableFlightSearchCriteria;
import com.springeetravel.domain.UniversalRecord;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Named
public class AvailableFlightService {

    @Inject
    @Named("availableFlightDAOJPA")
    private AvailableFlightDAO dao;

    public List<AvailableFlight> retrieveAll() {
        return dao.findAll();
    }

    public List<AvailableFlight> search(AvailableFlightSearchCriteria availableFlightSearchCriteria) {
        List<AvailableFlight> results = null;
        results = dao.findByDepartureAirportCode(availableFlightSearchCriteria.getDepartureAirportCode(), availableFlightSearchCriteria.getDepartureTime(), availableFlightSearchCriteria.getArrivalAirportCode(), availableFlightSearchCriteria.getArrivalTime());
        return results;
    }
}
