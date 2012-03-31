/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.dao.UniversalRecordXmlDao;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.UniversalRecordObject;
import com.springeetravel.domain.UniversalRecordXml;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("universalRecordXmlManager")
@Transactional
public class UniversalRecordXmlManager extends AbstractUniversalRecordManager {

    @Inject
    private UniversalRecordXmlDao repo;

    @Override
    public void saveUniversalRecord(UniversalRecord ur) {
        Date time = Calendar.getInstance().getTime();
        UniversalRecordXml urx = new UniversalRecordXml();
        urx.setCreateDate(time);
        urx.setUniversalRecord(ur);
        repo.create(urx);
        ur.setId(urx.getId());
    }

    @Override
    public UniversalRecord retrieveUniversalRecord(Long id) {
//        UniversalRecordXml find = repo.find(id);
        UniversalRecordXml find = repo.findById(id);
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
