/*
 */
package com.travelport.dataaccess.support;

import com.travelport.dataaccess.FormOfPaymentDao;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.travelport.domain.AirSegment;
import com.travelport.domain.FormOfPayment;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("formOfPaymentDao")
@Transactional
public class FormOfPaymentDaoJpa implements FormOfPaymentDao, Serializable {

    private static final long serialVersionUID = -4833773339365562070L;
    @PersistenceContext
    EntityManager em = null;

    public void create(FormOfPayment formOfPayment) {
        AirSegment airSegmentId = formOfPayment.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId = em.getReference(airSegmentId.getClass(), airSegmentId.getId());
            formOfPayment.setAirSegmentId(airSegmentId);
        }
        em.persist(formOfPayment);
        if (airSegmentId != null) {
            airSegmentId.getFormOfPaymentList().add(formOfPayment);
            airSegmentId = em.merge(airSegmentId);
        }
    }

    public void edit(FormOfPayment formOfPayment) throws NonexistentEntityException {
        try {
            FormOfPayment persistentFormOfPayment = em.find(FormOfPayment.class, formOfPayment.getId());
            AirSegment airSegmentIdOld = persistentFormOfPayment.getAirSegmentId();
            AirSegment airSegmentIdNew = formOfPayment.getAirSegmentId();
            if (airSegmentIdNew != null) {
                airSegmentIdNew = em.getReference(airSegmentIdNew.getClass(), airSegmentIdNew.getId());
                formOfPayment.setAirSegmentId(airSegmentIdNew);
            }
            formOfPayment = em.merge(formOfPayment);
            if (airSegmentIdOld != null && !airSegmentIdOld.equals(airSegmentIdNew)) {
                airSegmentIdOld.getFormOfPaymentList().remove(formOfPayment);
                airSegmentIdOld = em.merge(airSegmentIdOld);
            }
            if (airSegmentIdNew != null && !airSegmentIdNew.equals(airSegmentIdOld)) {
                airSegmentIdNew.getFormOfPaymentList().add(formOfPayment);
                airSegmentIdNew = em.merge(airSegmentIdNew);
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = formOfPayment.getId();
                if (findFormOfPayment(id) == null) {
                    throw new NonexistentEntityException("The formOfPayment with id " + id + " no longer exists.");
                }
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        FormOfPayment formOfPayment;
        try {
            formOfPayment = em.getReference(FormOfPayment.class, id);
            formOfPayment.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The formOfPayment with id " + id + " no longer exists.", enfe);
        }
        AirSegment airSegmentId = formOfPayment.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId.getFormOfPaymentList().remove(formOfPayment);
            airSegmentId = em.merge(airSegmentId);
        }
        em.remove(formOfPayment);
    }

    public List<FormOfPayment> findFormOfPaymentEntities() {
        return findFormOfPaymentEntities(true, -1, -1);
    }

    public List<FormOfPayment> findFormOfPaymentEntities(int maxResults, int firstResult) {
        return findFormOfPaymentEntities(false, maxResults, firstResult);
    }

    private List<FormOfPayment> findFormOfPaymentEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(FormOfPayment.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public FormOfPayment findFormOfPayment(Long id) {
        return em.find(FormOfPayment.class, id);
    }

    public int getFormOfPaymentCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<FormOfPayment> rt = cq.from(FormOfPayment.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
