/*
 */
package com.springeetravel.manager;

import com.springeetravel.dataaccess.AvailableFlightDAO;
import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.AvailableFlightSearchCriteria;
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
    AvailableFlightDAO availableFlightDAO;

    public List<AvailableFlight> search(AvailableFlightSearchCriteria availableFlightSearchCriteria) {
        List<AvailableFlight> results = null;
        results = availableFlightDAO.findByDepartureAirportCode(availableFlightSearchCriteria.getDepartureAirportCode(), availableFlightSearchCriteria.getDepartureTime(), availableFlightSearchCriteria.getArrivalAirportCode(), availableFlightSearchCriteria.getArrivalTime());
        return results;
    }
}
