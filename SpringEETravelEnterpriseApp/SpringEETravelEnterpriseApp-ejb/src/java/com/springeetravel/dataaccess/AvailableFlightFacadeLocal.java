/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.AvailableFlight;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author peter
 */
@Local
public interface AvailableFlightFacadeLocal {

    void create(AvailableFlight availableFlight);

    void edit(AvailableFlight availableFlight);

    void remove(AvailableFlight availableFlight);

    AvailableFlight find(Object id);

    List<AvailableFlight> findAll();

    List<AvailableFlight> findRange(int[] range);

    int count();
    
}
