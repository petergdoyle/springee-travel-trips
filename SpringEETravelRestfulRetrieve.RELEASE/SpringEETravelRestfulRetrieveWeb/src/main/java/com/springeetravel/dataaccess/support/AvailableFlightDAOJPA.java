/*
 */
package com.springeetravel.dataaccess.support;

import com.springeetravel.dataaccess.AvailableFlightDAO;
import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.UniversalRecord;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("availableFlightDAOJPA")
@Transactional(readOnly = true)
public class AvailableFlightDAOJPA implements AvailableFlightDAO, Serializable {

    private static final long serialVersionUID = -8450128008139868051L;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AvailableFlight> findByDepartureAirportCode(String departureAirportCode, Date departureTime, String arrivalAirportCode, Date arrivalTime) {

        List<AvailableFlight> match = null;
        Query query = em.createNamedQuery("AvailableFlight.findBySearchCriteria");
        query.setParameter("departureAirportCode", departureAirportCode);
        List resultList = query.getResultList();
        if (resultList != null) {
            match = new ArrayList<AvailableFlight>();
            match.addAll(resultList);
        }
        return match;
    }

    public List<AvailableFlight> findAll() {
        return findRange(true, -1, -1);
    }

    public List<AvailableFlight> find(int maxResults, int firstResult) {
        return findRange(false, maxResults, firstResult);
    }

    public List<AvailableFlight> findRange(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AvailableFlight.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }
}
