/*
 */
package com.springeetravel.manager;

import com.springeetravel.dataaccess.UniversalRecordDao;
import com.springeetravel.domain.UniversalRecord;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Named("universalRecordResourceManager")
public class UniversalRecordResourceManager {

    @Inject
    @Named("universalRecordDao")
    private UniversalRecordDao dao;

    public UniversalRecord retrieveUniversalRecord(String id) {
        return dao.findByLocatorCode(id);
    }
}
