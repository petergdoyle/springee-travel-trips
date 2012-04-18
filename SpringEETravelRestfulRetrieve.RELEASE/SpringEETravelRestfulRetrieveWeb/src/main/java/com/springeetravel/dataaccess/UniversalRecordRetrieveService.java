/*
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
public interface UniversalRecordRetrieveService {

    UniversalRecord findByLocatorCode(String locatorCode);

    List<UniversalRecord> findByAirTicketedDate(Date fromDate, Date toDate);

    List<UniversalRecord> findByAgent(String agentId);

    List<UniversalRecord> findByAgency(String agencyId);

    List<UniversalRecord> findByBookingPassengerName(String passengerName);
}
