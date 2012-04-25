/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.PassengerDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public interface PassengerDetailDao {

    void create(PassengerDetail passengerDetail);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(PassengerDetail passengerDetail) throws NonexistentEntityException;

    PassengerDetail find(Long id);

    List<PassengerDetail> findAllForeignPassengers(String flightNumber, Date flightDate);

    List<PassengerDetail> findSpecialCustomers(String flightNumber, Date flightDate);

    List<PassengerDetail> find();

    List<PassengerDetail> find(int maxResults, int firstResult);

    int getCount();
}
