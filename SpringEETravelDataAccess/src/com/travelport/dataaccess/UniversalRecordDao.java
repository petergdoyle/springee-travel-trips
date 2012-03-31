/*
 */
package com.travelport.dataaccess;

import com.travelport.dataaccess.exceptions.IllegalOrphanException;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.UniversalRecord;
import java.util.List;

/**
 *
 * @author peter
 */
public interface UniversalRecordDao {

    void create(UniversalRecord universalRecord);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(UniversalRecord universalRecord) throws IllegalOrphanException, NonexistentEntityException, Exception;

    UniversalRecord findUniversalRecord(Long id);

    List<UniversalRecord> findUniversalRecordEntities();

    List<UniversalRecord> findUniversalRecordEntities(int maxResults, int firstResult);

    int getUniversalRecordCount();
    
}
