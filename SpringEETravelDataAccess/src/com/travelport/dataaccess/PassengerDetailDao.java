/*
 */
package com.travelport.dataaccess;

import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.PassengerDetail;
import java.util.List;

/**
 *
 * @author peter
 */
public interface PassengerDetailDao {

    void create(PassengerDetail passengerDetail);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(PassengerDetail passengerDetail) throws NonexistentEntityException, Exception;

    PassengerDetail findPassengerDetail(Long id);

    List<PassengerDetail> findPassengerDetailEntities();

    List<PassengerDetail> findPassengerDetailEntities(int maxResults, int firstResult);

    int getPassengerDetailCount();
    
}
