/*
 */
package com.springeetravel.dataaccess.springdata.mongo;

import com.springeetravel.dataaccess.dao.UniversalRecordDao;
import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.UniversalRecord;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

/**
 *
 * @author peter
 */
@Named("universalRecordRepositoryMongo")
public class UniversalRecordRepositoryMongo implements UniversalRecordDao {

    private final String docCollectionName = "universalRecords";
    @Inject
    MongoTemplate template;

    @Override
    public void create(UniversalRecord universalRecord) {
        template.save(universalRecord, docCollectionName);
    }

    @Override
    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(UniversalRecord universalRecord) throws IllegalOrphanException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UniversalRecord find(String id) {
        return template.findById(id, UniversalRecord.class, docCollectionName);
        
//        QUniversalRecord universalRecord = QUniversalRecord.universalRecord;
//        List<UniversalRecord> list = from(universalRecord).where(universalRecord.id.eq(id)).list(universalRecord);
//        return list.get(0);
    }

    @Override
    public List<UniversalRecord> find() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UniversalRecord> find(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
//        Criteria.where(docCollectionName)
        Long count = template.count(null, UniversalRecord.class);
        return count.intValue();
    }
}
