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
        Long id = null;
        try {
            id = Long.parseLong(locatorCode);
        } catch (NumberFormatException nfe) {
            throw new DataAccessException("cannot parse number. found" + locatorCode);
        }
        return find(id);
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
}
