/*
 */
package com.springeetravel.dataaccess.springdata.generic;

import com.springeetravel.domain.FlightDetail;
import org.springframework.data.repository.CrudRepository;

/**
 *  the generic definition (CrudRepository from data commons) of the FlightRepository 
 * @author peter
 */
public interface FlightRepository extends CrudRepository<FlightDetail, Long> {
    
}
