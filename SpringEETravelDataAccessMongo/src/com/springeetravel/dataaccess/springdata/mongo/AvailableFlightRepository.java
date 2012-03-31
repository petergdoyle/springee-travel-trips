/*
 */
package com.springeetravel.dataaccess.springdata.mongo;

import com.springeetravel.domain.AvailableFlight;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author peter
 */
public interface AvailableFlightRepository extends MongoRepository<AvailableFlight, String> {

    @Query("{ departureAirportCode: ?0 }")
    List<AvailableFlight> findByDepartureAirportCode(String departureAirportCode);

    @Query("{ arrivalAirportCode: ?0 }")
    List<AvailableFlight> findByArrivalAirportCode(String arrivalAirportCode);
}
