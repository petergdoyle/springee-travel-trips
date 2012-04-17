/*
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public interface UniversalRecordService {

    UniversalRecord findByLocatorCode(String locatorCode);

    List<UniversalRecord> findByAirTicketedDate(Date fromDate, Date toDate);

    List<UniversalRecord> findByAgent(String agentId);

    List<UniversalRecord> findByAgency(String agencyId);

    List<UniversalRecord> findByBookingPassengerName(String passengerName);
}
