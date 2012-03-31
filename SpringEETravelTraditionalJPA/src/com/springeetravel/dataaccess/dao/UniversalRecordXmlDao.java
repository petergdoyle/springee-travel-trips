/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.UniversalRecordXml;
import java.util.List;

/**
 *
 * @author peter
 */
public interface UniversalRecordXmlDao {

    void create(UniversalRecordXml universalRecord);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(UniversalRecordXml universalRecord) throws IllegalOrphanException, NonexistentEntityException;

    UniversalRecordXml find(Long id);

    UniversalRecordXml findById(Long id);

    List<UniversalRecordXml> find();

    List<UniversalRecordXml> find(int maxResults, int firstResult);

    int getCount();
}
