/*
 */
package com.springeetravel.dataaccess.support;

import com.springeetravel.dataaccess.AvailableFlightDAO;
import com.springeetravel.domain.AvailableFlight;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author peter
 */
public class AvailableFlightDAOJPA implements AvailableFlightDAO {
    
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
}
