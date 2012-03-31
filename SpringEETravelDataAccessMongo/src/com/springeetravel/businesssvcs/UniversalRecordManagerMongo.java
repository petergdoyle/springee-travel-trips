/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.dao.UniversalRecordDao;
import com.springeetravel.domain.UniversalRecord;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author peter
 */
@Named("universalRecordManagerMongo")
public class UniversalRecordManagerMongo extends AbstractUniversalRecordManager {
    
    @Inject
    @Named("universalRecordRepositoryMongo")
    private UniversalRecordDao repo;

    @Override
    public void saveUniversalRecord(UniversalRecord ur) {
        repo.create(ur);
    }

    @Override
    public UniversalRecord retrieveUniversalRecord(String id) {
        return repo.find(id);
    }

    @Override
    public int countUniversalRecord() {
        return repo.getCount();
    }
    
}
