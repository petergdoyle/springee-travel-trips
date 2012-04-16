/*
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.UniversalRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
public interface UniversalRecordDao {

    @Transactional(readOnly = true)
    UniversalRecord find(String locatorCode);
}
