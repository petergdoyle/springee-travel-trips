/*
 */
package com.springeetravel.dataaccess.support;

import com.springeetravel.dataaccess.UniversalRecordRetrieveDAO;
import com.springeetravel.domain.UniversalRecord;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("universalRecordRetrieveDAOJPA")
@Transactional(readOnly = true)
public class UniversalRecordRetrieveDAOJPA implements UniversalRecordRetrieveDAO, Serializable {

    private static final long serialVersionUID = -7996692047754929089L;
    @PersistenceContext
    private EntityManager em;

    @Override
    public UniversalRecord findByLocatorCode(String locatorCode) {
        UniversalRecord match = null;
        Query query = em.createNamedQuery("UniversalRecord.findLocatorCode");
        query.setParameter("locatorCode", locatorCode);
        Object singleResult = query.getSingleResult();
        if (singleResult != null) {
            match = (UniversalRecord) singleResult;
        }
        return match;
    }

    @Override
    public List<UniversalRecord> findByAirTicketedDate(Date fromDate, Date toDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UniversalRecord> findByAgent(String agentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UniversalRecord> findByAgency(String agencyId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UniversalRecord> findByBookingPassengerName(String passengerName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private UniversalRecord find(Long id) {
        return em.find(UniversalRecord.class, id);
    }

    public List<UniversalRecord> findAll() {
        return findRange(true, -1, -1);
    }

    public List<UniversalRecord> find(int maxResults, int firstResult) {
        return findRange(false, maxResults, firstResult);
    }

    public List<UniversalRecord> findRange(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UniversalRecord.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }
}
