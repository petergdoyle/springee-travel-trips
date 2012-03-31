/*
 */
package com.travelport.dataaccess.support;

import com.travelport.dataaccess.PassengerDetailDao;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.travelport.domain.AirSegment;
import com.travelport.domain.PassengerDetail;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("passengerDetailDao")
@Transactional
public class PassengerDetailDaoJpa implements PassengerDetailDao, Serializable {

    private static final long serialVersionUID = 2890182824975483644L;
    @PersistenceContext
    EntityManager em = null;

    @Override
    public void create(PassengerDetail passengerDetail) {
        AirSegment airSegmentId = passengerDetail.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId = em.getReference(airSegmentId.getClass(), airSegmentId.getId());
            passengerDetail.setAirSegmentId(airSegmentId);
        }
        em.persist(passengerDetail);
        if (airSegmentId != null) {
            airSegmentId.getPassengerDetailList().add(passengerDetail);
            airSegmentId = em.merge(airSegmentId);
        }
    }

    @Override
    public void edit(PassengerDetail passengerDetail) throws NonexistentEntityException, Exception {
        try {
            PassengerDetail persistentPassengerDetail = em.find(PassengerDetail.class, passengerDetail.getId());
            AirSegment airSegmentIdOld = persistentPassengerDetail.getAirSegmentId();
            AirSegment airSegmentIdNew = passengerDetail.getAirSegmentId();
            if (airSegmentIdNew != null) {
                airSegmentIdNew = em.getReference(airSegmentIdNew.getClass(), airSegmentIdNew.getId());
                passengerDetail.setAirSegmentId(airSegmentIdNew);
            }
            passengerDetail = em.merge(passengerDetail);
            if (airSegmentIdOld != null && !airSegmentIdOld.equals(airSegmentIdNew)) {
                airSegmentIdOld.getPassengerDetailList().remove(passengerDetail);
                airSegmentIdOld = em.merge(airSegmentIdOld);
            }
            if (airSegmentIdNew != null && !airSegmentIdNew.equals(airSegmentIdOld)) {
                airSegmentIdNew.getPassengerDetailList().add(passengerDetail);
                airSegmentIdNew = em.merge(airSegmentIdNew);
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = passengerDetail.getId();
                if (findPassengerDetail(id) == null) {
                    throw new NonexistentEntityException("The passengerDetail with id " + id + " no longer exists.");
                }
            }
        }
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        PassengerDetail passengerDetail;
        try {
            passengerDetail = em.getReference(PassengerDetail.class, id);
            passengerDetail.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The passengerDetail with id " + id + " no longer exists.", enfe);
        }
        AirSegment airSegmentId = passengerDetail.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId.getPassengerDetailList().remove(passengerDetail);
            airSegmentId = em.merge(airSegmentId);
        }
        em.remove(passengerDetail);
    }

    @Override
    public List<PassengerDetail> findPassengerDetailEntities() {
        return findPassengerDetailEntities(true, -1, -1);
    }

    @Override
    public List<PassengerDetail> findPassengerDetailEntities(int maxResults, int firstResult) {
        return findPassengerDetailEntities(false, maxResults, firstResult);
    }

    private List<PassengerDetail> findPassengerDetailEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(PassengerDetail.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public PassengerDetail findPassengerDetail(Long id) {
        return em.find(PassengerDetail.class, id);
    }

    @Override
    public int getPassengerDetailCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<PassengerDetail> rt = cq.from(PassengerDetail.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
