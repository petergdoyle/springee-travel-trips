/*
 */
package com.springeetravel.manager;

import com.springeetravel.dataaccess.UniversalRecordService;
import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter
 */
@Service
public class UniversalRecordsServiceManager {

    @Autowired
    private UniversalRecordService dao;

    public UniversalRecord retrieveUniversalRecordByLocatorCode(String locatorCode) {
        return dao.findByLocatorCode(locatorCode);
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
}
