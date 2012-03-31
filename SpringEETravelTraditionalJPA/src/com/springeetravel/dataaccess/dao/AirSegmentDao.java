/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.domain.AirSegment;
import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author peter
 */
public interface AirSegmentDao {

    void create(AirSegment airSegment);

    void destroy(Long id) throws  IllegalOrphanException, NonexistentEntityException;

    void edit(AirSegment airSegment) throws IllegalOrphanException, NonexistentEntityException;

    AirSegment find(Long id);

    List<AirSegment> find();

    List<AirSegment> find(int maxResults, int firstResult);

    int getCount();
    
}
