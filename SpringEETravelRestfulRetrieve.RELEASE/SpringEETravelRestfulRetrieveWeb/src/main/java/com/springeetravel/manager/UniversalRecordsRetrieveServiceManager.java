/*
 */
package com.springeetravel.manager;

import com.springeetravel.dataaccess.UniversalRecordRetrieveService;
import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Named
public class UniversalRecordsRetrieveServiceManager {

    @Inject
    private UniversalRecordRetrieveService service;

    public UniversalRecord retrieveUniversalRecordByLocatorCode(String locatorCode) {
        return service.findByLocatorCode(locatorCode);
    }

    public List<UniversalRecord> retrieveUniversalRecordByBookingPassengerName(String passengerName) {
        return service.findByBookingPassengerName(passengerName);
    }

    public List<UniversalRecord> retrieveUniversalRecordByAirTicketedDate(Date fromDate, Date toDate) {
        return service.findByAirTicketedDate(fromDate, toDate);
    }

    public List<UniversalRecord> retrieveUniversalRecordByAgent(String agentId) {
        return service.findByAgent(agentId);
    }

    public List<UniversalRecord> retrieveUniversalRecordByAgency(String agencyId) {
        return service.findByAgency(agencyId);
    }
}
