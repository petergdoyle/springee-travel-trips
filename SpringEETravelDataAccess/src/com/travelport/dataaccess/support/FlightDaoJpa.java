/*
 */
package com.travelport.dataaccess.support;

import com.travelport.dataaccess.FlightDao;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.travelport.domain.AirSegment;
import com.travelport.domain.Flight;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("flightDao")
@Transactional
public class FlightDaoJpa implements FlightDao {

    private static final long serialVersionUID = -7390765404196252850L;
    @PersistenceContext
    EntityManager em = null;

    public void create(Flight flight) {
        AirSegment airSegmentId = flight.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId = em.getReference(airSegmentId.getClass(), airSegmentId.getId());
            flight.setAirSegmentId(airSegmentId);
        }
        em.persist(flight);
        if (airSegmentId != null) {
            airSegmentId.getFlightList().add(flight);
            airSegmentId = em.merge(airSegmentId);
        }
    }

    public void edit(Flight flight) throws NonexistentEntityException, Exception {
        try {
            Flight persistentFlight = em.find(Flight.class, flight.getId());
            AirSegment airSegmentIdOld = persistentFlight.getAirSegmentId();
            AirSegment airSegmentIdNew = flight.getAirSegmentId();
            if (airSegmentIdNew != null) {
                airSegmentIdNew = em.getReference(airSegmentIdNew.getClass(), airSegmentIdNew.getId());
                flight.setAirSegmentId(airSegmentIdNew);
            }
            flight = em.merge(flight);
            if (airSegmentIdOld != null && !airSegmentIdOld.equals(airSegmentIdNew)) {
                airSegmentIdOld.getFlightList().remove(flight);
                airSegmentIdOld = em.merge(airSegmentIdOld);
            }
            if (airSegmentIdNew != null && !airSegmentIdNew.equals(airSegmentIdOld)) {
                airSegmentIdNew.getFlightList().add(flight);
                airSegmentIdNew = em.merge(airSegmentIdNew);
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = flight.getId();
                if (findFlight(id) == null) {
                    throw new NonexistentEntityException("The flight with id " + id + " no longer exists.");
                }
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        Flight flight;
        try {
            flight = em.getReference(Flight.class, id);
            flight.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The flight with id " + id + " no longer exists.", enfe);
        }
        AirSegment airSegmentId = flight.getAirSegmentId();
        if (airSegmentId != null) {
            airSegmentId.getFlightList().remove(flight);
            airSegmentId = em.merge(airSegmentId);
        }
        em.remove(flight);
    }

    public List<Flight> findFlightEntities() {
        return findFlightEntities(true, -1, -1);
    }

    public List<Flight> findFlightEntities(int maxResults, int firstResult) {
        return findFlightEntities(false, maxResults, firstResult);
    }

    private List<Flight> findFlightEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Flight.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Flight findFlight(Long id) {
        return em.find(Flight.class, id);
    }

    public int getFlightCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Flight> rt = cq.from(Flight.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
