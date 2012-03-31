/*
 */
package com.travelport.dataaccess;

import com.travelport.dataaccess.exceptions.IllegalOrphanException;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.Flight;
import java.util.List;

/**
 *
 * @author peter
 */
public interface FlightDao {

    void create(Flight flight);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(Flight flight) throws IllegalOrphanException, NonexistentEntityException, Exception;

    Flight findFlight(Long id);

    List<Flight> findFlightEntities();

    List<Flight> findFlightEntities(int maxResults, int firstResult);

    int getFlightCount();
    
}
