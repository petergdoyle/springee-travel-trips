/*
 */
package com.springeetravel.dataaccess.dao.jpa;

import com.springeetravel.dataaccess.dao.AvailableFlightDao;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.AvailableFlight;
import java.io.Serializable;
import java.util.Date;
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
@Named("availableFlightDao")
@Transactional
public class AvailableFlightDaoJpa implements Serializable, AvailableFlightDao {

    private static final long serialVersionUID = -3274686283994347984L;
    @PersistenceContext
    EntityManager em = null;

    @Override
    public List<AvailableFlight> find(String departureAirportCode, Date departureDate, String arrivalAirportCode, Date arrivalDate) {
        Query query = em.createNamedQuery("AvailableFlight.findByDepartureAirportCode");
        query.setParameter("departureAirportCode", departureAirportCode);
        return query.getResultList();
    }

    @Override
    public void create(AvailableFlight availableFlight) {
        em.persist(availableFlight);
    }

    @Override
    public void edit(AvailableFlight availableFlight) throws NonexistentEntityException {
        try {
            availableFlight = em.merge(availableFlight);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = availableFlight.getId();
                if (find(id) == null) {
                    throw new NonexistentEntityException("The availableFlight with id " + id + " no longer exists.");
                }
            }
        }
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        AvailableFlight availableFlight;
        try {
            availableFlight = em.getReference(AvailableFlight.class, id);
            availableFlight.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The availableFlight with id " + id + " no longer exists.", enfe);
        }
        em.remove(availableFlight);
    }

    @Override
    public List<AvailableFlight> find() {
        return findAvailableFlightEntities(true, -1, -1);
    }

    @Override
    public List<AvailableFlight> find(int maxResults, int firstResult) {
        return findAvailableFlightEntities(false, maxResults, firstResult);
    }

    private List<AvailableFlight> findAvailableFlightEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AvailableFlight.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public AvailableFlight find(Long id) {
        return em.find(AvailableFlight.class, id);
    }

    @Override
    public int getCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<AvailableFlight> rt = cq.from(AvailableFlight.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
