/*
 */
package com.travelport.dataaccess.support;

import com.travelport.dataaccess.UniversalRecordDao;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.UniversalRecord;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("universalRecordDao")
@Transactional
public class UniversalRecordDaoJpa implements UniversalRecordDao, Serializable {

    private static final long serialVersionUID = -5353066644553948977L;
    @PersistenceContext
    private EntityManager em;

    public void create(UniversalRecord universalRecord) {
        em.persist(universalRecord);
    }

    public void edit(UniversalRecord universalRecord) throws NonexistentEntityException, Exception {
        try {
            universalRecord = em.merge(universalRecord);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = universalRecord.getId();
                if (findUniversalRecord(id) == null) {
                    throw new NonexistentEntityException("The universalRecord with id " + id + " no longer exists.");
                }
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        UniversalRecord universalRecord;
        try {
            universalRecord = em.getReference(UniversalRecord.class, id);
            universalRecord.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The universalRecord with id " + id + " no longer exists.", enfe);
        }
        em.remove(universalRecord);
        em.getTransaction().commit();
    }

    public List<UniversalRecord> findUniversalRecordEntities() {
        return findUniversalRecordEntities(true, -1, -1);
    }

    public List<UniversalRecord> findUniversalRecordEntities(int maxResults, int firstResult) {
        return findUniversalRecordEntities(false, maxResults, firstResult);
    }

    private List<UniversalRecord> findUniversalRecordEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UniversalRecord.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public UniversalRecord findUniversalRecord(Long id) {
        return em.find(UniversalRecord.class, id);
    }

    public int getUniversalRecordCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<UniversalRecord> rt = cq.from(UniversalRecord.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
