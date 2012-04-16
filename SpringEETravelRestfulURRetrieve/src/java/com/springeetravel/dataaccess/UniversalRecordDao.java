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
public interface UniversalRecordDao {

    UniversalRecord findByLocatorCode(String locatorCode);

    List<UniversalRecord> findByTicketedDate(Date fromDate, Date toDate);

    List<UniversalRecord> findByTicketedAgent(String agentId);
}
