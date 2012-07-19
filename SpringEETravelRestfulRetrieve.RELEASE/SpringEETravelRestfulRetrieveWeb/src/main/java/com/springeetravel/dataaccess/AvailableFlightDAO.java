/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.AvailableFlight;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public interface AvailableFlightDAO {

    List<AvailableFlight> findByDepartureAirportCode(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime);
    
}
