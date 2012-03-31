/*
 */
package com.springeetravel.dataaccess.springdata.generic;

import com.springeetravel.domain.AvailableFlight;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author peter
 */
public interface AvailableFlightRepository extends CrudRepository<AvailableFlight, Long> {

//    @Query(name = "AvailableFlight.findByDepartureAirportCode")
    List<AvailableFlight> findByDepartureAirportCode(@Param("departureAirportCode") String departureAirportCode);

//    @Query(name = "AvailableFlight.findByArrivalAirportCode")
    List<AvailableFlight> findByArrivalAirportCode(@Param("arrivalAirportCode") String arrivalAirportCode);

    @Query("SELECT a FROM AvailableFlight a WHERE a.arrivalAirportCode = :arrivalAirportCode and a.departureAirportCode = :departureAirportCode")
    List<AvailableFlight> findByAirportCodes(@Param("arrivalAirportCode") String arrivalAirportCode, @Param("departureAirportCode") String departureAirportCode);
}
