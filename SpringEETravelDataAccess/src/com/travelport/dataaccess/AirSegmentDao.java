/*
 */
package com.travelport.dataaccess;

import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.AirSegment;
import java.util.List;

/**
 *
 * @author peter
 */
public interface AirSegmentDao {

    void create(AirSegment airSegment);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(AirSegment airSegment) throws NonexistentEntityException, Exception;

    AirSegment findAirSegment(Long id);

    List<AirSegment> findAirSegmentEntities();

    List<AirSegment> findAirSegmentEntities(int maxResults, int firstResult);

    int getAirSegmentCount();
    
}
