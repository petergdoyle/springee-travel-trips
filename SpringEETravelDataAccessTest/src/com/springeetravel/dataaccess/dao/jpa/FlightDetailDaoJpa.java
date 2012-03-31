/*
 */
package com.springeetravel.dataaccess.dao.jpa;

import com.springeetravel.dataaccess.dao.FlightDetailDao;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.springeetravel.domain.AirSegment;
import com.springeetravel.domain.FlightDetail;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("flightDetailDao")
@Transactional
public class FlightDetailDaoJpa implements FlightDetailDao {

    private static final long serialVersionUID = -7390765404196252850L;
    @PersistenceContext
    EntityManager em = null;

    public void create(FlightDetail flightDetail) {
        AirSegment airSegmentId = flightDetail.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId = em.getReference(airSegmentId.getClass(), airSegmentId.getId());
            flightDetail.setAirSegmentId(airSegmentId);
        }
        em.persist(flightDetail);
        if (airSegmentId != null) {
            FlightDetail oldFlightOfAirSegmentId = airSegmentId.getFlightDetail();
            if (oldFlightOfAirSegmentId != null) {
                oldFlightOfAirSegmentId.setAirSegmentId(null);
                oldFlightOfAirSegmentId = em.merge(oldFlightOfAirSegmentId);
            }
            airSegmentId.setFlightDetail(flightDetail);
            airSegmentId = em.merge(airSegmentId);
        }
    }

    public void edit(FlightDetail flightDetail) throws NonexistentEntityException {
        try {
            FlightDetail persistentFlight = em.find(FlightDetail.class, flightDetail.getId());
            AirSegment airSegmentIdOld = persistentFlight.getAirSegmentId();
            AirSegment airSegmentIdNew = flightDetail.getAirSegmentId();
            if (airSegmentIdNew != null) {
                airSegmentIdNew = em.getReference(airSegmentIdNew.getClass(), airSegmentIdNew.getId());
                flightDetail.setAirSegmentId(airSegmentIdNew);
            }
            flightDetail = em.merge(flightDetail);
            if (airSegmentIdOld != null && !airSegmentIdOld.equals(airSegmentIdNew)) {
                airSegmentIdOld.setFlightDetail(null);
                airSegmentIdOld = em.merge(airSegmentIdOld);
            }
            if (airSegmentIdNew != null && !airSegmentIdNew.equals(airSegmentIdOld)) {
                FlightDetail oldFlightOfAirSegmentId = airSegmentIdNew.getFlightDetail();
                if (oldFlightOfAirSegmentId != null) {
                    oldFlightOfAirSegmentId.setAirSegmentId(null);
                    oldFlightOfAirSegmentId = em.merge(oldFlightOfAirSegmentId);
                }
                airSegmentIdNew.setFlightDetail(flightDetail);
                airSegmentIdNew = em.merge(airSegmentIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = flightDetail.getId();
                if (find(id) == null) {
                    throw new NonexistentEntityException("The flightDetail with id " + id + " no longer exists.");
                }
            }

        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        FlightDetail flightDetail;
        try {
            flightDetail = em.getReference(FlightDetail.class, id);
            flightDetail.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The flightDetail with id " + id + " no longer exists.", enfe);
        }
        AirSegment airSegmentId = flightDetail.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId.setFlightDetail(null);
            airSegmentId = em.merge(airSegmentId);
        }
        em.remove(flightDetail);
    }

    public List<FlightDetail> find() {
        return find(true, -1, -1);
    }

    public List<FlightDetail> find(int maxResults, int firstResult) {
        return find(false, maxResults, firstResult);
    }

    private List<FlightDetail> find(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(FlightDetail.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public FlightDetail find(Long id) {
        return em.find(FlightDetail.class, id);
    }

    public int getCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<FlightDetail> rt = cq.from(FlightDetail.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
