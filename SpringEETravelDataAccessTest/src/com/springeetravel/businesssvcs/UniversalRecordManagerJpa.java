/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.dataaccess.dao.UniversalRecordDao;
import com.springeetravel.dataaccess.springdata.jpa.UniversalRecordRepositoryJpa;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("universalRecordManagerJpa")
@Transactional
public class UniversalRecordManagerJpa extends AbstractUniversalRecordManager {

    @Inject
    @Named("universalRecordDao")
    private UniversalRecordDao dao;
    @Inject
    private UniversalRecordRepositoryJpa repo;

    @Override
    public void saveUniversalRecord(UniversalRecord ur) {
        repo.save(ur);
    }

    @Override
    public UniversalRecord retrieveUniversalRecord(Long id) {
        return repo.findOne(id);
    }

    @Override
    public int countUniversalRecord() {
        Long count = repo.count();
        if (count != null) {
            return count.intValue();
        }
        return 0;
    }
}
