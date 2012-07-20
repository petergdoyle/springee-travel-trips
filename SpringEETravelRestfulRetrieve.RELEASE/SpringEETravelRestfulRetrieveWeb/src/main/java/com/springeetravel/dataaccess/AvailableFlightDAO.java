/*
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public interface AvailableFlightDAO {

    List<AvailableFlight> findByDepartureAirportCode(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime);

    public List<AvailableFlight> findAll();
    
}
