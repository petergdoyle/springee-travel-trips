/*
 */
package com.springeetravel.dataaccess.springdata.jpa;

import com.springeetravel.domain.UniversalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author peter
 */
public interface UniversalRecordRepositoryJpa extends JpaRepository<UniversalRecord, Long> {
}
