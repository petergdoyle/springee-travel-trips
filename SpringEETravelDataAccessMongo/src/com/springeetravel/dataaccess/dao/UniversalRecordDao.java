/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.UniversalRecord;
import java.util.List;

/**
 *
 * @author peter
 */
public interface UniversalRecordDao {

    void create(UniversalRecord universalRecord);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(UniversalRecord universalRecord) throws IllegalOrphanException, NonexistentEntityException;

    UniversalRecord find(String id);

    List<UniversalRecord> find();

    List<UniversalRecord> find(int maxResults, int firstResult);

    int getCount();
}
