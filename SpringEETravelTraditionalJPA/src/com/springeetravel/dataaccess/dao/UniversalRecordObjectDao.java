/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.UniversalRecordObject;
import java.util.List;

/**
 *
 * @author peter
 */
public interface UniversalRecordObjectDao {

    void create(UniversalRecordObject universalRecord);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(UniversalRecordObject universalRecord) throws IllegalOrphanException, NonexistentEntityException;

    UniversalRecordObject find(Long id);

    List<UniversalRecordObject> find();

    List<UniversalRecordObject> find(int maxResults, int firstResult);

    int getCount();
    
}
