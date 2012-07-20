/*
 */
package com.springeetravel.manager;

import com.springeetravel.dataaccess.UniversalRecordRetrieveDAO;
import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Named
public class UniversalRecordRetrieveService {

    @Inject
    @Named("universalRecordRetrieveDAOJPA")
    private UniversalRecordRetrieveDAO dao;
    private Mapper mapper = new DozerBeanMapper();

    public UniversalRecord retrieveUniversalRecordByLocatorCode(String locatorCode) {
        UniversalRecord ur = dao.findByLocatorCode(locatorCode);
        if (ur == null) {
            return null;
        }
        UniversalRecord copy = copy(ur);
        return copy;
    }

    public List<UniversalRecord> retrieveUniversalRecordByBookingPassengerName(String passengerName) {
        return dao.findByBookingPassengerName(passengerName);
    }

    public List<UniversalRecord> retrieveUniversalRecordByAirTicketedDate(Date fromDate, Date toDate) {
        return dao.findByAirTicketedDate(fromDate, toDate);
    }

    public List<UniversalRecord> retrieveUniversalRecordByAgent(String agentId) {
        return dao.findByAgent(agentId);
    }

    public List<UniversalRecord> retrieveUniversalRecordByAgency(String agencyId) {
        return dao.findByAgency(agencyId);
    }

    private UniversalRecord copy(UniversalRecord ur) {
        return mapper.map(ur, UniversalRecord.class);
    }

    public List<UniversalRecord> searchUniversalRecord(UniversalRecord ur) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public List<UniversalRecord> retrieveAll() {
        return dao.findAll();
    }
}
