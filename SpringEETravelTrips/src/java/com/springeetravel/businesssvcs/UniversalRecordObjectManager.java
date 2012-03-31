/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.dao.UniversalRecordObjectDao;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.UniversalRecordObject;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("universalRecordObjectManager")
@Transactional
public class UniversalRecordObjectManager extends AbstractUniversalRecordManager {

    @Inject
    private UniversalRecordObjectDao repo;

    @Override
    public void saveUniversalRecord(UniversalRecord ur) {
        Date time = Calendar.getInstance().getTime();
        UniversalRecordObject uro = new UniversalRecordObject();
        uro.setCreateDate(time);
        uro.setUniversalRecord(ur);
        repo.create(uro);
        ur.setId(uro.getId());
    }

    @Override
    public UniversalRecord retrieveUniversalRecord(Long id) {
        UniversalRecordObject find = repo.find(id);
        if (find != null) {
            return find.getUniversalRecord();
        }
        return null;
    }

    @Override
    public int countUniversalRecord() {
        return repo.getCount();
    }
}
