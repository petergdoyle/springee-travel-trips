/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.UniversalRecord;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author peter
 */
@Local
public interface UniversalRecordFacadeLocal {

    void create(UniversalRecord universalRecord);

    void edit(UniversalRecord universalRecord);

    void remove(UniversalRecord universalRecord);

    UniversalRecord find(Object id);

    List<UniversalRecord> findAll();

    List<UniversalRecord> findRange(int[] range);

    int count();
    
}
