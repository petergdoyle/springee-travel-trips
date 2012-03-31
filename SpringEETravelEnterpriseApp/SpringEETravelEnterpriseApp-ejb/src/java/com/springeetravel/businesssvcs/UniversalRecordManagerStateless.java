/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.UniversalRecordFacadeLocal;
import com.springeetravel.domain.UniversalRecord;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author peter
 */
@Stateless
public class UniversalRecordManagerStateless extends AbstractUniversalRecordManager {

    @EJB
    private UniversalRecordFacadeLocal repo;

    @Override
    public void saveUniversalRecord(UniversalRecord ur) {
        repo.create(ur);
    }

    @Override
    public UniversalRecord retrieveUniversalRecord(Long id) {
        return repo.find(id);
    }

    @Override
    public int countUniversalRecord() {
        return repo.count();
    }
}
