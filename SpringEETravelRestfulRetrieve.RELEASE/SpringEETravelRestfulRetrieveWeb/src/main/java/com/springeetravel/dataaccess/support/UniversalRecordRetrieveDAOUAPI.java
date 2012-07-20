/*
 */
package com.springeetravel.dataaccess.support;

import com.springeetravel.dataaccess.UniversalRecordRetrieveDAO;
import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author peter
 */
@Named("universalRecordRetrieveDAOUAPI")
public class UniversalRecordRetrieveDAOUAPI implements UniversalRecordRetrieveDAO {

    public UniversalRecord findByLocatorCode(String locatorCode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UniversalRecord> findByAirTicketedDate(Date fromDate, Date toDate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UniversalRecord> findByAgent(String agentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UniversalRecord> findByAgency(String agencyId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UniversalRecord> findByBookingPassengerName(String passengerName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UniversalRecord> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
